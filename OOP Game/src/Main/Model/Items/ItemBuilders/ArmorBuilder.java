package Main.Model.Items.ItemBuilders;

import Main.Model.Items.Armor;
import Main.Model.Items.ArmorTypeEnum;
import Main.Model.Items.Item;
import Main.Model.Items.ItemTypeEnum;
import Main.Model.Skills.Skills;

/**
 * Created by mason on 3/11/16.
 */
public class ArmorBuilder extends ItemBuilder {

    private ArmorTypeEnum armorType;
    private Skills skills[] = null;

    public ArmorBuilder(ArmorTypeEnum armorType, String name, int id) {
        super(ItemTypeEnum.Equippable, name, id);
        this.armorType = armorType;
    }

    public ArmorBuilder setSkills(Skills skills[]) {
        this.skills = skills;
        return this;
    }

    @Override
    public Item build() {
        return new Armor(armorType, name, id, statsModifiers, requirements, skills);
    }
}
