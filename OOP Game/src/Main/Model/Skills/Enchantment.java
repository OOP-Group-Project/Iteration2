package Main.Model.Skills;

import Main.Model.Entity.Entity;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Enchantment extends Skills{
    //make npc fall asleep

    public Enchantment(Entity entity) {
        //10 sec cooldown and 5 mana cost
        super(entity, 10.0, 5.0);
    }

    public void activate(Entity npc) {
        if(enoughMana()) {
            Random rand = new Random();
            int randomNum = rand.nextInt(100);
            if (level * 10 > randomNum) {
                //npc.goToSleep()
            }
            enforceManaCost();
        }
    }

}
