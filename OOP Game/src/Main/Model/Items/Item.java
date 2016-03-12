package Main.Model.Items;

import Main.Model.Stats.StatsModifier;
import Main.Model.Entity.Entity;
import Main.Model.Requirement;

/**
 * Created by Matthew on 3/7/16.
 */
public abstract class Item {
    protected String name;
    protected ItemTypeEnum type;
    protected Requirement requirements[];
    protected StatsModifier statsModifiers[];

    public Item(ItemTypeEnum type, String name, StatsModifier statsModifiers[], Requirement requirements[]){
        this.name = name;
        this.type = type;
        this.requirements = requirements;
        this.statsModifiers = statsModifiers;
    }

    public String getName() {
        return name;
    }

    public ItemTypeEnum getType() {
        return type;
    }

    public boolean checkRequirements(Entity entity) {
        for(Requirement requirement : requirements) {
            if(requirement.checkRequirement(entity)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


}
