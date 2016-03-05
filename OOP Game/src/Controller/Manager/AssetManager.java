package Controller.Manager;

import Graphics.ImageLoader;
import Graphics.SpriteSheet;
import java.awt.image.BufferedImage;

/**
 * Created by Michael on 3/5/16.
 * This class serves to initialize all of the images
 * that will be used throughout the game
 */
public class AssetManager {

    // Constants that represent the pixel locations on the sprite sheet
    private static final int WIDTH = 30;
    private static final int HEIGHT = 47;
    private static final int PADDING = 64;
    private static final int X_START = 17;
    private static final int X_END = 529;
    private static final int Y_WALK_UP = 527;
    private static final int Y_WALK_RIGHT = 591;
    private static final int Y_WALK_DOWN = 655;
    private static final int Y_WALK_LEFT = 719;

    // Arrays that hold the 4 walking directions of the player (others to be added)
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
        int currentX = X_START;

        SpriteSheet mSpriteSheet = new SpriteSheet(ImageLoader.loadImage("/Resources/PlayerSpriteSheet.png"));

        // Initialize sprites for a player walking
        while(currentX < X_END){
            playerWalkUp[i] = mSpriteSheet.crop(currentX, Y_WALK_UP, WIDTH, HEIGHT);
            playerWalkRight[i] = mSpriteSheet.crop(currentX, Y_WALK_RIGHT, WIDTH, HEIGHT);
            playerWalkDown[i] = mSpriteSheet.crop(currentX, Y_WALK_DOWN, WIDTH, HEIGHT);
            playerWalkLeft[i] = mSpriteSheet.crop(currentX, Y_WALK_LEFT, WIDTH, HEIGHT);
            currentX += PADDING;
            i++;
        }

    }

}
