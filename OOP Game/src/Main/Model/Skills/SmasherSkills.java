package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

import java.util.Random;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public abstract class SmasherSkills extends Skills {

    int damageFactor;

    public SmasherSkills(Entity entity, double coolDownPeriod, double manaCost) {
        super(entity, coolDownPeriod, manaCost);
    }

    //returns a StatsModifer with damage to deal at enemy
    public StatsModifier activate() {
        StatsModifier sm = new StatsModifier();

        if (allCheck()) {
            double totalDamage;
            timeWhenPerformed = System.currentTimeMillis();
            Stats stats = entity.getStats();
            totalDamage = stats.curOffense() * level * damageFactor;
            sm = sm.builder().lifeModifier(-totalDamage).build();
            enforceManaCost();
            System.out.println("Successfully performed " + skillName);
            System.out.println("The damage is: " + stats.curOffense() + " * " + level + " * " + damageFactor + ": " + totalDamage);
            return sm;
        } else {
            return sm;
        }
    }
}
