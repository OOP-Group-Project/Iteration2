package Main.Controller.ObjectControllers.EntityController;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.ActionController;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.MovementController;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;

/**
 * Created by mason on 3/13/16.
 */
public class AvatarController extends EntityController {

    private MovementController movementController;
    private ActionController actionController;
    private Avatar player;

    public AvatarController(Map world, Avatar player) {
        this.movementController = new MovementController(world, player);
        this.actionController = new ActionController(world, player);
        this.player = player;
    }

    public void handleInput(UserActionEnum action) {
        if(isMovement(action)) {
            movementController.move(action);
        } else if(isAction(action)) {
            actionController.performAction(action);
        }
    }

    @Override
    public void respawn(MapLocationPoint respawnPoint) {
        player.respawn(respawnPoint);
    }

    @Override
    public void update() {
        if(player.hasHealth()) {
            movementController.update();
            actionController.update();
        }
    }
}
