package Main.Controller.EntityControllers.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
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
                if (validateOneHanded()) new OneHandedWeapon(entity).apply();
                break;
            case Skill2:
                if (validateTwoHanded()) new TwoHandedWeapon(entity).apply();
                break;
            case Skill3:
                if (validateBrawling()) new Brawling(entity).apply();
                break;
            default:
                System.out.print("Something went wrong in" + this.toString());
        }
    }

    private boolean validateBrawling() {
        if (entity.getEquipment().getWeapon().getWeaponType().FIST) return true;
        return false;
    }

    private boolean validateTwoHanded() {
        if (entity.getEquipment().getWeapon().getWeaponType().TWOHANDSWORD) return true;
        return false;
    }

    private boolean validateOneHanded() {
        if (entity.getEquipment().getWeapon().getWeaponType().ONEHANDSWORD) return true;
        return false;
    }
}
