package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class Creep extends SneakSkills {


    public Creep (Entity entity, double cooldown, double manacost) {
        super(entity, cooldown, manacost);
    }

    public boolean activate() {
        return successfulPerfoemance();
    }

    public StatsModifier attack() {
        double totalDamage = 0;
        if (successfulPerfoemance()) {
            Stats stats = entity.getStats();
            totalDamage = stats.curAgility() + level * 20;
            enforceManaCost();
        }
        StatsModifier sm = new StatsModifier();
        sm = sm.builder().lifeModifier(-totalDamage).build();
        return sm;
    }


}
