package Main.Model.Entity;

import Main.Model.Actions.Actions;
import Main.Model.Equipped.Equipped;
import Main.Model.Inventory.Inventory;
import Main.Model.Occupation.Occupation;
import Main.Model.Stats.Stats;

public abstract class Entity {
    // Aggregations
	private Actions Actions;
    private Inventory Inventory;
    private Equipped EquippedItems;
    private Occupation Occupation;
    private Stats Stats;

    //local variables
    private int xPosition; // x location
    private int yPosition; // y location

    enum eOrientation {
        N,
        NE,
        E,
        SE,
        S,
        SW,
        W,
        NW
    }

    private eOrientation eOrientation;

    //contstructor
    public Entity(Actions Actions, Main.Model.Inventory.Inventory inventory, Equipped equippedItems, Main.Model.Occupation.Occupation occupation, Main.Model.Stats.Stats stats, int xPosition, int yPosition) {
        this.Actions = Actions;
        Inventory = inventory;
        EquippedItems = equippedItems;
        Occupation = occupation;
        Stats = stats;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    //getter method
    protected eOrientation getOrientation() {
        return eOrientation;
    }

    //setter method
    protected void setOrientation(eOrientation eOrientation) {
        this.eOrientation = eOrientation;
    }

    //getter method
    protected Actions getActions() {
        return Actions.listActions();
    }

    //setter method
    protected void setActions(Actions Actions) {
        Actions = Actions;
    }

    //getter method
    protected Main.Model.Inventory.Inventory getInventory() {
        return Inventory;
    }

    //setter method
    protected void setInventory(Main.Model.Inventory.Inventory inventory) {
        Inventory = inventory;
    }

    //getter method
    protected Equipped getEquippedItems() {
        return EquippedItems;
    }

    //setter method
    protected void setEquippedItems(Equipped equippedItems) {
        EquippedItems = equippedItems;
    }

    //getter method
    protected Main.Model.Occupation.Occupation getOccupation() {
        return Occupation;
    }

    //setter method
    protected void setOccupation(Main.Model.Occupation.Occupation occupation) {
        Occupation = occupation;
    }

    //getter method
    protected Main.Model.Stats.Stats getStats() {
        return Stats;
    }

    //setter method
    protected void setStats(Main.Model.Stats.Stats stats) {
        Stats = stats;
    }

    //getter method
    protected int getxPosition() {
        return xPosition;
    }

    //setter method
    protected void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    //getter method
    protected int getyPosition() {
        return yPosition;
    }

    //setter method
    protected void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    // abstract method to perform an action
    protected abstract boolean performAction();

    // method to move the entity
    protected void move(eOrientation eOrientation) {
        // given a direction move in that direction
        switch (eOrientation) {
            case eOrientation.N:
                setyPosition(getyPosition()-1); //move up one
                break;
            case eOrientation.NE:
                setyPosition(getyPosition()+1); //move NE one
                break;
            case eOrientation.SE:
                setyPosition(getyPosition()+1);
                setxPosition(getxPosition()+1); //move SE one
                break;
            case eOrientation.S:
                setyPosition(getyPosition()+1); //move S one
                break;
            case eOrientation.SW:
                setyPosition(getyPosition()+1);
                setxPosition(getxPosition()-1); //move SW one
                break;
            case eOrientation.NW:
                setxPosition(getxPosition()-1); //move NW one
                break;
        }
    }
}
