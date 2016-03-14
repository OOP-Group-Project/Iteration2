package Main.Model.Skills;

import Main.Model.Entity.Entity;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Boon extends SummonerSkills {


    public Boon(Entity entity) {
        super(entity, 20.0, 10.0);
    }

    public void activate() {
        if (!enoughMana()) {
            System.out.println("Not enough mana");
            return;
        }
        else if (!this.successfulPerfoemance()) {
            enforceManaCost();
            System.out.println("performance of BindWounds failed but");
            return;
        }
        else {
            double increaseByAmount = level * 4;
            entity.modifyStats("hp", increaseByAmount);
            entity.buff("int", increaseByAmount);
            entity.buff("off", increaseByAmount);
            entity.buff("def", increaseByAmount);
            entity.buff("arm", increaseByAmount);
            //add partial immunities?
            //how/when to remove buff?

            //decrease mana
            enforceManaCost();
        }
    }

}
