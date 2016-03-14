package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Equipment.Equipment;
import Main.Model.Inventory.Inventory;
import Main.Model.Items.Takable;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Map.Tile;
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
    protected Equipment equipment;
    protected MapLocationPoint location;
    protected boolean isMoving;
    protected boolean isDoingAction;
    protected DirectionEnum orientation;

    //create Entities at certain locations with a certain type
    public Entity(EntityTypeEnum entityType, EntitySpeechEnum entitySpiel, Occupation occupation, MapLocationPoint location) {
        this.type = entityType;
        this.spiel = entitySpiel;
        this.occupation = occupation;
        this.location = location;
        this.stats = new Stats(occupation.map(), this, 1);
        this.inventory = new Inventory();
        this.isMoving = false;
        this.isDoingAction = false;
    }
    //moves a players known x and y (JFK)
    public void move(DirectionEnum dir) {
        location.move(dir);
    }

//    public void move(MapLocationPoint playerLocation, MapLocationPoint point){
//        location.move(location,point);
//    }


    public MapLocationPoint getLocation() {
        return location;
    }

    public void setLocation(MapLocationPoint location) {
        this.location.x = location.x;
        this.location.y = location.y;
    }

    //returns the type of entity it is
    public EntityTypeEnum getType() {
        return type;
    }

    public void setType(EntityTypeEnum type) {
        this.type = type;
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
        stats.modifyStats(statsModifier);
    }


    public Stats getStats() { return stats; }
    //TODO: question by Andy: do we want to keep eveything here? Would it be better if we getStats and call on Stats?
    public void modifyStats(String stat_to_modify, double amt) {stats.modifyStats(stat_to_modify, amt);}

    public boolean hasHealth() {
        return stats.curLife() > 0;
    }

//    public void modifyStats(StatsModifier sm) {stats.modifyStats(sm);}

    // used to temporarily modify stats
    public void buff(String stat_to_buff, double amt){stats.buff(stat_to_buff, amt);}

    // reverts change caused by buff()
    public void revert(){stats.revert();}


    public void modifyLives(int amt){stats.modifyLives(amt);}

    public void modifyExperience(int amt){stats.modifyExperience(amt);}

    public void checkExperience(){
        if(stats.checkExperience())
            stats.levelUp();
    }

    public boolean addItem(Takable item) {
        return inventory.addItem(item);
    }


    public void levelUp(){stats.levelUp();}

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }
    // Entities now have the ability to "speak"
    //
    public String speak(){return spiel.spiel();}

    public void setSpiel(EntitySpeechEnum spiel) {
        this.spiel = spiel;
    }

    public EntitySpeechEnum getSpiel() {
        return this.spiel;
    }

    //
    public Inventory getInventory(){ return this.inventory;}

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public boolean isDoingAction() {
        return isDoingAction;
    }

    public void setDoingAction(boolean isDoingAction) {
        this.isDoingAction = isDoingAction;
    }

    public DirectionEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(DirectionEnum dir) {
        this.orientation = dir;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void respawn(MapLocationPoint location) {
        this.location.x = location.x;
        this.location.y = location.y;
        StatsModifier sm = new StatsModifier();
        sm = sm.builder().lifeModifier(15).build();
        this.stats.modifyStats(sm);
        // TODO: Reset avatar's stats when respawn
        //this.stats.reset();
    }

    //looks at the tile infront of it
    public MapLocationPoint peek() {
        return location.getAdjacent(orientation);
    }
}
