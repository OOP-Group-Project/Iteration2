package Main.Controller.StateControllers;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.MapController;
import Main.Model.DirectionEnum;
import Main.Model.State.ObservationState;
import Main.Model.State.StateEnum;

/**
 * Created by mason on 3/13/16.
 */
public class ObservationStateController extends StateController {

    private StateControllerManager stateControllerManager;
    private ObjectControllerManager objectControllerManager;
    private ObservationState observationState;

    public ObservationStateController(StateControllerManager stateControllerManager, ObjectControllerManager objectControllerManager, ObservationState observationState) {
        this.stateControllerManager = stateControllerManager;
        this.objectControllerManager = objectControllerManager;
        this.observationState = observationState;
    }

    @Override
    public void handleAction(UserActionEnum action) {
        switch(action) {
            case Up:
            case UpRight:
            case UpLeft:
            case Down:
            case DownLeft:
            case DownRight:
                stateControllerManager.setState(StateEnum.PlayState);
                break;
            case Pause:
                stateControllerManager.setState(StateEnum.PauseState);
                break;
            case ViewUp:
                observationState.moveCenterPoint(DirectionEnum.Up);
                break;
            case ViewUpLeft:
                observationState.moveCenterPoint(DirectionEnum.UpLeft);
                break;
            case ViewUpRight:
                observationState.moveCenterPoint(DirectionEnum.UpRight);
                break;
            case ViewDown:
                observationState.moveCenterPoint(DirectionEnum.Down);
                break;
            case ViewDownLeft:
                observationState.moveCenterPoint(DirectionEnum.DownLeft);
                break;
            case ViewDownRight:
                observationState.moveCenterPoint(DirectionEnum.DownRight);
                break;
        }
    }

    @Override
    public void update() {
        ((MapController)objectControllerManager.getObjectController(observationState.getWorld())).update();
    }


}
