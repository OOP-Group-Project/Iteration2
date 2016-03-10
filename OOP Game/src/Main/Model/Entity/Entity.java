package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Inventory.Inventory;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Occupation;
import Main.Model.Stats.Stats;

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

    protected MapLocationPoint location;

    public Entity(BufferedImage image){
        this.image = image;
    }

    public abstract void move(DirectionEnum direction);
    public abstract void render(Graphics g, int x, int y);

    public MapLocationPoint getLocation() {
        return location;
    }

    public EntityTypeEnum getType() {
        return type;
    }

    public BufferedImage getImage(){
        return image;
    }

}
