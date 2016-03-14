package Main.View.Graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Michael on 3/5/16.
 * This class serves to initialize all of the images
 * that will be used throughout the game
 */
public class GraphicsAssets {

    // Constants that represent the pixel locations on the sprite sheet
    // TODO: prepend "px" to any value that is relevant to pixels.
    private static final int WIDTH = 100;//30;
    private static final int HEIGHT = 87;//47;
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

    public static BufferedImage sneak;
    public static BufferedImage sneakUp;
    public static BufferedImage sneakDown;
    public static BufferedImage sneakDL;
    public static BufferedImage sneakDR;
    public static BufferedImage sneakUR;
    public static BufferedImage sneakUL;


    public static BufferedImage summonerUp;
    public static BufferedImage summonerDown;
    public static BufferedImage summonerUL;
    public static BufferedImage summonerUR;
    public static BufferedImage summonerDR;
    public static BufferedImage summonerDL;

    public static BufferedImage skeletonUp;
    public static BufferedImage skeletonDown;
    public static BufferedImage skeletonDR;
    public static BufferedImage skeletonDL;
    public static BufferedImage skeletonUR;
    public static BufferedImage skeletonUL;

    public static BufferedImage smasher;
    public static BufferedImage summoner;
    public static BufferedImage friendlyNPC;

    public static BufferedImage skeleton;
    public static BufferedImage skeletonWalk;
    public static BufferedImage[] skeletonWalkUp = new BufferedImage[9];
    public static BufferedImage[] skeletonWalkRight = new BufferedImage[9];
    public static BufferedImage[] skeletonWalkDown = new BufferedImage[9];
    public static BufferedImage[] skeletonWalkLeft = new BufferedImage[9];

    public static ArrayList<BufferedImage> itemImages = new ArrayList<>();

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

        SpriteSheet playerSpriteSheet = new SpriteSheet(ImageLoader.loadImage("/Resources/PlayerSpriteSheet.png"));
        SpriteSheet skeletonSpriteSheet = new SpriteSheet(ImageLoader.loadImage("/Resources/SkeletonSpriteSheet.png"));


        // Load in sneak sprites
        sneakDown = ImageLoader.loadImage("/Resources/sneakDown.png");
        sneakUp = ImageLoader.loadImage("/Resources/sneakUp.png");
        sneakUR = ImageLoader.loadImage("/Resources/sneakUR.png");
        sneakUL = ImageLoader.loadImage("/Resources/sneakUL.png");
        sneakDL = ImageLoader.loadImage("/Resources/sneakDL.png");
        sneakDR = ImageLoader.loadImage("/Resources/sneakDR.png");


        // Load in summoner sprites
        summonerUp = ImageLoader.loadImage("/Resources/summonUp.png");
        summonerDown = ImageLoader.loadImage("/Resources/summonDown.png");
        summonerDR = ImageLoader.loadImage("/Resources/summonDR.png");
        summonerDL = ImageLoader.loadImage("/Resources/summonDL.png");
        summonerUR = ImageLoader.loadImage("/Resources/summonUR.png");
        summonerUL = ImageLoader.loadImage("/Resources/summonUL.png");

        //load in skeleton sprites
        skeletonUp = ImageLoader.loadImage("/Resources/skeletonUp.png");
        skeletonDown = ImageLoader.loadImage("/Resources/skeletonDown.png");
        skeletonUR = ImageLoader.loadImage("/Resources/skeletonUR.png");
        skeletonUL = ImageLoader.loadImage("/Resources/skeletonUL.png");
        skeletonDL = ImageLoader.loadImage("/Resources/skeletonDL.png");
        skeletonDR = ImageLoader.loadImage("/Resources/skeletonDR.png");

//        friendlyNPC = ImageLoader.loadImage("/Resources/friendlyNPC");
        water = ImageLoader.loadImage("/Resources/water.png");
        grass = ImageLoader.loadImage("/Resources/grass.png");
        mountain = ImageLoader.loadImage("/Resources/mountain.png");
        redCross = ImageLoader.loadImage("/Resources/redCross.png");
        greenPlus = ImageLoader.loadImage("/Resources/greenPlus.png");
        goldStar = ImageLoader.loadImage("/Resources/goldStar.png");
        skeletonWalk = ImageLoader.loadImage("/Resources/skeletonWalk.png");
        pet = ImageLoader.loadImage("/Resources/tigerPet.png");

        for (int j = 0; j < 30; j++) {
            itemImages.add(ImageLoader.loadImage("/Resources/Items/item"+j+".png"));
        }

        // Load in player sprites
        player = playerSpriteSheet.crop(X_START, Y_WALK_DOWN, WIDTH, HEIGHT);
        skeleton = skeletonSpriteSheet.crop(X_START, Y_WALK_DOWN, WIDTH, HEIGHT);
        while(currentX < X_END){
            playerWalkUp[i] = playerSpriteSheet.crop(currentX, Y_WALK_UP, WIDTH, HEIGHT);
            playerWalkRight[i] = playerSpriteSheet.crop(currentX, Y_WALK_RIGHT, WIDTH, HEIGHT);
            playerWalkDown[i] = playerSpriteSheet.crop(currentX, Y_WALK_DOWN, WIDTH, HEIGHT);
            playerWalkLeft[i] = playerSpriteSheet.crop(currentX, Y_WALK_LEFT, WIDTH, HEIGHT);

            skeletonWalkUp[i] = skeletonSpriteSheet.crop(currentX, Y_WALK_UP, WIDTH, HEIGHT);
            skeletonWalkRight[i] = skeletonSpriteSheet.crop(currentX, Y_WALK_RIGHT, WIDTH, HEIGHT);
            skeletonWalkDown[i] = skeletonSpriteSheet.crop(currentX, Y_WALK_DOWN, WIDTH, HEIGHT);
            skeletonWalkLeft[i] = skeletonSpriteSheet.crop(currentX, Y_WALK_LEFT, WIDTH, HEIGHT);
            currentX += PADDING;
            i++;
        }
    }
}
