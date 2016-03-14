package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class BindWounds extends BaseSkills {

    public BindWounds(Entity entity) {
        //sets cooldown period to 10 seconds and mana cost to 10
        super(entity, 10.0, 5.0);
        skillName = "Bind wounds";
    }

    public void activate() {
        if (allCheck()) {
            timeWhenPerformed = System.currentTimeMillis();
            enforceManaCost();
            Stats stats = entity.getStats();
            double amountToHeal = level * 3 + 4;
            StatsModifier sm = new StatsModifier();
            sm = sm.builder().lifeModifier(amountToHeal).build();
            stats.modifyStats(sm);
            System.out.println("Performance of " + skillName + " is successful");
            System.out.println("The amount to heal is: " + amountToHeal);
        }
        else {
            return;
        }
    }
}
