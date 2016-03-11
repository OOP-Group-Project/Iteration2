package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Inventory.Inventory;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Occupation;
import Main.Model.Stats.Stats;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Modified by John Kaufmann 2/9/16
 * TODO: Implment an equipment starter pack based on your entity type.
 */
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
        this.Occupation = o;
        this.Location = location;
        this.image = image;
        this.Stats = new Stats(o.map(),1);
        this.Inventory = new Inventory();
    }

    //TESTING
    public Entity(EntityTypeEnum t, Occupation o, Point location) {
        this.type = t;
        this.Occupation = o;
        this.Location = location;
        this.Stats = new Stats(o.map(),1);
        this.Inventory = new Inventory();
    }
    protected MapLocationPoint location;

    public Entity(BufferedImage image){
        this.image = image;
    }

    //moves a players known x and y (JFK)
    public void move(DirectionEnum dir) {
        location.move(dir);
    }

    //renders the entity to the screen
    public abstract void render(Graphics g, int x, int y);


    public MapLocationPoint getLocation() {
        return location;
    }

    //returns the type of entity it is
    public EntityTypeEnum getType() {
        return type;
    }

    //gets the buffered image associated with this entity
    public BufferedImage getImage(){
        return image;
    }

    // Entities now know how to adjust their Stats()
    /*
        strength = "str"
        agility = "agi"
        intellect = "int"
        hardiness = "har"
        movement = "mov"
        health = "hp"
        mana = "mp"
        armor = "arm"
        defense = "def"
        offense = "off"
     */
    //
    public void modifyStats(String stat_to_modify, double amt) {Stats.modifyStats(stat_to_modify, amt);}

    // used to temporarily modify stats
    public void buff(String stat_to_buff, double amt){Stats.buff(stat_to_buff, amt);}

    // reverts change caused by buff()
    public void revert(){Stats.revert();}

    //
    public void modifyLives(int amt){Stats.modifyLives(amt);}
    //
    public void modifyExperience(int amt){Stats.modifyExperience(amt);}
    //
    public void levelUp(){Stats.levelUp();}
}
