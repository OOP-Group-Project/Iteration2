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

    public StatsModifier activate(Entity enemy) {
        StatsModifier sm = new StatsModifier();
        Random rand = new Random();
        double randD = rand.nextDouble();

        if (randD < enemy.getStats().curDefense()) {
            System.out.println("Attach dodged by enemy");
            return sm;
        }
        else if (allCheck()) {
            double totalDamage;
            timeWhenPerformed = System.currentTimeMillis();
            Stats stats = entity.getStats();
            //TODO:should use the Attack class to calc this
            totalDamage = stats.curOffense() * level * damageFactor;
            sm = sm.builder().lifeModifier(-totalDamage).build();
            enforceManaCost();
            System.out.println("Successfully performed " + skillName);
            System.out.println("The damage is: " + stats.curOffense() + " * " + level + " * " + damageFactor + ": " + totalDamage);
            return sm;
        }
        else {
            return sm;
        }
    }
}
