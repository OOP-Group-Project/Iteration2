package Main.Controller.ObjectControllers.EntityController;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.ObjectController;
import Main.Model.Map.MapLocationPoint;

/**
 * Created by johnkaufmann on 3/10/16.
 * TODO:
 */
public abstract class EntityController extends ObjectController {

    protected boolean isAction(UserActionEnum U) {
        if (U.ordinal() >= 8 && U.ordinal() <= 31) {
            //System.out.println("Found an action!");
            return true;
        }
        else return false;
    }

    protected boolean isMovement(UserActionEnum U) {
        if (U.ordinal() < 8) {
            //System.out.println("Found a movment!");
            return true;
        }
        else return false;
    }

    public abstract void respawn(MapLocationPoint respawnPoint);

    public abstract void update();
}
