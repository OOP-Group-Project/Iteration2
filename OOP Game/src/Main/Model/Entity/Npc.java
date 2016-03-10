package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Stats.Effect;
import Main.View.Graphics.GraphicsAssets;

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
    public void applyEffect(Effect effect) {

    }

    @Override
    public void move(DirectionEnum direction) {

    }

    @Override
    public BufferedImage getImage() {
        return null;
    }
}
