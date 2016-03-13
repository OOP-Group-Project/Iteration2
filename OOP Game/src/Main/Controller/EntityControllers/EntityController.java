package Main.Controller.EntityControllers;

import Main.Controller.EntityControllers.ActionControllers.ActionController;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Heuristic;
import Main.Model.Map.Map;

import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/10/16.
 * TODO:
 */
public class EntityController {
    private PlayerMovementController PlayerMovementController;
    private Main.Controller.EntityControllers.ActionControllers.ActionController ActionController;
//    private NpcMovementController NpcMovementController;

    public EntityController(Map map , Entity entity) {
        this.PlayerMovementController = new PlayerMovementController(map, entity );
//        this.NpcMovementController = new NpcMovementController(map, entity, npc ,new Heuristic());
        this.ActionController = new ActionController(map, entity);
    }

    public void handleInput(UserActionEnum U) {
        if (isMovement(U)) PlayerMovementController.move(U);
        if (isAction(U)) ActionController.performAction(U);
    }

    public void update(){
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
