package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;

import java.util.Random;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class Bane extends SummonerSkills {

    public Bane(Entity entity) {
        //2.0 cooldown and 5.0 mana cost
        super(entity, 2.0, 5.0);
    }

    public void activate(Entity npc) {
        if(enoughMana()) {
            Random rand = new Random();
            int randomNum = rand.nextInt(100);
            Stats stats = entity.getStats();
            if (level * 20 > randomNum) {
                double currentInt = stats.curIntellect();
                double damageToDeal = level * (currentInt / 3);
                npc.modifyStats("hp", -damageToDeal);
            }
            enforceManaCost();
        }
    }
}
