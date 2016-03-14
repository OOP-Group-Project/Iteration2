package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Matthew on 3/12/2016.
 * manage that heals
 */
public class Boon extends SummonerSkills {


    public Boon(Entity entity) {
        super(entity, 20.0, 10.0);
    }

    public StatsModifier activate() {
        StatsModifier sm = new StatsModifier();
        if (allCheck()) {
            enforceManaCost();
            timeWhenPerformed = System.currentTimeMillis();
            double increaseByAmount = level * 4;
            sm = sm.builder()
                    .lifeModifier(increaseByAmount * 10)
                    .intellectModifier(increaseByAmount * 2)
                    .offensiveModifier(increaseByAmount)
                    .defenseModifier(increaseByAmount * 0.01)
                    .armorModifier(increaseByAmount * 0.8)
                    .particalImmunityModifier(increaseByAmount * 0.01)
                    .build();

            /**
             * TODO: John, use this activate() together with getDuration(), and call revert after duration
             * I got a "timeWhenPerformed" variable for your use. It record the time when the entity performed this skill
             */


            return sm;
        }
        else {
            return sm;
        }
    }

    public double getDuration() {
        return level * 10; //in seconds
    }

}
