package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.AvatarCreationState;
import Main.Model.State.StateEnum;

/**
 * Created by jcvarela on 3/13/2016.
 */
public class AvatarCreationStateController extends StateController{

    private StateControllerManager stateControllerManager;
    private AvatarCreationState avatarCreationState;


    public AvatarCreationStateController(StateControllerManager stateManager, AvatarCreationState avatarCreationState) {
        stateControllerManager = stateManager;
        this.avatarCreationState = avatarCreationState;
    }

    @Override
    public void handleAction(UserActionEnum action) {
        switch(action) {
            case Pause:
                stateControllerManager.setState(StateEnum.StartMenuState);
                break;
            case Select:
                avatarCreationState.createAvatar();
                stateControllerManager.setState(StateEnum.LoadState);
                avatarCreationState.init();
                break;
            case Up:
                avatarCreationState.previusOption();
                break;
            case Down:
                avatarCreationState.nextOption();

        }
    }

    @Override
    public void update() {

    }
}
