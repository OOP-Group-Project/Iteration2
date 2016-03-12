package Main.Model.Items.ItemBuilders;

import Main.Model.Stats.StatsModifier;
import Main.Model.Items.Item;
import Main.Model.Items.ItemTypeEnum;
import Main.Model.Requirement;

/**
 * Created by mason on 3/11/16.
 */
public abstract class ItemBuilder {
    protected ItemTypeEnum type;
    protected String name;
    protected Requirement requirements[] = null;
    protected StatsModifier statsModifiers[] = null;

    public ItemBuilder(ItemTypeEnum type, String name) {
        this.type = type;
        this.name = name;
    }

    public ItemBuilder setRequirements(Requirement requirements[]) {
        this.requirements = requirements;
        return this;
    }

    public ItemBuilder setStatsModifiers(StatsModifier statsModifiers[]) {
        this.statsModifiers = statsModifiers;
        return this;
    }

    public abstract Item build();

}
