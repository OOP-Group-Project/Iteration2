package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

import java.util.Random;

/**
 * Created by Matthew on 3/11/2016.
 */
public class BindWounds extends BaseSkills {


    public BindWounds(Entity entity) {
        //sets cooldown period to 10 seconds and mana cost to 10
        super(entity, 10.0, 10.0);
    }



    public StatsModifier activate() {
        StatsModifier sm = new StatsModifier();
        if(enoughMana()) {
            if (successfulPerfoemance()) {
                double amountToHeal = level * 3 + 4;
                sm = sm.builder().lifeModifier(amountToHeal).build();
            }
        }
        return sm;
    }


}
