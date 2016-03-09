package Main.Model.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import Main.Model.DirectionEnum;
import Main.Model.Occupation.Occupation;
import Main.View.Graphics.GraphicsAssets;

/**
 * Created by walkhard on 2/18/16. Modified by John Kaufmann 3/9/16
 * TODO: Go over this class with mason to make sure nothing was wrongfully altered.
 * TODO: Implement methods.
 */
public class Avatar extends Entity{

    public Avatar(BufferedImage image, Occupation o, Point location) {
        super(image, EntityTypeEnum.Avatar, o, location);
    }

    //TESTING
    public Avatar(BufferedImage b) {
        super(b);
        Point location = new Point(1,1);
        Location = location;
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
