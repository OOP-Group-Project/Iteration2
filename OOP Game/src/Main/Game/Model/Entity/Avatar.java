package Main.Game.Model.Entity;

import Main.Controller.Manager.AssetManager;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by walkhard on 2/18/16.
 */
public class Avatar extends Entity{

    public Avatar(){
        super(AssetManager.player);
    }

    @Override
    public void move() {

    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(this.getImage(), x, y,null);
    }
}
