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

    public void activate(Entity enemy) {
        if (!enoughMana()) {
            System.out.println("Not enough mana");
            return;
        } else if (!this.successfulPerfoemance()) {
            enforceManaCost();
            System.out.println("performance of Staff failed but");
            return;
        } else {
            Stats stats = entity.getStats();
            double damageToDeal = stats.curOffense() + 5 * level;

            Stats enemyStats = enemy.getStats();
            StatsModifier sm = new StatsModifier();
            sm = sm.builder().lifeModifier(-damageToDeal).build();
            enemyStats.modifyStats(sm);
        }
    }
}
