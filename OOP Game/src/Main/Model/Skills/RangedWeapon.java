package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;


/**
 * Created by Matthew on 3/12/2016.
 */
public class RangedWeapon extends SneakSkills{

    public RangedWeapon(Entity entity) {
        //1 second cooldown and 2 mana cost
        super(entity, 2.0, 0);
        skillName = "Ranged Weapon";
    }

    public StatsModifier attack() {
        double totalDamage = 0;
        StatsModifier sm = new StatsModifier();
        if (allCheck()) {
            Stats stats = entity.getStats();
            timeWhenPerformed = System.currentTimeMillis();
            totalDamage = stats.curAgility() * level * 2;
            sm = sm.builder().lifeModifier(-totalDamage).build();
            enforceManaCost();
            return sm;
        }
        else {
            return sm;
        }
    }
}
