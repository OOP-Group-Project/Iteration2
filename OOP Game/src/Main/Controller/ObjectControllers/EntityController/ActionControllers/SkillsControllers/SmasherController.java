package Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Items.WeaponTypeEnum;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Skills.Brawling;
import Main.Model.Skills.OneHandedWeapon;
import Main.Model.Skills.Skills;
import Main.Model.Skills.TwoHandedWeapon;
import Main.Model.Stats.StatsModifier;

import java.lang.annotation.Target;

/**
 * Created by johnkaufmann on 3/13/16.
 * TODO:
 */
public class SmasherController {
    Entity entity;
    Entity enemy;
    Map map;
    //Skills skill1 = entity.get

    public SmasherController(Entity entity, Map map) {
        this.entity = entity;
        this.map = map;
    }

    public void performSkill(UserActionEnum u) {
        switch (u) {
            case Skill4:
                if (validateOneHanded()) {
                    MapLocationPoint targetLocation = entity.getLocation().getAdjacent(entity.getOrientation());
                    if (map.getTile((int)targetLocation.getX(), (int)targetLocation.getY()).hasEntity()) {
                        StatsModifier sm = new StatsModifier();

                    }
                    entity.getStats().modifyStats(new OneHandedWeapon(entity).activate());
                }
                break;
            case Skill5:
                if (validateTwoHanded())
                    entity.getStats().modifyStats(new TwoHandedWeapon(entity).activate());
                break;
            case Skill6:
                if (validateBrawling())
                    entity.getStats().modifyStats(new Brawling(entity).activate());
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
        if (entity.getEquipment().getWeapon().getWeaponType() == WeaponTypeEnum.ONEHANDSWORD)
            return true;
        return false;
    }
}
