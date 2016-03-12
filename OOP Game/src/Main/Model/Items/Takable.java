package Main.Model.Items;

import Main.Model.Stats.StatsModifier;
import Main.Model.Entity.Entity;
import Main.Model.Requirement;

/**
 * Created by Matthew on 3/7/16.
 */
public class Takable extends Item {
    public Takable(ItemTypeEnum type, String name, StatsModifier statsModifiers[], Requirement requirements[]) {
        super(type, name, statsModifiers, requirements);
    }


    public void activate(Entity entity) {

    }

    public void deactivate(Entity entity) {

    }


}
