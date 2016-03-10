package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.DirectionEnum;
import Main.Model.State.PlayState;


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
                playState.getPlayer().move(DirectionEnum.Up);
                break;
            case UpRight:
                playState.getPlayer().move(DirectionEnum.UpRight);
                break;
            case UpLeft:
                playState.getPlayer().move(DirectionEnum.UpLeft);
                break;
            case Down:
                playState.getPlayer().move(DirectionEnum.Down);
                break;
            case DownLeft:
                playState.getPlayer().move(DirectionEnum.DownLeft);
                break;
            case DownRight:
                playState.getPlayer().move(DirectionEnum.DownRight);
                break;
        }
    }
}

