package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.StatsModifier;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Enchantment extends SummonerSkills {
    //make npc fall asleep

    public Enchantment(Entity entity) {
        //10 sec cooldown and 5 mana cost
        super(entity, 10.0, 5.0);
    }

    //as we can't make the npc sleep, we just change the movement speed to 1%
    public StatsModifier activate() {
        StatsModifier sm = new StatsModifier();
        if (allCheck()) {
            enforceManaCost();
            timeWhenPerformed = System.currentTimeMillis();
            sm = sm.builder().movementModifier(-0.99).build();
            return sm;
        }
        else {
            return sm;
        }

    }

}


