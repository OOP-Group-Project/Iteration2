package Main.Model.Items;

import Main.Model.Stats.StatsModifier;
import Main.Model.Requirement;

/**
 * Created by walkhard on 2/18/16.
 */
public class Obstacle extends Item {

    public Obstacle(String name, StatsModifier statsModifiers[], Requirement requirements[]){
        super(ItemTypeEnum.Obstactle, name, statsModifiers, requirements);
    }
}
