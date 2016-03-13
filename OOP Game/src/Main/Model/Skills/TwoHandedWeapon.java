package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class TwoHandedWeapon extends SmasherSkill{

    public TwoHandedWeapon(Entity entity) {
        //1 second cooldown and 2 mana cost
        super(entity, 2.0, 0);
    }

    public StatsModifier activate() {
        double totalDamage = 0;
        if (canActivate() && enoughMana()){
            Random rand = new Random();
            int randomNum = rand.nextInt(100);
            if (level * 20 > randomNum) {
                Stats stats = entity.getStats();
                totalDamage = stats.curStrength() + level * 15;
            }
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
