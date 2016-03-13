package Main.Model.Items.ItemBuilders;

import Main.Model.Items.Item;
import Main.Model.Items.ItemTypeEnum;
import Main.Model.Items.Takable;

/**
 * Created by mason on 3/11/16.
 */
public class TakableBuilder extends ItemBuilder {

    public TakableBuilder(String name, int id) {
        super(ItemTypeEnum.Takable, name, id);
    }

    @Override
    public Item build() {
        return new Takable(type, name, id, statsModifiers, requirements);
    }

}
