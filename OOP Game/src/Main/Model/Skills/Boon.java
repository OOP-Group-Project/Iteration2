package Main.Model.Skills;

import Main.Model.Entity.Entity;

import java.util.Random;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class Boon extends SummonerSkills {
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
