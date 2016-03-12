package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;

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
        if(enoughMana()) {
            Random rand = new Random();
            int randomNum = rand.nextInt(100);
            Stats stats = entity.getStats();
            if (level * 20 > randomNum) {
                double amountToHeal = level * 3 + 4;
                entity.modifyStats("hp", amountToHeal);
            }
            enforceManaCost();
        }
    }
}
