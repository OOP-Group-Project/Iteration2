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
    public void modifyStats(String stat_to_modify, double amt) {mStats.modifyStats(stat_to_modify, amt);}

    // used to temporarily modify stats
    public void buff(String stat_to_buff, double amt){mStats.buff(stat_to_buff, amt);}

    // reverts change caused by buff()
    public void revert(){mStats.revert();}

    //
    public void modifyLives(int amt){mStats.modifyLives(amt);}
    //
    public void modifyExperience(int amt){mStats.modifyExperience(amt);}
    //
    public void levelUp(){mStats.levelUp();}
}
