package Main.Game.Model.Entity;

import Main.Game.Model.DirectionEnum;
import Main.Game.View.Graphics.GraphicsAssets;

import java.awt.*;
import java.awt.image.BufferedImage;

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
