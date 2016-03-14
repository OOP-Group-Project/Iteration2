package Main.Controller.EntityControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.ObjectController;

/**
 * Created by johnkaufmann on 3/10/16.
 * TODO:
 */
public abstract class EntityController extends ObjectController {

    protected boolean isAction(UserActionEnum U) {
        if (U.ordinal() > 7 && U.ordinal() < 10) {
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

    public abstract void update();
}
