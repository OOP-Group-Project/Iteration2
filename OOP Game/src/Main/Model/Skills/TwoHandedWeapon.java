package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;

import java.util.Random;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class TwoHandedWeapon extends SmasherSkills {
    public TwoHandedWeapon(Entity entity) {
        //3 second cooldown and 6 mana cost
        super(entity, 3.0, 6.0);
    }

    public void activate(Entity npc) {
        double totalDamage = 0;
        if (canActivate() && enoughMana()){
            Random rand = new Random();
            int randomNum = rand.nextInt(100);
            if (level * 20 > randomNum) {
                Stats stats = entity.getStats();
                //should use the Attack class to calc this
                totalDamage = stats.curOffense() + stats.curStrength() + level * 15;
                npc.modifyStats("hp", -totalDamage);
            }
            enforceManaCost();
        }
    }

    private boolean canActivate() {
        //is a two handed weapon equipped?
        //getWeapon().getWeaponType() == TWOHANDSWORD
        //return true if so
        return true;
    }
}
