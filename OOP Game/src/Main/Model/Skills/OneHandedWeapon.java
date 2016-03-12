package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;

import java.util.Random;

/**
 * Created by Matthew on 3/12/2016.
 */
public class OneHandedWeapon extends Skills{

    public OneHandedWeapon(Entity entity) {
        //2 second cooldown 4 mana cost
        super(entity, 2.0, 4.0);
    }

    public void activate(Entity npc) {
        double totalDamage = 0;
        if (canActivate() && enoughMana()){
            Random rand = new Random();
            int randomNum = rand.nextInt(100);
            if (level * 20 > randomNum) {
                Stats stats = entity.getStats();
                //should use the Attack class to calc this
                totalDamage = stats.curOffense() + stats.curStrength() + level * 10;
                npc.modifyStats("hp", -totalDamage);
            }
            enforceManaCost();
        }
    }

    private boolean canActivate() {
        //is a one handed weapon equipped?
        //getWeapon().getWeaponType() == ONEHANDSWORD
        //return true if so
        return true;
    }
}
