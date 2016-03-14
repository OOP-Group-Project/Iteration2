package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class Creep extends SneakSkills {

    public Creep (Entity entity) {
        super(entity, 10, 5);
        skillName = "Creep";
    }

    public StatsModifier attack() {
        double totalDamage;
        Stats stats = entity.getStats();
        totalDamage = stats.curAgility() * level * 5;
        enforceManaCost();
        StatsModifier sm = new StatsModifier();
        sm = sm.builder().lifeModifier( -totalDamage).build();
        return sm;
    }

    //duration in seconds
    public double getDuration() {
        return level * 10;
    }
}