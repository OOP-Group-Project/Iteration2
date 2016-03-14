package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class OneHandedWeapon extends SmasherSkills {
    public OneHandedWeapon(Entity entity) {

        //1.4 second cooldown 2 mana cost
        super(entity, 1.4, 2.0);
        damageFactor = 3;
        skillName = "One handed weapon attack";
    }

}
