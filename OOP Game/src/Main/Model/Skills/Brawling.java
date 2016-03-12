package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Brawling extends Skills{

    public Brawling(Entity entity) {
        //1 second cooldown and 2 mana cost
        super(entity, 1.0, 2.0);
    }

    public void activate(Entity npc) {
        double totalDamage = 0;
        if (canActivate() && enoughMana()){
            Random rand = new Random();
            int randomNum = rand.nextInt(100);
            if (level * 20 > randomNum) {
                Stats stats = entity.getStats();
                //should use the Attack class to calc this
                totalDamage = stats.curOffense() + stats.curStrength() + level * 5;
                npc.modifyStats("hp", -totalDamage);
            }
            enforceManaCost();
        }
    }

    private boolean canActivate() {
        //is fist weapon equipped?
        //getWeapon().getWeaponType == FIST?
        //return true if so
        return true;
    }
}
