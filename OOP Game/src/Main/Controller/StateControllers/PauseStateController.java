package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.PauseState;

/**
 * Created by mason on 3/10/16.
 */
public class PauseStateController extends StateController {

    private StateControllerManager stateControllerManager;
    private PauseState pauseState;

    public PauseStateController(StateControllerManager stateControllerManager, PauseState pauseState) {
        this.stateControllerManager = stateControllerManager;
        this.pauseState = pauseState;
    }

    @Override
    public void update() {

    }

    @Override
    public void handleAction(UserActionEnum action) {
        switch(action) {
            case Pause:
                stateControllerManager.setState(stateControllerManager.getPreviousState());
                break;
            case Select:
    			stateControllerManager.setState(pauseState.getNextState());
    			pauseState.init();
    			break;
            case Up:
    			pauseState.previusOption();
    			break;
    		case Down:
    			pauseState.nextOption();
    			
        }
    }
}
