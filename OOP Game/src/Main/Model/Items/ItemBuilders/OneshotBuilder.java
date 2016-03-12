package Main.Model.Items.ItemBuilders;

import Main.Model.Items.Item;
import Main.Model.Items.ItemTypeEnum;
import Main.Model.Items.Oneshot;

/**
 * Created by mason on 3/11/16.
 */
public class OneshotBuilder extends ItemBuilder {

    public OneshotBuilder(String name) {
        super(ItemTypeEnum.Oneshot, name);
    }

    @Override
    public Item build() {
        return new Oneshot(name, statsModifiers, requirements);
    }
}