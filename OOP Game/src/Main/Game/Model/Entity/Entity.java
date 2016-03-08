package Main.Game.Model.Entity;

import Main.Game.Model.DirectionEnum;
import Main.Game.Model.Inventory.Inventory;
import Main.Game.Model.Occupation.Occupation;
import Main.Game.Model.Stats.Stats;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected BufferedImage image;
    protected int width;
    protected int height;

    protected EntityTypeEnum type;
    protected Stats mStats;
    protected Occupation mOccupation;
    protected Inventory mInventory;

    protected int xLocation;
    protected int yLocation;

    public Entity(BufferedImage image){
        this.image = image;
    }

    public abstract void move(DirectionEnum direction);
    public abstract void render(Graphics g, int x, int y);

    public BufferedImage getImage(){
        return image;
    }

}
