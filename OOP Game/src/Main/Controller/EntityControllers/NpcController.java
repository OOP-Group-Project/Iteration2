package Main.Controller.EntityControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.EntityController.*;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.ActionController;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.MovementController;
import Main.Model.Entity.Entity;
import Main.Model.Map.Heuristic;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;

/**
 * Created by Michael on 3/13/16.
 */
public class NpcController extends Main.Controller.ObjectControllers.EntityController.EntityController {
    private ActionController actionController;
    private NpcMovementGenerator npcMovementGenerator;
    private MovementController movementController;

    public NpcController(Map map, Entity entity, Entity npc) {
        this.npcMovementGenerator = new NpcMovementGenerator(map, entity, npc, new  Heuristic());
        this.actionController = new ActionController(map, entity);
        this.movementController = new MovementController(map, npc);
    }

    @Override
    public void respawn(MapLocationPoint respawnPoint) {

    }

    public void update(){
        npcMovementGenerator.update();
        UserActionEnum nextMove = npcMovementGenerator.getNextMovement();
        if(nextMove != null) {
            movementController.move(nextMove);
        }
        movementController.update();
        actionController.update();

    }
}
