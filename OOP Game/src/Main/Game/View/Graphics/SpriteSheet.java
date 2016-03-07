package Main.Game.View.Graphics;

import java.awt.image.BufferedImage;

/**
 * Created by Michael on 3/5/16.
 */
public class SpriteSheet {

    private BufferedImage spriteSheet;

    public SpriteSheet(BufferedImage spriteSheet){
        this.spriteSheet = spriteSheet;
    }

    public BufferedImage crop(int x, int y, int width, int height){
        return spriteSheet.getSubimage(x,y,width,height);
    }

}
