package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Brawling extends SmasherSkill{

    public Brawling(Entity entity) {
        //1 second cooldown and 2 mana cost
        super(entity, 1.0, 0);
    }

    public StatsModifier activate() {
        double totalDamage = 0;
        if (canActivate() && enoughMana() && successfulPerfoemance()){
            Stats stats = entity.getStats();
            totalDamage = stats.curStrength() + level * 5;
            enforceManaCost();
        }
        StatsModifier sm = new StatsModifier();
        sm = sm.builder().lifeModifier(-totalDamage).build();
        return sm;
    }

    private boolean canActivate() {
        //is fist weapon equipped?
        //getWeapon().getWeaponType == FIST?
        //return true if so
        return true;
    }
}
