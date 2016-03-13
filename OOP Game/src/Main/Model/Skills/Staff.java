package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Staff extends SummonerSkills {

    public Staff(Entity entity) {
        //1 second cooldown, 0 mana cost
        super(entity, 1, 0);
    }

    public StatsModifier activate() {
        StatsModifier sm = new StatsModifier();
        if (!enoughMana()) {
            System.out.println("Not enough mana");
            return sm;
        } else if (!this.successfulPerformance()) {
            enforceManaCost();
            System.out.println("performance of Staff failed but");
            return sm;
        } else {
            Stats stats = entity.getStats();
            double damageToDeal = stats.curOffense() + 5 * level;
            sm = sm.builder().lifeModifier(-damageToDeal).build();
            return sm;
        }
    }

    @Override
    public void apply() {

    }
}
