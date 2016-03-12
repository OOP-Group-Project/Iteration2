package Main.Model.Items.ItemBuilders;

import Main.Model.Items.Armor;
import Main.Model.Items.ArmorTypeEnum;
import Main.Model.Items.Item;
import Main.Model.Items.ItemTypeEnum;
import Main.Model.Skills.Skill;

/**
 * Created by mason on 3/11/16.
 */
public class ArmorBuilder extends ItemBuilder {

    private ArmorTypeEnum armorType;
    private Skill skills[] = null;

    public ArmorBuilder(ArmorTypeEnum armorType, String name) {
        super(ItemTypeEnum.Equippable, name);
        this.armorType = armorType;
    }

    public ArmorBuilder setSkills(Skill skills[]) {
        this.skills = skills;
        return this;
    }

    @Override
    public Item build() {
        return new Armor(armorType, name, statsModifiers, requirements, skills);
    }
}
