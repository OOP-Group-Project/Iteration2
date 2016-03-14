package Main.View.Renderers.StateViewports;

import Main.Model.Inventory.Inventory;
import Main.Model.State.InventoryState;
import Main.Model.State.PauseState;
import Main.Model.State.TalkState;
import Main.View.Viewport;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by Walkhard on 3/12/2016.
 */
public class TalkStateViewport extends StateViewport {


    private final double BG_START_X_POS_PERCENTAGE = 0.8;
    private final double BG_START_Y_POS_PERCENTAGE = 0.2;
    private final double BG_WIDTH_PERCENTAGE = 0.6;
    private final double BG_HEIGHT_PERCENTAGE = 0.6;

    private final Color BG_COLOR = new Color(0,0,0.8f,(float)0.75);

    //TTTLE
    private final String TITLE = "Interact";
    private final Font TITLE_FONT = new Font("Calibri (Body)", Font.BOLD, (int)(HEIGHT * 0.15));
    private final Color TITLE_COLOR = Color.lightGray;


    //OPTIONS
    private final int OPTION_START_Y_POS = (new FontMetrics(TITLE_FONT){}).getHeight();
    private final Font OPTION_FONT = new Font("Calibri (Body)", Font.BOLD, (int)(HEIGHT*0.05));
    private final Color OPTION_COLOR = Color.LIGHT_GRAY;
    private final Color OPTION_COLOR2 = Color.RED;

    private Viewport viewport;
    private TalkState talkState;
    private PlayStateViewport playStateViewport;

    public TalkStateViewport(Viewport viewport, PlayStateViewport playStateViewport, TalkState talkState){
        this.viewport = viewport;
        this.talkState = talkState;
        this.playStateViewport = playStateViewport;
    }


    @Override
    public void render(Graphics g){
        playStateViewport.render(g);

        BufferedImage overImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g2 = overImage.getGraphics();

        renderBackground(g2);

        renderTitle(g2);

        renderOptions(g2);

        int w = viewport.getPxHeight();
        int h = viewport.getPxWidth();

        g.drawImage(overImage, (int)(w*BG_START_X_POS_PERCENTAGE), (int)(h*BG_START_Y_POS_PERCENTAGE) , (int)(w*BG_WIDTH_PERCENTAGE) ,(int)(h*BG_HEIGHT_PERCENTAGE) , null);
    }

    private void renderBackground(Graphics g) {
        g.setColor(BG_COLOR);
        g.fillRect(0,0,WIDTH,HEIGHT);
    }

    private void renderTitle(Graphics g){
        g.setFont(TITLE_FONT);

        FontMetrics fm = g.getFontMetrics();
        Rectangle2D titleRect = fm.getStringBounds(TITLE, g);

        // Get the location of the title
        int titleX = WIDTH/2 - (int)(titleRect.getWidth()/2);
        int titleY = (int)(HEIGHT*0.15);

        // Draw the title
        g.setColor(TITLE_COLOR);
        g.drawString(TITLE, titleX, titleY);
    }

    private void renderOptions(Graphics g){

        g.setFont(OPTION_FONT);
        FontMetrics fm = g.getFontMetrics();

        int y = OPTION_START_Y_POS + 50;
//        for(TalkOption option: TalkOption.values()){
//
//            if(option.g)
//        }

    }
}
