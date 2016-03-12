package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

import java.util.Random;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class BindWounds extends BaseSkills {

    public BindWounds(Entity entity) {
        //sets cooldown period to 10 seconds and mana cost to 10
        super(entity, 10.0, 10.0);
    }

    public void activate() {
        if (!this.successfulPerfoemance()) {
            System.out.println("performance of BindWounds failed");
            return;
        }
        else if (!enoughMana()) {
            System.out.println("Not enough mana");
            return;
        }
        else {
            Random rand = new Random();
            int randomNum = rand.nextInt(100);
            Stats stats = entity.getStats();
            double amountToHeal = level * 3 + 4;
            StatsModifier sm = new StatsModifier();
            sm = sm.builder().lifeModifier(amountToHeal).build();
            stats.modifyStats(sm);
            enforceManaCost();
        }
    }


}
