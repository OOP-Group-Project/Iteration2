package Main.Game.Model.Entity;

import Main.Game.View.Graphics.GraphicsAssets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by walkhard on 2/18/16.
 */
public class Npc extends Entity {


    public Npc(){
        super(GraphicsAssets.player);
    }

    @Override
    public void render(Graphics g, int x, int y) {

    }

    @Override
    public void move() {

    }

    @Override
    public BufferedImage getImage() {
        return null;
    }
}
