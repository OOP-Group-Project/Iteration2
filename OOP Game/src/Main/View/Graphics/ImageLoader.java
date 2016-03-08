package Main.View.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Michael on 3/5/16.
 */
public class ImageLoader {

    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e){
            e.printStackTrace();
            // Exit game if images aren't loaded in
            System.exit(1);
        }
        return null;
    }
}
