package Main.Controller.EntityControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Heuristic;
import Main.Model.Map.Map;

/**
 * Created by johnkaufmann on 3/10/16.
 * TODO:
 */
public class EntityController {
    private MovementController MovementController;
    private ActionController ActionController;
    private PathingController pathingController;

    public EntityController(Map map , Entity entity, Entity enemy) {
        this.MovementController = new MovementController(map, entity);
        this.pathingController = new PathingController(map, entity, enemy ,new Heuristic());
        this.ActionController = new ActionController(map, entity);
    }

    public void handleInput(UserActionEnum U) {
        if (isMovement(U)) MovementController.move(U);
        if (isAction(U)) ActionController.performAction(U);
    }

    public void update(){
        pathingController.update();
    }

    private boolean isAction(UserActionEnum U) {
        if (U.ordinal() > 7 && U.ordinal() < 10) {
            //System.out.println("Found an action!");
            return true;
        }
        else return false;
    }

    private boolean isMovement(UserActionEnum U) {
        if (U.ordinal() < 8) {
            //System.out.println("Found a movment!");
            return true;
        }
        else return false;
    }
}
