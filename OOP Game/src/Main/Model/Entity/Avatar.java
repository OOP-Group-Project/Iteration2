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
        if(xLocation % 2 != 0) {
            switch(direction) {
                case Down:
                    yLocation++;
                    break;
                case Up:
                    if((yLocation - 1) >= 0) {
                        yLocation--;
                    }
                    break;
                case UpLeft:
                    if((xLocation - 1) >= 0){
                        xLocation--;
                    }
                    break;
                case UpRight:
                    xLocation++;
                    break;
                case DownLeft:
                    if((xLocation - 1) >= 0) {
                        xLocation--;
                        yLocation++;
                    }
                    break;
                case DownRight:
                    xLocation++;
                    yLocation++;
                    break;
            }
        } else {
            switch(direction) {
                case Down:
                    yLocation++;
                    break;
                case Up:
                    if ((yLocation - 1) >= 0) {
                        yLocation--;
                    }
                    break;
                case DownLeft:
                    if ((xLocation - 1) >= 0) {
                        xLocation--;
                    }
                    break;
                case DownRight:
                    xLocation++;
                    break;
                case UpLeft:
                    if ((xLocation - 1) >= 0) {
                        xLocation--;
                        yLocation++;
                    }
                    break;
                case UpRight:
                    xLocation++;
                    yLocation++;
                    break;
            }
        }
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
