package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class RangedWeapon extends SneakSkills{

    public RangedWeapon(Entity entity) {
        //1 second cooldown and 2 mana cost
        super(entity, 2.0, 0);
    }

    public StatsModifier activate() {
        double totalDamage = 0;
        if (canActivate() && enoughMana() && successfulPerfoemance()){
            Stats stats = entity.getStats();
            totalDamage = stats.curAgility() + level * 10;
            enforceManaCost();
        }
        StatsModifier sm = new StatsModifier();
        sm = sm.builder().lifeModifier(-totalDamage).build();
        return sm;
    }

    private boolean canActivate() {
        //is fist weapon equipped?
        //getWeapon().getWeaponType == TWOHANDED?
        //return true if so
        return true;
    }
}