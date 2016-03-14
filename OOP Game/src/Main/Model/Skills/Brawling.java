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
            double totalDamage = 0;
            if (canActivate() && enoughMana()) {
                Stats stats = entity.getStats();
                //TODO:should use the Attack class to calc this
                totalDamage = stats.curOffense() * level * 5;
                StatsModifier sm = new StatsModifier();
                sm.builder().lifeModifier(-totalDamage).build();
                //enemy.getStats().modifyStats(sm);
            }
            enforceManaCost();
        }
    }

    private boolean canActivate() {
        /**TODO:
         is a one handed weapon equipped?
         getWeapon().getWeaponType() == ONEHANDSWORD
         return true if so
         TODO: and disable TwoHandedWeapon before OneHandedWeapon cooled down?
         */
        return true;
    }

}
