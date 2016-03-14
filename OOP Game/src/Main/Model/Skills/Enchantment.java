package Main.Model.Skills;

import Main.Model.Entity.Entity;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Enchantment extends SummonerSkills {
    //make npc fall asleep

    public Enchantment(Entity entity) {
        //10 sec cooldown and 5 mana cost
        super(entity, 10.0, 5.0);
    }

    public void activate() {
        if (!enoughMana()) {
            System.out.println("Not enough mana");
            return;
        }
        else if (!this.successfulPerformance()) {
            enforceManaCost();
            System.out.println("performance of BindWounds failed but");
            return;
        }
        else {
            //npc.goToSleep()
            enforceManaCost();
        }

    }
}


