package Controller.Manager;

import Graphics.ImageLoader;
import Graphics.SpriteSheet;
import java.awt.image.BufferedImage;

/**
 * Created by Michael on 3/5/16.
 */
public class AssetManager {

    private static final int width = 30;
    private static final int height = 47;
    private static final int padding = 64;
    private static final int xStart = 17;
    private static final int xEnd = 529;
    private static final int yWalkUp = 527;
    private static final int yWalkRight = 591;
    private static final int yWalkDown = 655;
    private static final int yWalkLeft = 719;


    public static BufferedImage[] playerWalkUp = new BufferedImage[9];
    public static BufferedImage[] playerWalkRight = new BufferedImage[9];
    public static BufferedImage[] playerWalkDown = new BufferedImage[9];
    public static BufferedImage[] playerWalkLeft = new BufferedImage[9];
    public static BufferedImage grass;
    public static BufferedImage mountain;
    public static BufferedImage water;
    public static BufferedImage portal;
    public static BufferedImage goldStar;
    public static BufferedImage redCross;
    public static BufferedImage skullCrossBones;

    public static void init(){
        int i = 0;
        int currentX = xStart;

        SpriteSheet mSpriteSheet = new SpriteSheet(ImageLoader.loadImage("/Resources/PlayerSpriteSheet.png"));

        // Initialize animations for a player walking
        while(currentX < xEnd){
            playerWalkUp[i] = mSpriteSheet.crop(currentX,yWalkUp,width,height);
            playerWalkRight[i] = mSpriteSheet.crop(currentX,yWalkRight,width,height);
            playerWalkDown[i] = mSpriteSheet.crop(currentX,yWalkDown,width,height);
            playerWalkLeft[i] = mSpriteSheet.crop(currentX,yWalkLeft,width,height);
            currentX += padding;
            i++;
        }

    }

}
