package Main.Controller.ObjectControllers.EntityController;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.ActionController;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.MovementController;
import Main.Model.Entity.Avatar;
import Main.Model.Entity.Mount;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;

/**
 * Created by mason on 3/13/16.
 */
public class AvatarController extends EntityController {

    private MovementController movementController;
    private ActionController actionController;
    private Avatar player;
    private MountController mountController;

    public AvatarController(ObjectControllerManager objectControllerManager, Map world, Avatar player) {
        this.mountController = null;
        this.movementController = new MovementController(world, player);
        this.actionController = new ActionController(objectControllerManager, world, player);
        this.player = player;
    }

    public void handleInput(UserActionEnum action) {

        if(mountController == null) {
            if(isMovement(action)) {
                movementController.move(action);
            } else if(isAction(action)) {
                actionController.performAction(action);
            }
        } else {
            mountController.handleInput(action);
        }
    }

    public void takeControlOfMount(MountController mountController) {
        this.mountController = mountController;
        mountController.addEntityToMount(this, player);
    }

    public void getOutOfMount() {
        this.mountController = null;
    }

    public boolean checkBlocked(MapLocationPoint point) {
        return movementController.checkBlocked(point);
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
