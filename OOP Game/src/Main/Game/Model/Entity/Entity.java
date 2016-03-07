package Main.Game.Model.Entity;

import Main.Game.Model.Inventory.Inventory;
import Main.Game.Model.Occupation.Occupation;
import Main.Game.Model.Stats.Stats;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected BufferedImage image;
    protected int width;
    protected int height;
    protected float speed;

    private Stats mStats;
    private Occupation mOccupation;
    private Inventory mInventory;

    public Entity(BufferedImage image){
        this.image = image;
    }

    public abstract void move();
    public abstract void render(Graphics g, int x, int y);

    public BufferedImage getImage(){
        return image;
    }

}
