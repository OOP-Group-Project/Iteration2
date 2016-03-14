package Main.View.Renderers.StateViewports;

import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.State.DeathState;
import Main.Model.State.PauseState;
import Main.Model.State.PauseState.PauseOption;
import Main.Model.State.PlayState;
import Main.View.Graphics.GraphicsAssets;
import Main.View.Viewport;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by mason on 3/10/16.
 */
public class DeathStateViewport extends StateViewport {

    //BACKGROUND OPTIONS
    //--dimension
    private final double BG_START_X_POS_PERCENTAGE = 0.2;
    private final double BG_START_Y_POS_PERCENTAGE = 0.2;
    private final double BG_WIDTH_PERCENTAGE = 0.6;
    private final double BG_HEIGHT_PERCENTAGE = 0.8;
    //--other
    private final Color BG_COLOR = new Color(0,0,0.8f,(float)0.75);


    //TITLE
    private final String TITLE = "Oh no you are dead!";
    private final Font TITLE_FONT = new Font("Calibri (Body)", Font.BOLD, (int)(HEIGHT*0.1));
    private final Color TITLE_COLOR = Color.lightGray;


    //OPTIONS
    private final int OPTION_START_Y_POS = (new FontMetrics(TITLE_FONT){}).getHeight();;
    private final Font OPTION_FONT = new Font("Calibri (Body)", Font.BOLD, (int)(HEIGHT*0.05));
    private final Color OPTION_COLOR = Color.LIGHT_GRAY;
    private final Color OPTION_COLOR2 = Color.RED;

    private Viewport viewport;
    private DeathState deathState;
    private PlayStateViewport playStateViewport;
    private String[] option;

    public DeathStateViewport(Viewport viewport, DeathState deathState, PlayStateViewport playStateViewport) {
        this.viewport = viewport;
        this.playStateViewport = playStateViewport;
        this.deathState = deathState;
        init();
    }

    public void init(){
        option = deathState.getOptionsToString();
    }

    public void render(Graphics g) {

        playStateViewport.render(g);

        BufferedImage overImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g2 = overImage.getGraphics();

        renderBackground(g2);

        renderTitle(g2);

        renderOptions(g2);

        int w = viewport.getPxWidth();
        int h = viewport.getPxHeight();

        g.drawImage(overImage, (int)(w*BG_START_X_POS_PERCENTAGE), (int)(h*BG_START_Y_POS_PERCENTAGE) , (int)(w*BG_WIDTH_PERCENTAGE) ,(int)(h*BG_HEIGHT_PERCENTAGE) , null);
    }

    private void renderBackground(Graphics g){
        g.setColor(BG_COLOR);
        g.fillRect(0, 0, WIDTH, HEIGHT/2);
    }

    private void renderTitle(Graphics g){

        g.setFont(TITLE_FONT);

        FontMetrics fm = g.getFontMetrics();
        Rectangle2D titleRect = fm.getStringBounds(TITLE, g);

        // Get the location of the title
        int titleX = WIDTH/2  - (int)(titleRect.getWidth()/2);
        int titleY = (int)(HEIGHT*0.15);

        // Draw the title
        g.setColor(TITLE_COLOR);
        g.drawString(TITLE, titleX, titleY);
    }

    private void renderOptions(Graphics g){

        int size = option.length;

        g.setFont(OPTION_FONT);
        FontMetrics fm = g.getFontMetrics();
        int x = WIDTH*4/10;


        int y = OPTION_START_Y_POS + 100;
        for(int i =0; i < option.length; i++){

            Rectangle2D rectangle = fm.getStringBounds(option[i],g);

            if(option[i].equals(deathState.getStringSelected())){
                g.setColor(OPTION_COLOR2);
                g.drawString(option[i], x, y);
            } else {
                g.setColor(OPTION_COLOR);
                g.drawString(option[i], x, y);
            }

            y += fm.getHeight();
        }

    }
}
