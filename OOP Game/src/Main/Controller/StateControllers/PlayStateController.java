package Main.Controller.StateControllers;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.ObjectControllers.EntityController.AvatarController;
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
    private UserActionEnum lastAction;

    public PlayStateController(StateControllerManager stateControllerManager, ObjectControllerManager objectControllerManager, PlayState playState) {
        this.stateControllerManager = stateControllerManager;
        this.objectControllerManager = objectControllerManager;
        this.playState = playState;
        this.lastAction = UserActionEnum.None;
    }

    @Override
    public void update() {
        ((MapController)objectControllerManager.getObjectController(playState.getWorld())).update();
        switch(lastAction){
            case ViewUp:
            case ViewUpLeft:
            case ViewUpRight:
            case ViewDown:
            case ViewDownLeft:
            case ViewDownRight:
                break;
            default:
                playState.centerToAvatar();
                break;
        }
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
            case Interact:

                //stateControllerManager.setState(StateEnum.TalkState);
                break;
            case Shift:
                stateControllerManager.setState(StateEnum.StatState);
                break;
            case Control:
                stateControllerManager.setState(StateEnum.KeyBindingsState);
                break;
        }
        lastAction = action;
    }
}

