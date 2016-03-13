package Main.Controller.StateControllers;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.ObjectControllers.EntityController.AvatarController;
import Main.Controller.ObjectControllers.EntityController.EntityController;
import Main.Controller.ObjectControllers.EntityController.NpcController;
import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.MapController;
import Main.Model.DirectionEnum;
import Main.Model.State.PlayState;
import Main.Model.State.StateEnum;


/**
 * Created by mason on 3/9/16.
 */
public class PlayStateController extends StateController {

    private StateControllerManager stateControllerManager;
    private ObjectControllerManager objectControllerManager;
    private PlayState playState;

    public PlayStateController(StateControllerManager stateControllerManager, ObjectControllerManager objectControllerManager, PlayState playState) {
        this.stateControllerManager = stateControllerManager;
        this.objectControllerManager = objectControllerManager;
        this.playState = playState;
    }

    @Override
    public void update() {
        ((MapController)objectControllerManager.getObjectController(playState.getWorld())).update();
    }

    @Override
    public void handleAction(UserActionEnum action) {
        ((AvatarController)objectControllerManager.getObjectController(playState.getPlayer())).handleInput(action);
        switch(action) {
            case Up:
            case UpRight:
            case UpLeft:
            case Down:
            case DownLeft:
            case DownRight:
                playState.centerToAvatar();
                break;
            case Pause:
                stateControllerManager.setState(StateEnum.PauseState);
                break;
            case ViewUp:
                playState.moveCenterPoint(DirectionEnum.Up);
                break;
            case ViewUpLeft:
                playState.moveCenterPoint(DirectionEnum.UpLeft);
                break;
            case ViewUpRight:
                playState.moveCenterPoint(DirectionEnum.UpRight);
                break;
            case ViewDown:
                playState.moveCenterPoint(DirectionEnum.Down);
                break;
            case ViewDownLeft:
                playState.moveCenterPoint(DirectionEnum.DownLeft);
                break;
            case ViewDownRight:
                playState.moveCenterPoint(DirectionEnum.DownRight);
                break;
            case Select:
            	stateControllerManager.setState(StateEnum.InventoryState);
            	break;
            case Talk:
                stateControllerManager.setState(StateEnum.TalkState);
                break;
        }
    }
}

