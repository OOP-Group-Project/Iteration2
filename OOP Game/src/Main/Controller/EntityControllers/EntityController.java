package Main.Controller.EntityControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;

/**
 * Created by johnkaufmann on 3/10/16.
 * TODO:
 */
public class EntityController {
    private MovementController MovementController;
    private ActionController ActionController;

    public EntityController(Map map , Entity entity) {
        this.MovementController = new MovementController(map, entity);
        this.ActionController = new ActionController(map, entity);
    }

    public void handleInput(UserActionEnum U) {
        if (isMovement(U)) MovementController.move(U);
        if (isAction(U)) ActionController.performAction(U);
    }

    private boolean isAction(UserActionEnum U) {
        if (U.ordinal() < 8) {
            System.out.print("Found an action!");
            return true;
        }
        else return false;
    }

    private boolean isMovement(UserActionEnum U) {
        if (U.ordinal() > 7 && U.ordinal() < 10) {
            System.out.print("Found a movment!");
            return true;
        }
        else return false;
    }

    public void update() {

    }
}
