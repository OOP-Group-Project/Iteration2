package Main.View.Renderers.StateViewports;

import Main.Controller.Controller;
import Main.Controller.Manager.KeyboardManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.KeyBindingsState;
import Main.Model.State.StatState;
import Main.Model.State.StateEnum;
import Main.Model.Stats.Stats;
import Main.View.Viewport;
import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KeyBindingsStateViewport extends StateViewport {
    private final String FONT_USE = "Calibri (Body)";
    private boolean firstRender;
    private char firstChar;
    private char secondChar;
    private boolean isFirstDone = false;
    private boolean isSecondDone = false;

    //SCREEN DIMENSION
    private final int WIDTH = 800;
    private final int HEIGHT = 900;

    //INVENTORY TITLE
    private final int TITLE_START_X = (int) (WIDTH * 0.05);
    private final int TITLE_START_Y = (int) (HEIGHT * 0.05);
    private final int TITLE_WIDTH = (int) (WIDTH * 0.9);
    private final int TITLE_HEIGHT = (int) (HEIGHT * 0.15);


    //INVETORY DIMENSION
    private final int STAT_VIEW_X_START = (int) (WIDTH * 0.05);
    private final int STAT_VIEW_Y_START = TITLE_START_Y + TITLE_HEIGHT;
    private final int STAT_VIEW_WIDTH = (int) (WIDTH * 0.9);
    private final int STAT_VIEW_HEIGHT = (int) (HEIGHT * 0.52);

    private Font font;
    private Font smallFont = new Font("Calibri (Body)", Font.PLAIN, 20);
    private Font largeFont;
    private final Font titleFont = new Font("Calibri (Body)", Font.BOLD, (int)(TITLE_WIDTH*0.1));



    private Viewport viewport;
    private PlayStateViewport playStateViewport;
    private KeyBindingsState keyBindingsState;
    private Controller controller;

    public KeyBindingsStateViewport(Viewport view, PlayStateViewport playStateViewport, KeyBindingsState keyBindingsState, Controller controller) {
        this.viewport = view;
        this.playStateViewport = playStateViewport;
        this.keyBindingsState = keyBindingsState;
        this.controller = controller;
        firstRender = true;
    }


    @Override
    public void render(Graphics g) {
        //draw game in background
        playStateViewport.render(g);

        BufferedImage overImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g2 = overImage.getGraphics();

        renderTitle(g2);

        renderStats(g2);

        int w = viewport.getPxWidth();
        int h = viewport.getPxHeight();

        g.drawImage(overImage, (int)(w*0.1), (int)(h*0.1) , (int)(w*0.8) ,(int)(h*0.75) , null);
    }

    private void renderTitle(Graphics g) {
        int titleMargin = 5;
        int instMargin = 15;

        // Draw the background
        g.setColor(new Color(25, 25, 25));
        g.fillRect(TITLE_START_X, TITLE_START_Y, TITLE_WIDTH, TITLE_HEIGHT);

        // Get ready to draw the title
        g.setFont(titleFont);
        String title = "Key Bindings";
        FontMetrics fm = g.getFontMetrics(titleFont);
        Rectangle2D titleRect = fm.getStringBounds(title, g);

        // Get the location of the title
        int titleX = TITLE_START_X + TITLE_WIDTH / 2 - (int) titleRect.getWidth() / 2;
        int titleY = TITLE_START_Y + (int) titleRect.getHeight() + titleMargin;

        // Draw the title
        g.setColor(Color.lightGray);
        g.drawString(title, titleX, titleY);

    }

    private void renderStats(Graphics g) {

        KeyboardManager keyManager = controller.getKeyManager();
        HashMap<Integer, UserActionEnum> keyboardActionMapping = keyManager.getKeyboardActionMapping();
        keyBindingsState.sendKeyManager(keyboardActionMapping);
        keyBindingsState.sendController(controller);
        Iterator iter = keyboardActionMapping.entrySet().iterator();
        int length = keyboardActionMapping.size();

        BufferedImage overImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g2 = overImage.getGraphics();

        g2.setFont(smallFont);
        FontMetrics fm = g2.getFontMetrics();

        // Draw the background
        g.setColor(new Color(25, 25, 25));
        g.fillRect(STAT_VIEW_X_START, STAT_VIEW_Y_START, STAT_VIEW_WIDTH, STAT_VIEW_HEIGHT * 2);

        int x = 60;
        int y = 200;

        Color defaultColor = Color.YELLOW;
        Color selectedColor = Color.RED;

        int i = 0;
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            String current = KeyEvent.getKeyText(pair.getKey().hashCode()) + " = " + pair.getValue();

            Rectangle2D rectangle = fm.getStringBounds(current,g2);

            if(i == keyBindingsState.getCurrentIndex()){
                g2.setColor(selectedColor);
                g2.drawString(current, x, y);
            } else {
                g2.setColor(defaultColor);
                g2.drawString(current, x, y);
            }
            ++i;
            y += fm.getHeight();
            if ((i == length / 3) || (i == length * 2 / 3)) {
                x += 190;
                y = 200;
            }
        }


        g.drawImage(overImage, 0, 0, WIDTH, HEIGHT, null);


        }

    }

