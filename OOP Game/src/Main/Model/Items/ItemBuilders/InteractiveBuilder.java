package Main.Model.Items.ItemBuilders;

import Main.Model.Items.Interactive;
import Main.Model.Items.Item;
import Main.Model.Items.ItemTypeEnum;

/**
 * Created by mason on 3/11/16.
 */
public class InteractiveBuilder extends ItemBuilder {

    public InteractiveBuilder(String name) {
        super(ItemTypeEnum.Interactive, name);
    }

    @Override
    public Item build() {
        return new Interactive(name, statsModifiers, requirements);
    }
}
