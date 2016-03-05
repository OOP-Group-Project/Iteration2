package Controller.Manager;

import Graphics.ImageLoader;
import Graphics.SpriteSheet;
import java.awt.image.BufferedImage;

/**
 * Created by Michael on 3/5/16.
 */
public class AssetManager {

    public static BufferedImage player;
    public static BufferedImage grass;
    public static BufferedImage mountain;
    public static BufferedImage water;
    public static BufferedImage portal;
    public static BufferedImage goldStar;
    public static BufferedImage redCross;
    public static BufferedImage skullCrossBones;

    public static void init(){
        SpriteSheet mSpriteSheet = new SpriteSheet(ImageLoader.loadImage("/Resources/PlayerSpriteSheet.png"));
    }

}
