package Main.View.Graphics;

import java.awt.image.BufferedImage;

/**
 * Created by Michael on 3/5/16.
 * This class serves to initialize all of the images
 * that will be used throughout the game
 */
public class GraphicsAssets {

    // Constants that represent the pixel locations on the sprite sheet
    // TODO: prepend "px" to any value that is relevant to pixels.
    private static final int WIDTH = 30;
    private static final int HEIGHT = 47;
    private static final int PADDING = 64;
    private static final int X_START = 17;
    private static final int X_END = 529;
    private static final int Y_WALK_UP = 527;
    private static final int Y_WALK_RIGHT = 591;
    private static final int Y_WALK_DOWN = 655;
    private static final int Y_WALK_LEFT = 719;

    // BufferedImages hold all of the images
    public static BufferedImage[] playerWalkUp = new BufferedImage[9];
    public static BufferedImage[] playerWalkRight = new BufferedImage[9];
    public static BufferedImage[] playerWalkDown = new BufferedImage[9];
    public static BufferedImage[] playerWalkLeft = new BufferedImage[9];
    public static BufferedImage player;
    public static BufferedImage pet;
    public static BufferedImage npc;
    public static BufferedImage grass;
    public static BufferedImage mountain;
    public static BufferedImage water;
    public static BufferedImage portal;
    public static BufferedImage greenPlus;
    public static BufferedImage goldStar;
    public static BufferedImage redCross;
    public static BufferedImage skullCrossBones;

    public static final int TILE_PX_WIDTH = 100;
    public static final int TILE_PX_HEIGHT = 87;

    public static void init(){
        int i = 0;
        int currentX = X_START;

        SpriteSheet mSpriteSheet = new SpriteSheet(ImageLoader.loadImage("/Resources/PlayerSpriteSheet.png"));

        // Load in water sprites
        water = ImageLoader.loadImage("/Resources/water.png");
        grass = ImageLoader.loadImage("/Resources/grass.png");
        mountain = ImageLoader.loadImage("/Resources/mountain.png");
        redCross = ImageLoader.loadImage("/Resources/redCross.png");
        greenPlus = ImageLoader.loadImage("/Resources/greenPlus.png");
        goldStar = ImageLoader.loadImage("/Resources/goldStar.png");

        // Load in player sprites
        player = mSpriteSheet.crop(X_START, Y_WALK_DOWN, WIDTH, HEIGHT);
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
