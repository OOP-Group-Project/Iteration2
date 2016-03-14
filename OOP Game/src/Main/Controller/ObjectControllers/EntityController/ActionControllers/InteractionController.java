package Main.Controller.ObjectControllers.EntityController.ActionControllers;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.Manager.StateControllerManager;
import Main.Controller.ObjectControllers.EntityController.AvatarController;
import Main.Controller.ObjectControllers.EntityController.MountController;
import Main.Controller.ObjectControllers.ObjectController;
import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Entity.Mount;
import Main.Model.Map.Tile;
import Main.Model.State.State;
import Main.Model.State.StateEnum;

/**
 * Created by mason on 3/13/16.
 */
public class InteractionController extends ObjectController {

    private ObjectControllerManager objectControllerManager;
    private StateControllerManager stateControllerManager;
    private TalkStateController talkStateController;
    private Entity player;

    public InteractionController(ObjectControllerManager objectControllerManager, Entity player) {
        this.objectControllerManager = objectControllerManager;
        this.player = player;
    }

    public void executeInteraction(Tile currentTile, Tile tileToInteractWith) {
        // If there's an entity on a tile, interact with it first.
        if(tileToInteractWith.hasEntity()) {
            Entity tileEntity = tileToInteractWith.getEntity();
            if(tileEntity.getType() == EntityTypeEnum.Mount && player.getType() == EntityTypeEnum.Avatar) {
                // Get the mount on the tile and its controller
                Mount mount = (Mount)tileEntity;
                MountController mc = (MountController)objectControllerManager.getObjectController(mount);

                // Remove the player from the current tile and put it into the mount.
                currentTile.removeEntity();
                ((AvatarController)objectControllerManager.getObjectController(player)).takeControlOfMount(mc);

            }else if(tileEntity.getType() == EntityTypeEnum.Shopkeeper && player.getType() == EntityTypeEnum.Avatar){
                //tradeState.setTargetNPC(tileEntity);
                stateControllerManager.setState(StateEnum.TradeState);
            }else if(tileEntity.getType() == EntityTypeEnum.NPC && player.getType() == EntityTypeEnum.Avatar){
                //talkState.setTargetNPC(tileEntity);
                stateControllerManager.setState(StateEnum.TalkState);
            }
        }
        // If there are items on a tile, try to pick them up.
    }

}
