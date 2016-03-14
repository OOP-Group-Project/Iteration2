package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class TwoHandedWeapon extends SmasherSkills {

    public TwoHandedWeapon(Entity entity) {
        //2 second cooldown and 0 mana cost
        super(entity, 2.0, 0);
        skillName = "Two handed weapon attack";
        damageFactor = 6;
    }
}
