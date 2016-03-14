package Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Skills.*;

/**
 * Created by johnkaufmann on 3/13/16.
 * TODO:
 */
public class SneakController {
    Entity sneak;
    Map map;

    public SneakController(Entity sneak, Map map) {
        this.sneak = sneak;
        this.map = map;
    }

    public void performSkill(UserActionEnum u) {
      /*  switch (u) {
            case Skill1:
                if (validatePickPocket()) new PickPocket(sneak).apply();
                break;
            case Skill2:
                if (validateDetectTrap()) new DetectTrap(sneak).apply();
                if (validateRemoveTrap()) new RemoveTrap(sneak).apply();
                break;
            case Skill3:
                if (validateCreep()) new Creep(sneak).apply();
                break;
            case Skill4:
                if (validateRangedWeapon()) new RangedWeapon(sneak).apply();
                break;
            default:
                System.out.print("Something went wrong in" + this.toString());
        }*/
    }

    private boolean validateRangedWeapon() {
        return false;
    }

    private boolean validateCreep() {
        return false;
    }

    private boolean validateRemoveTrap() {
        return false;
    }

    private boolean validateDetectTrap() {
        MapLocationPoint point = sneak.getLocation().getAdjacent(sneak.getOrientation());
        if (true) return true;
        return false;
    }

    //check to see if theres an entity if so apply pickpocket
    private boolean validatePickPocket() {
        MapLocationPoint point = sneak.getLocation().getAdjacent(sneak.getOrientation());
//        if (map.getTile(point.x, point.y).getEntity()) return true;
        return true;
    }
}
