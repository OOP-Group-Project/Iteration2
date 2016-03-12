package Main.Model.Items;

import Main.Model.Stats.StatsModifier;
import Main.Model.Entity.Entity;
import Main.Model.Requirement;

/**
 * Created by Matthew on 3/7/16.
 */
public class Oneshot extends Item {

    public Oneshot(String name, StatsModifier statsModifiers[], Requirement requirements[]){
        super(ItemTypeEnum.Oneshot, name, statsModifiers, requirements);
    }

    public void activate(Entity entity){
        //increase entity's stats by the mods
        for (StatsModifier statsModifier : statsModifiers) {
            entity.modifyStats(statsModifier);
        }
    }
}
