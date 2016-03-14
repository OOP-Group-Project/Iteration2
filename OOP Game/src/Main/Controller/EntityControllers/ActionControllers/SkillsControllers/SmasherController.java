package Main.Controller.EntityControllers.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Items.WeaponTypeEnum;
import Main.Model.Map.Map;
import Main.Model.Skills.Brawling;
import Main.Model.Skills.OneHandedWeapon;
import Main.Model.Skills.TwoHandedWeapon;

/**
 * Created by johnkaufmann on 3/13/16.
 * TODO:
 */
public class SmasherController {
    Entity entity;
    Map map;

    public SmasherController(Entity entity, Map map) {
        this.entity = entity;
        this.map = map;
    }

    public void performSkill(UserActionEnum u) {
        switch (u) {
            case Skill1:
                if (validateOneHanded()) entity.getStats().modifyStats(new OneHandedWeapon(entity).activate());
                break;
            case Skill2:
                if (validateTwoHanded()) entity.getStats().modifyStats(new TwoHandedWeapon(entity).activate());
                break;
            case Skill3:
                if (validateBrawling()) entity.getStats().modifyStats(new Brawling(entity).activate());
                break;
            default:
                System.out.print("Something went wrong in" + this.toString());
        }
    }

    private boolean validateBrawling() {
        if (entity.getEquipment().getWeapon().getWeaponType() == WeaponTypeEnum.FIST) return true;
        return false;
    }

    private boolean validateTwoHanded() {
        if (entity.getEquipment().getWeapon().getWeaponType() == WeaponTypeEnum.TWOHANDSWORD) return true;
        return false;
    }

    private boolean validateOneHanded() {
        if (entity.getEquipment().getWeapon().getWeaponType() == WeaponTypeEnum.ONEHANDSWORD) return true;
        return false;
    }
}
