package Main.Model;

import Main.Model.Items.TakeAble;
import Main.Model.Entity.*;
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
        /*
        if(entity.getLevel() >= this.requiredLevel){
             return true;
        }
        */

        return false;
    }

    public boolean hasItem(Entity entity){
        /*
        if(entity.hasItem(requiredItem)){
            return true;
        }
         */
        return false;
    }

} //end Requirement
