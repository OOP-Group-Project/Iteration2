package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Matthew on 3/12/2016.
 * LinearEffect
 * This skill just does damage to an enemy on a line
 */
public class Bane extends SummonerSkills {

    public Bane(Entity entity) {
        //2.0 cooldown and 5.0 mana cost
        super(entity, 2.0, 5.0);
        damageFactor = 3;
    }

    public StatsModifier activate() {
        StatsModifier sm = new StatsModifier();
        if (allCheck()) {
            enforceManaCost();
            timeWhenPerformed = System.currentTimeMillis();
            double currentInt = entity.getStats().curIntellect();
            double damageToDeal = level * currentInt * damageFactor;
            sm = sm.builder().lifeModifier(-damageToDeal).build();
            return sm;
        }
        else {
            return sm;
        }
    }

}
