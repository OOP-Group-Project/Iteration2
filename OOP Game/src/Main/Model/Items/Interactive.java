package Main.Model.Items;

import Main.Model.Stats.StatsModifier;
import Main.Model.Entity.Entity;
import Main.Model.Requirement;

/**
 * Created by Matthew on 3/7/16.
 */
public class Interactive extends Item {
    public Interactive(String name, StatsModifier statsModifiers[], Requirement requirements[]){
        super(ItemTypeEnum.Interactive, name, statsModifiers, requirements);
    }

    public void interact(Entity entity) {
        //activate item (increase skills?)
    }
}
