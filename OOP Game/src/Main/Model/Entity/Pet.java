package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.View.Graphics.GraphicsAssets;

import java.awt.*;

/**
 * Created by walkhard on 2/18/16.
 */
public class Pet extends Entity {


    public Pet(){
        super(GraphicsAssets.pet);
    }

    @Override
    public void move(DirectionEnum direction) {

    }

    @Override
    public void render(Graphics g, int x, int y) {

    }

}
