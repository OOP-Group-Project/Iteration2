package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.InventoryState;
import Main.Model.State.State;
import Main.Model.State.StateEnum;
import Main.Model.State.TalkState;

import java.awt.event.KeyEvent;

/**
 * Created by walkhard on 3/12/2016.
 * Edited by Peter Camejo 3/12/2016.
 */
public class TalkStateController extends StateController {
    private StateControllerManager stateControllerManager;
    private TalkState talkState;

    public TalkStateController(StateControllerManager stateManager, TalkState talkState) {
        this.stateControllerManager = stateManager;
        this.talkState = talkState;
    }

    public void initState(){ talkState.init();}

    @Override
    public void handleAction(UserActionEnum action){
        switch(action){
            case Select:
                stateControllerManager.setState(talkState.getNextState());
                break;
            case Up:
                talkState.previousOption();
                break;
            case Down:
                talkState.nextOption();

        }
    }

    @Override
    public void update(){}
}
