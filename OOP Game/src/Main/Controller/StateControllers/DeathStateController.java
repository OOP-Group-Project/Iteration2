package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.DeathState;
import Main.Model.State.PauseState;

/**
 * Created by mason on 3/10/16.
 */
public class DeathStateController extends StateController {

    private StateControllerManager stateControllerManager;
    private DeathState deathState;

    public DeathStateController(StateControllerManager stateControllerManager, DeathState deathState) {
        this.stateControllerManager = stateControllerManager;
        this.deathState = deathState;
    }

    @Override
    public void update() {

    }

    @Override
    public void handleAction(UserActionEnum action) {
        switch(action) {
            case Select:
                stateControllerManager.setState(deathState.getNextState());
                deathState.init();
                break;
            case Up:
                deathState.previusOption();
                break;
            case Down:
                deathState.nextOption();

        }
    }
}
