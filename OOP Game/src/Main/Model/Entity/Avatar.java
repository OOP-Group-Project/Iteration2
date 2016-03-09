package Main.Model.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import Main.Model.Occupation.Occupation;
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
    public Avatar(Occupation o, Point location) {
        super(EntityTypeEnum.Avatar, o, location);
    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(this.getImage(), x, y,null);
    }
}
