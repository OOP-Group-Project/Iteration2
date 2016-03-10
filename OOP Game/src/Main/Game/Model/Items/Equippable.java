package Main.Game.Model.Items;

import Main.Game.Model.Entity.Entity;

/**
 * Created by Matthew on 3/7/16.
 */
public class Equippable extends TakeAble {

    private int reqLives = 0;
    private int reqStrength = 0;
    private int reqAgility = 0;
    private int reqIntellect = 0;
    private int reqHardiness = 0;
    private int reqExperience = 0;
    private int reqMovement = 0;

    public Equippable(int id, String name, String url, String mods, String reqs){
        super(id, name, url, mods);
        changeType("equippable");

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
    }


    public boolean canActivate(Entity entity){
        //check if entity has required stats
        //entity.getStats
        //are stats > reqs?
        //if so return true
        return true;

        //return false if not
    }



}
