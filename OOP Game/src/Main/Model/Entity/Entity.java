package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Inventory.Inventory;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Occupation;
import Main.Model.Stats.Stats;

/**
 * Modified by John Kaufmann 2/9/16
 * TODO: Implment an equipment starter pack based on your entity type.
 * TODO: Go over this class with mason to make sure that nothing was altered wrongfully
 */
public abstract class Entity {
    protected EntityTypeEnum type;
    protected Stats stats;
    protected Occupation occupation;
    protected Inventory inventory;
    protected MapLocationPoint location;

    //create Entities at certain locations with a certain type
    public Entity(EntityTypeEnum entityType, Occupation occupation, MapLocationPoint location) {
        this.type = entityType;
        this.occupation = occupation;
        this.location = location;
        this.stats = new Stats(occupation.map(),1);
        this.inventory = new Inventory();
    }

    //moves a players known x and y (JFK)
    public void move(DirectionEnum dir) {
        location.move(dir);
    }

    //moves an npc according to a path
    public void move(MapLocationPoint location){
        this.location.x = location.x;
        this.location.y = location.y;
    }

    public MapLocationPoint getLocation() {
        return location;
    }

    //returns the type of entity it is

    public EntityTypeEnum getType() {
        return type;
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
    public void modifyStats(String stat_to_modify, double amt) {stats.modifyStats(stat_to_modify, amt);}

    // used to temporarily modify stats
    public void buff(String stat_to_buff, double amt){stats.buff(stat_to_buff, amt);}

    // reverts change caused by buff()
    public void revert(){stats.revert();}

    //
    public void modifyLives(int amt){stats.modifyLives(amt);}
    //
    public void modifyExperience(int amt){stats.modifyExperience(amt);}
    //
    public void levelUp(){stats.levelUp();}
}
