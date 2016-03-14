package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Bane extends SummonerSkills {


    public Bane(Entity entity) {
        //2.0 cooldown and 5.0 mana cost
        super(entity, 2.0, 5.0);
    }

    public StatsModifier activate() {
        StatsModifier sm = new StatsModifier();
        if (!enoughMana()) {
            System.out.println("Not enough mana");
            return sm;
        }
        else if (!this.successfulPerformance()) {
            enforceManaCost();
            System.out.println("performance of BindWounds failed but");
            return sm;
        }
        else {
            double currentInt = entity.getStats().curIntellect();
            double damageToDeal = level * (currentInt / 3);
            sm = sm.builder().lifeModifier(-damageToDeal).build();
            enforceManaCost();
            return sm;
        }
    }
}
