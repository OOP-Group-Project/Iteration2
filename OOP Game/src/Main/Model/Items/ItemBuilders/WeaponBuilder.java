package Main.Model.Items.ItemBuilders;

import Main.Model.Actions.Attack;
import Main.Model.Items.Item;
import Main.Model.Items.ItemTypeEnum;
import Main.Model.Items.Weapon;
import Main.Model.Items.WeaponTypeEnum;
import Main.Model.Skills.Skill;

/**
 * Created by mason on 3/11/16.
 */
public class WeaponBuilder extends ItemBuilder {

    private WeaponTypeEnum type = WeaponTypeEnum.FIST;
    private Attack attack = null;
//    private Skill skills[] = null;

    public WeaponBuilder(WeaponTypeEnum type, String name, int id) {
        super(ItemTypeEnum.Equippable, name, id);
        this.type = type;
    }

    public WeaponBuilder setAttack(Attack attack) {
        this.attack = attack;
        return this;
    }

//    public WeaponBuilder setSkills(Skill skills[]) {
//        this.skills = skills;
//        return this;
//    }

    @Override
    public Item build() {
        return new Weapon(type, name, id, statsModifiers, requirements, attack);
    }
}
