package Main.Controller.ObjectControllers.EntityController;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.MovementController;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;
import Main.Model.Entity.Mount;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Map.Tile;

/**
 * Created by mason on 3/14/16.
 */
public class MountController extends EntityController {

    private Map world;
    private Mount mount;
    private Avatar avatarInMount;
    private MovementController movementController;
    private AvatarController avatarController;

    public MountController(Map world, Mount mount) {
        this.world = world;
        this.mount = mount;
        this.movementController = new MovementController(world, mount);
    }

    public void handleInput(UserActionEnum action) {
        if(isMovement(action)) {
            movementController.move(action);
            avatarInMount.setLocation(mount.getLocation());
        } else if(action == UserActionEnum.Interact) {
            // Try to get out of the mount.
            removeEntityFromMount();
        }
    }

    public void removeEntityFromMount() {
        Avatar avatar = null;
        MapLocationPoint exitLocation = null;

        for(DirectionEnum dir : DirectionEnum.values()) {
            if(avatarController.checkBlocked(mount.getLocation().getAdjacent(dir))) {
                avatar = mount.removePlayerInside();
                exitLocation = mount.getLocation().getAdjacent(dir);
                break;
            }
        }

        if(avatar != null) {
            this.avatarController.getOutOfMount();
            world.addEntity(avatar, exitLocation);
            avatar.setLocation(exitLocation);
            this.avatarInMount = null;
        }
    }

    public void addEntityToMount(AvatarController avatarController, Avatar avatar) {
        this.avatarInMount = avatar;
        this.avatarInMount.setLocation(mount.getLocation());
        mount.setPlayerInside(avatar);
        this.avatarController = avatarController;
    }

    @Override
    public void respawn(MapLocationPoint respawnPoint) {

    }

    @Override
    public void update() {
        movementController.update();
    }
}
