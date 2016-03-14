package Main.View.Renderers.StateViewports;

import Main.Model.Skills.Skills;
import Main.Model.State.SkillState;
import Main.Model.State.StatState;
import Main.Model.Stats.Stats;
import Main.View.Viewport;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SkillStateViewport extends StateViewport {
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
    private SkillState skillState;

    public SkillStateViewport(Viewport view, PlayStateViewport playStateViewport, SkillState skillState) {
        this.viewport = view;
        this.playStateViewport = playStateViewport;
        this.skillState = skillState;
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
        String title = "Skills";
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

        ArrayList<Skills> arrayList = skillState.getSkills();
        String[] name = new String[arrayList.size()];
        int[] level = new int[arrayList.size()];

        int i = 0;
        for (Skills skill : arrayList) {
            name[i] = skill.getSkillName();
            level[i] = skill.getLevel();
            i++;
        }


        Color defaultColor = Color.YELLOW;
        Color selectedColor = Color.RED;

        g2.setColor(defaultColor);
        String current = "Skill points available: " + skillState.getSkillPoints();
        g2.drawString(current, x, y);
        y += fm.getHeight();

        for(i =0; i < name.length; i++){
            g2.setColor(defaultColor);
            current = name[i] + ": " + level[i];
            if(i == skillState.getCurrentIndex()){
                g2.setColor(selectedColor);
                g2.drawString(current, x, y);
            } else {
                g2.setColor(defaultColor);
                g2.drawString(current, x, y);
            }
            y += fm.getHeight();
            if( i == 6) {
                x += 300;
                y = 200;
            }
        }

        g.drawImage(overImage, 0, 0, WIDTH, HEIGHT, null);
    }


}
