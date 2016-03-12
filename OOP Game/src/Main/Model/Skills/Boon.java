package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Boon extends Skills{


    public Boon(Entity entity) {
        super(entity, 20.0, 10.0);
    }

    public void activate() {
        if(enoughMana()) {
            Random rand = new Random();
            int randomNum = rand.nextInt(100);
            if (level * 20 > randomNum) {
                double increaseByAmount = level * 4;
                entity.modifyStats("hp", increaseByAmount);
                entity.buff("int", increaseByAmount);
                entity.buff("off", increaseByAmount);
                entity.buff("def", increaseByAmount);
                entity.buff("arm", increaseByAmount);
                //add partial immunities?
                //how/when to remove buff?
            }
            //decrease mana
            enforceManaCost();
        }
    }
}
