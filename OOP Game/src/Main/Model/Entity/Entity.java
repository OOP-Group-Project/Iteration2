package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Inventory.Inventory;
import Main.Model.Occupation.Occupation;
import Main.Model.Stats.Stats;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected BufferedImage image;
    protected int width;
    protected int height;

    protected EntityTypeEnum type;
    protected Stats Stats;
    protected Occupation Occupation;
    protected Inventory Inventory;

    protected Point Location;

    //create Entities at certain locations with a certain type and a buffered image
    public Entity(BufferedImage image, EntityTypeEnum t, Occupation o, Point location) {
        this.type = t;
        Occupation = o;
        Location = location;
        this.image = image;
    }

    public Entity(BufferedImage image){
        this.image = image;
    }

    //moves a players known x and y (JFK)
    public void move(DirectionEnum dir) {
        switch (dir) {
            case Up:
                Location.translate(-1,0);
                break;
            case UpLeft:
                Location.translate(0,-1);
                break;
            case UpRight:
                Location.translate(0,1);
                break;
            case Down:
                Location.translate(1,0);
                break;
            case DownLeft:
                Location.translate(1,-1);
                break;
            case DownRight:
                Location.translate(1,1);
                break;
        }
    }

    public abstract void render(Graphics g, int x, int y);

    // gives a java class point (JFK)
    public Point getLocation() {
        return Location;
    }

    public EntityTypeEnum getType() {
        return type;
    }

    public BufferedImage getImage(){
        return image;
    }

}
