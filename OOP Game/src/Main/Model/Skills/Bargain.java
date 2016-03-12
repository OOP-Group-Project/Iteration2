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

    public double activate() {
        //takes off level * 10 from the
        //price of the item in the shop
        return level * 10;
    }
}
