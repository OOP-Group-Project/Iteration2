package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.StatState;
import Main.Model.State.StateEnum;

public class StatStateController extends StateController {

    private StateControllerManager stateControllerManager;
    private StatState statState;

    public StatStateController(StateControllerManager stateManager, StatState statState) {
        stateControllerManager = stateManager;
        this.statState = statState;
    }

    @Override
    public void handleAction(UserActionEnum action) {

        switch(action){
            case Shift:
                stateControllerManager.setState(StateEnum.PlayState);
                break;
        }
    }

    @Override
    public void update() {

    }

}
