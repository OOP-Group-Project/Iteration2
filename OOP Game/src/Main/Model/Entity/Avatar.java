package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Occupation.Occupation;
import Main.View.Graphics.GraphicsAssets;

import java.awt.*;

/**
 * Created by walkhard on 2/18/16. Modified by John Kaufmann 3/9/16
 * TODO: Go over this class with mason to make sure nothing was wrongfully altered.
 * TODO: Implement methods.
 */
public class Avatar extends Entity{

    public Avatar(Occupation o, Point location) {
        super(EntityTypeEnum.Avatar, o, location);
    }

    public Avatar(){
        super(GraphicsAssets.player);
        this.type = EntityTypeEnum.Avatar;
    }

    public Avatar(int xLocation, int yLocation) {
        super(GraphicsAssets.player);
        this.type = EntityTypeEnum.Avatar;
        this.Location = new Point(xLocation,yLocation);
    }

    @Override
    public void move(DirectionEnum dir) {
        System.out.print("OKAY");
        super.move(dir);
    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(this.getImage(), x, y,null);
    }
}
