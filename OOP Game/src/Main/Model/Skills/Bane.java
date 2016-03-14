package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Bane extends SummonerSkills {


    public Bane(Entity entity) {
        //2.0 cooldown and 5.0 mana cost
        super(entity, 2.0, 5.0);
    }

    public void activate(Entity enemy) {
        if (!enoughMana()) {
            System.out.println("Not enough mana");
            return;
        }
        else if (!this.successfulPerfoemance()) {
            enforceManaCost();
            System.out.println("performance of BindWounds failed but");
            return;
        }
        else {
            StatsModifier sm = new StatsModifier();
            Stats stats = enemy.getStats();
            double currentInt = entity.getStats().curIntellect();
            double damageToDeal = level * (currentInt / 3);
            sm = sm.builder().lifeModifier(-damageToDeal).build();
            stats.modifyStats(sm);
            enforceManaCost();
        }
    }

}
