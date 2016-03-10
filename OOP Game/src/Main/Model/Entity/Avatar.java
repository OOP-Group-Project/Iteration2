package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Stats.Effect;
import Main.View.Graphics.GraphicsAssets;

import java.awt.*;

/**
 * Created by walkhard on 2/18/16.
 */
public class Avatar extends Entity{

    public Avatar(){
        super(GraphicsAssets.player);
        this.type = EntityTypeEnum.Avatar;
    }

    public Avatar(int xLocation, int yLocation) {
        super(GraphicsAssets.player);
        this.type = EntityTypeEnum.Avatar;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    @Override
    public void move(DirectionEnum direction) {
        System.out.print("Before\t X: " + Integer.toString(xLocation) + " Y: " + Integer.toString(yLocation));
        if(xLocation % 2 == 0) {
            System.out.println(" Even");
            switch(direction) {
                case Down:
                    System.out.println("Even Down");
                    yLocation++;
                    break;
                case Up:
                    System.out.println("Even Up");
                    if((yLocation - 1) >= 0) {
                        yLocation--;
                    }
                    break;
                case UpLeft:
                    System.out.println("Even UpLeft");
                    if((xLocation - 1) >= 0 && (yLocation - 1) >= 0){
                        xLocation--;
                        yLocation--;
                    }
                    break;
                case UpRight:
                    System.out.println("Even Upright");
                    if((yLocation - 1) >= 0) {
                        xLocation++;
                        yLocation--;
                    }
                    break;
                case DownLeft:
                    System.out.println("Even DownLeft");
                    if((xLocation - 1) >= 0) {
                        xLocation--;
                    }
                    break;
                case DownRight:
                    System.out.println("Even DownRight");
                    xLocation++;
                    break;
            }
        } else {
            System.out.println(" Odd");
            switch(direction) {
                case Down:
                    System.out.println("Odd Down");
                    yLocation++;
                    break;
                case Up:
                    System.out.println("Odd Up");
                    if ((yLocation - 1) >= 0) {
                        yLocation--;
                    }
                    break;
                case DownLeft:
                    System.out.println("Odd DownLeft");
                    if ((xLocation - 1) >= 0) {
                        xLocation--;
                        yLocation++;
                    }
                    break;
                case DownRight:
                    System.out.println("Odd DownRight");
                    xLocation++;
                    yLocation++;
                    break;
                case UpLeft:
                    System.out.println("Odd UpLeft");
                    if ((xLocation - 1) >= 0) {
                        xLocation--;
                    }
                    break;
                case UpRight:
                    System.out.println("Odd Upright");
                    xLocation++;
                    break;
            }
        }
        System.out.println("After\t X: " + Integer.toString(xLocation) + " Y: " + Integer.toString(yLocation) + '\n');
    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(this.getImage(), x, y,null);
    }


    // Use this method when there's anything that will modify the stats
    @Override
    public void applyEffect(Effect effect){
        mStats.applyEffect(effect);
    }

    @Override
    public void tick(){
        getStats().tick();
    }

    public void respawn(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }




}
