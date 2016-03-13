package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Observation extends BaseSkills {

    public Observation(Entity entity) {
        //5 second cooldown and mana cost
        super(entity, 5.0, 5.0);
    }


    public String[] activate(Entity enemy, double distance) {
        String[] array = null;
        if(enoughMana()) {
            Stats stats = enemy.getStats();
            Random rand = new Random();
            int randomNum = rand.nextInt(100);
            if(level * 25 > randomNum) {

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
                    levelT0Show = stats.level() + minRandomNum / 2;
                    defRatingToShow = stats.curDefense() + minRandomNum;
                    offRatingToShow = stats.curOffense() - minRandomNum;
                }
                else {
                    lifeToShow = stats.curLife() + minRandomNum;
                    levelT0Show = stats.level() - minRandomNum / 2;
                    defRatingToShow = stats.curDefense() - minRandomNum;
                    offRatingToShow = stats.curOffense() + minRandomNum;
                }

                array[0] = "NPC's level: " + levelT0Show;
                array[1] = "NPC's current life: " + lifeToShow;
                array[2] = "NPC's offensive rating: " + offRatingToShow;
                array[3] = "NPC's defensive rating: " + defRatingToShow;

            }
            enforceManaCost();
            return array;
        }
        else {
            return null;
        }
    }
}
