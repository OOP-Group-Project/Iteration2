package Main.Model.Stats;

import Main.Model.Entity.Entity;

/**
 * Created by mason on 3/11/16.
 */
public class StatsModifier {

    protected int lives = 0;
    protected int strength = 0;
    protected int agility = 0;
    protected int intellect = 0;
    protected int hardiness = 0;
    protected int experience = 0;
    protected int movement = 0;

    public StatsModifier() {

    }

    public StatsModifier(String mods) {
        String modsArray[] = new String[7];
        int length = 1;
        if(mods.contains(",")){
            String tempArray[] = mods.split(",");
            length = tempArray.length;
            for(int i = 0; i < length; ++i){
                modsArray[i] = tempArray[i];
            }
        }
        else{
            modsArray[0] = mods;
        }

        for(int i = 0; i < length; ++i){
            String currentModification[] = modsArray[i].split(":");
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
}
