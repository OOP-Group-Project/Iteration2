package Main.Model.Skills;

import Main.Model.Entity.Entity;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class Bargain extends BaseSkills {

    public Bargain(Entity entity) {
        //0 cooldown and mana cost
        super(entity, 0, 0);
    }

    public int activate() {
        if (!this.successfulPerfoemance()) {
            System.out.println("performance of Bargain failed and the vendor is angry!");
            return 0;
        }
        //takes off level * 10 from the
        //price of the item in the shop
        else {
            return level * 10;
        }
    }
}
