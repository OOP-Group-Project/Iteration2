package Main.Model.Items;

import Main.Model.Stats.StatsModifier;
import Main.Model.Requirement;

/**
 * Created by Matthew on 3/7/16.
 */
public abstract class Equippable extends Takable {

    public Equippable(ItemTypeEnum type, String name, int id, StatsModifier statsModifiers[], Requirement requirements[]){
        super(type, name, id, statsModifiers, requirements);
    }

}
