package Main.Controller.StateControllers;

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

    public PlayStateController(StateControllerManager stateControllerManager, PlayState playState) {
        this.stateControllerManager = stateControllerManager;
        this.playState = playState;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void handleAction(UserActionEnum action) {
        switch(action) {
            case Up:
                playState.movePlayer(DirectionEnum.Up);
                break;
            case UpRight:
                playState.movePlayer(DirectionEnum.UpRight);
                break;
            case UpLeft:
                playState.movePlayer(DirectionEnum.UpLeft);
                break;
            case Down:
                playState.movePlayer(DirectionEnum.Down);
                break;
            case DownLeft:
                playState.movePlayer(DirectionEnum.DownLeft);
                break;
            case DownRight:
                playState.movePlayer(DirectionEnum.DownRight);
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

