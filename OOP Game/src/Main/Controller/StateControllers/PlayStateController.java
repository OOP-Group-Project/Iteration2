package Main.Controller.StateControllers;

import Main.Controller.EntityControllers.EntityController;
import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.State.PlayState;
import Main.Model.State.StateEnum;


/**
 * Created by mason on 3/9/16.
 */
public class PlayStateController extends StateController {

    private StateControllerManager stateControllerManager;
    private PlayState playState;
    private EntityController ec;

    public PlayStateController(StateControllerManager stateControllerManager, PlayState playState) {
        this.stateControllerManager = stateControllerManager;
        this.playState = playState;
        this.ec = new EntityController(playState.getWorld(), playState.getPlayer());
    }

    @Override
    public void update() {
        
    }

    @Override
    public void handleAction(UserActionEnum action) {
        ec.handleInput(action);
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
        }
    }
}

