package Main.Model.Entity;

import Main.Model.DirectionEnum;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by johnkaufmann on 3/9/16.
 * TODO:
 */
public class Vehicle extends Entity {
    public Vehicle(BufferedImage image) {
        super(image);
    }

    @Override
    public void move(DirectionEnum direction) {

    }

    @Override
    public void render(Graphics g, int x, int y) {

    }
}
