package Main.View.Renderers.StateViewports;

import Main.Model.State.StatState;
import Main.Model.Stats.Stats;
import Main.View.Viewport;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class StatStateViewport extends StateViewport {
    private final String FONT_USE = "Calibri (Body)";

    //SCREEN DIMENSION
    private final int WIDTH = 700;
    private final int HEIGHT = 700;

    //INVENTORY TITLE
    private final int TITLE_START_X = (int) (WIDTH * 0.1);
    private final int TITLE_START_Y = (int) (HEIGHT * 0.05);
    private final int TITLE_WIDTH = (int) (WIDTH * 0.8);
    private final int TITLE_HEIGHT = (int) (HEIGHT * 0.15);


    //INVETORY DIMENSION
    private final int STAT_VIEW_X_START = (int) (WIDTH * 0.1);
    private final int STAT_VIEW_Y_START = TITLE_START_Y + TITLE_HEIGHT;
    private final int STAT_VIEW_WIDTH = (int) (WIDTH * 0.8);
    private final int STAT_VIEW_HEIGHT = (int) (HEIGHT * 0.52);

    private Font font;
    private Font smallFont = new Font("Calibri (Body)", Font.PLAIN, 30);
    private Font largeFont;
    private final Font titleFont = new Font("Calibri (Body)", Font.BOLD, (int)(TITLE_WIDTH*0.1));



    private Viewport viewport;
    private PlayStateViewport playStateViewport;
    private StatState statState;

    public StatStateViewport(Viewport view, PlayStateViewport playStateViewport, StatState statState) {
        this.viewport = view;
        this.playStateViewport = playStateViewport;
        this.statState = statState;
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
        String title = "Stats";
        FontMetrics fm = g.getFontMetrics(titleFont);
        Rectangle2D titleRect = fm.getStringBounds(title, g);

        // Get the location of the title
        int titleX = TITLE_START_X + TITLE_WIDTH / 2 - (int) titleRect.getWidth() / 2;
        int titleY = TITLE_START_Y + (int) titleRect.getHeight() + titleMargin;

        // Draw the title
        g.setColor(Color.lightGray);
        g.drawString(title, titleX, titleY);

    }

    private void renderStats(Graphics g){
        BufferedImage overImage = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g2 = overImage.getGraphics();

        g2.setFont(smallFont);
        FontMetrics fm = g2.getFontMetrics();

        // Draw the background
        g.setColor(new Color(25, 25, 25));
        g.fillRect(STAT_VIEW_X_START, STAT_VIEW_Y_START, STAT_VIEW_WIDTH, STAT_VIEW_HEIGHT);

        int x = 100;
        int y = 200;


        String stat[] = new String[13];
        stat[0] = "Strength: ";
        stat[1] = "Agility: ";
        stat[2] = "Intellect: ";
        stat[3] = "Hardiness: ";
        stat[4] = "Movement: ";
        stat[5] = "Action: ";
        stat[6] = "Life: ";
        stat[7] = "Mana: ";
        stat[8] = "Offense: ";
        stat[9] = "Defense: ";
        stat[10] = "Armor: ";
        stat[11] = "Experience: ";
        stat[12] = "Lives: ";

        Stats stats = statState.getStats();
        double value[] = new double[13];
        value[0] = stats.curStrength();
        value[1] = stats.curAgility();
        value[2] = stats.curIntellect();
        value[3] = stats.curHardiness();
        value[4] = stats.curMovement();
        value[5] = stats.curAction();
        value[6] = stats.curLife();
        value[7] = stats.curMana();
        value[8] = stats.curOffense();
        value[9] = stats.curDefense();
        value[10] = stats.curArmor();
        value[11] = stats.curExperience();
        value[12] = stats.curLives();


        Color defaultColor = Color.YELLOW;

        for(int i =0; i < 13; i++){
            g2.setColor(defaultColor);
            String current = stat[i] + ((double)Math.round(value[i] * 1000d) / 1000d);
            g2.drawString(current, x, y);
            y += fm.getHeight();
            if( i == 6) {
                x += 300;
                y = 200;
            }
        }

        g.drawImage(overImage, 0, 0, WIDTH, HEIGHT, null);
    }


}
