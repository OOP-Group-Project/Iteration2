package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.KeyBindingsState;
import Main.Model.State.StartMenuState;
import Main.Model.State.StateEnum;
import Main.Model.io.KeyBindingsIO;

import java.util.HashMap;

public class KeyBindingsStateController extends StateController{

    StateControllerManager stateControllerManager;
    KeyBindingsState keyBindingsState;
    private boolean firstLoad;


    public KeyBindingsStateController(StateControllerManager stateManager, KeyBindingsState keyBindingsState){
        this.stateControllerManager = stateManager;
        this.keyBindingsState = keyBindingsState;
        firstLoad = true;
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
                save();
                stateControllerManager.setState(StateEnum.PlayState);
        }
    }

    public void save(){
        KeyBindingsIO io = new KeyBindingsIO();
        io.setArrayLists(keyBindingsState.getKeyboardActionMapping());
        io.save();
    }

    @Override
    public void update() {

    }
}
