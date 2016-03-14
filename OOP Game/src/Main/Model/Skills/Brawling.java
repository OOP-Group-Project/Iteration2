package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class Brawling extends SmasherSkills{
    public Brawling(Entity entity) {
        //1 second cooldown and 2 mana cost
        super(entity, 1.0, 2.0);

        damageFactor = 1;
        skillName = "Brawling";
    }

}
