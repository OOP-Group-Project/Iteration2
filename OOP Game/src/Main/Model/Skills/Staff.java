package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 * deals damage with staff
 */
public class Staff extends SummonerSkills {

    public Staff(Entity entity) {
        //2.4 seconds cooldown, 0 mana cost
        super(entity, 2.4, 0);
        damageFactor = 1;
    }

    public StatsModifier activate() {
        StatsModifier sm = new StatsModifier();
        if (allCheck()) {
            enforceManaCost();
            timeWhenPerformed = System.currentTimeMillis();
            Stats stats = entity.getStats();
            double damageToDeal = stats.curOffense() * level * damageFactor;
            sm = sm.builder().lifeModifier(-damageToDeal).build();
            System.out.println("Successfully performed " + skillName);
            System.out.println("The damage is: " + damageToDeal);
            return sm;
        }
        else {
            return sm;
        }
    }

}
