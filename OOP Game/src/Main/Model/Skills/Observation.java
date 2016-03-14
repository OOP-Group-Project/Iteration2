package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Observation extends BaseSkills {

    public Observation(Entity entity) {
        //5 second cooldown and mana cost
        super(entity, 5.0, 5.0);
        skillName = "Observation";
    }


    public ArrayList<String> activate(Entity enemy, double distance) {
        ArrayList<String> array = new ArrayList<>();
        if(true) {
            enforceManaCost();
            timeWhenPerformed = System.currentTimeMillis();
            Stats stats = enemy.getStats();
            Random rand = new Random();
            int randomNum = rand.nextInt(100);

            //this block calculates how much to alter the npc's stats
            //higher the level the more rolls
            //lowest roll is used to calculate the stats
            int minRandomNum = 20;
            for(int i = 0; i < level; ++i) {
                int newRandomNum = rand.nextInt(20);
                if(newRandomNum < minRandomNum){
                    minRandomNum = newRandomNum;
                }
            }

            double lifeToShow;
            int levelT0Show;
            double defRatingToShow;
            double offRatingToShow;

            //just used to alternate plus and minuses
            if (randomNum % 2 == 0) {
                lifeToShow = stats.curLife() - minRandomNum;
                levelT0Show = stats.getLevel() + minRandomNum / 2;
                defRatingToShow = stats.curDefense() + minRandomNum;
                offRatingToShow = stats.curOffense() - minRandomNum;
            }
            else {
                lifeToShow = stats.curLife() + minRandomNum;
                levelT0Show = stats.getLevel() - minRandomNum / 2;
                defRatingToShow = stats.curDefense() - minRandomNum;
                offRatingToShow = stats.curOffense() + minRandomNum;
            }

            array.add("NPC's level: " + levelT0Show);
            array.add("NPC's current life: " + lifeToShow);
            array.add("NPC's offensive rating: " + offRatingToShow);
            array.add("NPC's defensive rating: " + defRatingToShow);

            return array;
        }
        else {
            return null;
        }
    }
}
