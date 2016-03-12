package Main.Model;

import Main.Model.AreaEffect.TakeDamage;
import Main.Model.Items.Takable;
import Main.Model.Entity.*;
<<<<<<< HEAD
import Main.Model.Occupation.Occupation;
import Main.Model.Occupation.OccupationTypeEnum;

=======
import Main.Model.Items.*;
>>>>>>> master
/**
 * Created by Peter Camejo on 3/10/2016.
 */
public class Requirement {
    /*** Member Variables ***/
    private int requiredLevel;
    private Takable requiredItem;
    private OccupationTypeEnum requiredOccupation;

    /*** Constructors ***/
    public Requirement() {
        requiredLevel = 0;
        requiredItem = null;
        requiredOccupation = null;
    }

    public Requirement(int requiredLevel) {
        this();
        this.requiredLevel = requiredLevel;
    }

    public Requirement(Takable requiredItem) {
        this();
        this.requiredItem = requiredItem;
    }

    public Requirement(OccupationTypeEnum requiredOccupation) {
        this();
        this.requiredOccupation = requiredOccupation;
    }

    public Requirement(int requiredLevel , Takable requiredItem){
        this();
        this.requiredLevel = requiredLevel;
        this.requiredItem = requiredItem;
    }

    public Requirement(int requiredLevel, Takable requiredItem, OccupationTypeEnum requiredOccupation) {
        this.requiredLevel = requiredLevel;
        this.requiredItem = requiredItem;
        this.requiredOccupation = requiredOccupation;
    }

    /*** Methods ***/
    public boolean meetsLevel(Entity entity) {
        int entityLevel = entity.getStats().level();

        if(entityLevel >= this.requiredLevel){
             return true;
        }
<<<<<<< HEAD
        */

        if(requiredLevel == 0) {
            return true;
        }

=======
>>>>>>> master
        return false;
    }
/*
    public boolean hasItem(Entity entity){
        Item testItem = entity.getInventory().getItem(requiredItem);
        if(testItem.getId() == requiredItem.getId()){
            return true;
        }
<<<<<<< HEAD
         */

        if(requiredItem == null) {
            return true;
        }

        return false;
    }

    public boolean isCorrectOccupation(Entity entity) {
        if(requiredOccupation == null) {
            return true;
        }
        return false;
    }

    public boolean checkRequirement(Entity entity) {
        return (meetsLevel(entity) && hasItem(entity) && isCorrectOccupation(entity));
    }

    /*

    String reqsArray[] = new String[7];
        int length = 1;
        if(reqs.contains(",")){
            String tempArray[] = reqs.split(",");
            length = tempArray.length;
            for(int i = 0; i < length; ++i){
                reqsArray[i] = tempArray[i];
            }
        }
        else{
            reqsArray[0] = reqs;
        }

        for(int i = 0; i < length; ++i){
            String currentModification[] = reqsArray[i].split(":");
            String currentSkill = currentModification[0];
            if (currentSkill.equals("lives")){
                lives = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("strength")){
                strength = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("agility")){
                agility = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("intellect")){
                intellect = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("hardiness")){
                hardiness = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("experience")){
                experience = Integer.parseInt(currentModification[1]);
            }
            else if (currentSkill.equals("movement")){
                movement = Integer.parseInt(currentModification[1]);
            }

        }

     */


=======

        return false;
    }
*/
>>>>>>> master
} //end Requirement
