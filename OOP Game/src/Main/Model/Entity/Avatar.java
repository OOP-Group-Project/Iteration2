package Main.Model.Entity;

import Main.Model.DirectionEnum;
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
    }

    public void respawn(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }



    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(this.getImage(), x, y,null);
    }
}
