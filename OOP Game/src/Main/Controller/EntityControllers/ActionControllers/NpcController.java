package Main.Controller.EntityControllers.ActionControllers;

import Main.Controller.EntityControllers.NpcMovementController;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Heuristic;
import Main.Model.Map.Map;

/**
 * Created by Michael on 3/13/16.
 */
public class NpcController {
    private ActionController ActionController;
    private NpcMovementController NpcMovementController;

    public NpcController(Map map, Entity entity, Entity npc) {
        this.NpcMovementController = new NpcMovementController(map, entity, npc, new  Heuristic());
        this.ActionController = new ActionController(map, entity);
    }

    public void handleInput(UserActionEnum U) {
        if (isAction(U)) ActionController.performAction(U);
    }

    public void update(){
        NpcMovementController.update();
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
