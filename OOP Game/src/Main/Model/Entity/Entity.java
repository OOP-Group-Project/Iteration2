package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Inventory.Inventory;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Occupation;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

/**
 * Modified by John Kaufmann 2/9/16
 * TODO: Implment an equipment starter pack based on your entity type.
 */
public abstract class Entity {
    protected EntityTypeEnum type;
    protected EntitySpeechEnum spiel;
    protected Stats stats;
    protected Occupation occupation;
    protected Inventory inventory;
    protected MapLocationPoint location;

    //create Entities at certain locations with a certain type
    public Entity(EntityTypeEnum entityType, EntitySpeechEnum entitySpiel, Occupation occupation, MapLocationPoint location) {
        this.type = entityType;
        this.spiel = entitySpiel;
        this.occupation = occupation;
        this.location = location;
        this.stats = new Stats(occupation.map(),1);
        this.inventory = new Inventory();
    }
    //moves a players known x and y (JFK)
    public void move(DirectionEnum dir) {
        location.move(dir);
    }

    public MapLocationPoint getLocation() {
        return location;
    }

    //returns the type of entity it is

    public EntityTypeEnum getType() {
        return type;
    }

    // P.Smith
    // Entities now know how to adjust their Stats()
    /*
        strength = "str"
        agility = "agi"
        intellect = "int"
        hardiness = "har"
        movement = "mov"
        action(speed) = "act"
        health = "hp"
        mana = "mp"
        armor = "arm"
        defense = "def"
        offense = "off"
     */
    //
    public void modifyStats(StatsModifier statsModifier) {

    }


    public Stats getStats() { return stats; }
    //TODO: question by Andy: do we want to keep eveything here? Would it be better if we getStats and call on Stats?
    public void modifyStats(String stat_to_modify, double amt) {stats.modifyStats(stat_to_modify, amt);}

    public void modifyState(StatsModifier sm) {stats.modifyStats(sm);}


    // used to temporarily modify stats
    public void buff(String stat_to_buff, double amt){stats.buff(stat_to_buff, amt);}

    // reverts change caused by buff()
    public void revert(){stats.revert();}

    //
    public void modifyLives(int amt){stats.modifyLives(amt);}
    //
    public void modifyExperience(int amt){stats.modifyExperience(amt);}
    //
    public void checkExperience(){
        if(stats.checkExperience())
            stats.levelUp();
    }
    //
    public void levelUp(){stats.levelUp();}

    // Entities now have the ability to "speak"
    //
    public String speak(){return spiel.spiel();}

    //
    public Inventory getInventory(){ return this.inventory;}

}
