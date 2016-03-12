package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;

/**
 * Created by Matthew on 3/12/2016.
 */
public class Staff extends Skills {

    public Staff(Entity entity) {
        //1 second cooldown, 0 mana cost
        super(entity, 1, 0);
    }

    public void activate(Entity npc) {
        Stats stats = entity.getStats();
        double damageToDeal = stats.curOffense() + 5 * level;
        npc.modifyStats("hp", -damageToDeal);
    }
}
