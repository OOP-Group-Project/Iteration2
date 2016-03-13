package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Bane extends SummonerSkill{


    public Bane(Entity entity) {
        //2.0 cooldown and 5.0 mana cost
        super(entity, 2.0, 5.0);
    }

    public StatsModifier activate() {
        StatsModifier sm = new StatsModifier();
        if(enoughMana()) {
            Stats stats = entity.getStats();
            if (successfulPerfoemance()) {
                double currentInt = stats.curIntellect();
                double damageToDeal = level * (currentInt / 3);
                sm = sm.builder().lifeModifier(-damageToDeal).build();
            }
        }
        return sm;
    }
}
