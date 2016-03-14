package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.KeyBindingsState;
import Main.Model.State.StartMenuState;
import Main.Model.State.StateEnum;

public class KeyBindingsStateController extends StateController{

    StateControllerManager stateControllerManager;
    KeyBindingsState keyBindingsState;

    public KeyBindingsStateController(StateControllerManager stateManager, KeyBindingsState keyBindingsState){
        this.stateControllerManager = stateManager;
        this.keyBindingsState = keyBindingsState;

    }

    @Override
    public void handleAction(UserActionEnum action) {

        switch (action) {
            case Select:
                keyBindingsState.select();
                break;
            case Up:
                keyBindingsState.previusOption();
                break;
            case Down:
                keyBindingsState.nextOption();
                break;
            case Control:
                stateControllerManager.setState(StateEnum.PlayState);
        }
    }

    @Override
    public void update() {

    }
}
