package Main.Controller.ObjectControllers.EntityController;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.ActionController;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.MovementController;
import Main.Model.Entity.Entity;
import Main.Model.Entity.Npc;
import Main.Model.Map.Heuristic;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import com.sun.javafx.sg.prism.NGParallelCamera;

/**
 * Created by Michael on 3/13/16.
 */
public class NpcController extends Main.Controller.ObjectControllers.EntityController.EntityController {
    private ActionController actionController;
    private NpcMovementGenerator npcMovementGenerator;
    private MovementController movementController;
    private Npc npc;

    public NpcController(ObjectControllerManager objectControllerManager, Map map, Entity entity, Npc npc) {
        this.npcMovementGenerator = new NpcMovementGenerator(map, entity, npc, new  Heuristic());
        this.actionController = new ActionController(objectControllerManager, map, entity);
        this.movementController = new MovementController(map, npc);
        this.npc = npc;
    }

    @Override
    public void respawn(MapLocationPoint respawnPoint) {
        npc.respawn(respawnPoint);
    }

    public void update(){
        npcMovementGenerator.update();
        movementController.update();
        actionController.update();
        UserActionEnum nextMove = npcMovementGenerator.getNextMovement();
        if(nextMove != null) {
            movementController.move(nextMove);
        }

    }
}
