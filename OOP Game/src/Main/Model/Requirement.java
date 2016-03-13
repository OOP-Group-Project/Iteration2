package Main.Model;

import Main.Model.Items.TakeAble;
import Main.Model.Entity.*;
import Main.Model.Items.*;
/**
 * Created by Peter Camejo on 3/10/2016.
 */
public class Requirement {
    /*** Member Variables ***/
    private int requiredLevel;
    private TakeAble requiredItem;

    /*** Constructors ***/
    public Requirement(int requiredLevel , TakeAble requiredItem){
        this.requiredLevel = requiredLevel;
        this.requiredItem = requiredItem;
    }

    /*** Methods ***/
    public boolean meetsLevel(Entity entity) {
        int entityLevel = entity.getStats().level();

        if(entityLevel >= this.requiredLevel){
             return true;
        }
        return false;
    }
/*
    public boolean hasItem(Entity entity){
        Item testItem = entity.getInventory().getItem(requiredItem);
        if(testItem.getId() == requiredItem.getId()){
            return true;
        }

        return false;
    }
*/
} //end Requirement
