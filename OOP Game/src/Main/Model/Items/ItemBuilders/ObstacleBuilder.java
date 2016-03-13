package Main.Model.Items.ItemBuilders;

import Main.Model.Items.Item;
import Main.Model.Items.ItemTypeEnum;
import Main.Model.Items.Obstacle;

/**
 * Created by mason on 3/11/16.
 */
public class ObstacleBuilder extends ItemBuilder {

    public ObstacleBuilder(String name, int id) {
        super(ItemTypeEnum.Equippable, name, id);
    }

    @Override
    public Item build() {
        return new Obstacle(name, id, statsModifiers, requirements);
    }
}