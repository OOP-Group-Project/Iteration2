package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.InventoryState;
import Main.Model.State.State;
import Main.Model.State.StateEnum;
import Main.Model.State.TalkState;

import java.awt.event.KeyEvent;

/**
 * Created by Walkhard on 3/12/2016.
 */
public class TalkStateController extends StateController {
    //
    public TalkStateController(StateControllerManager stateManager, TalkState talkState) {
        stateControllerManager = stateManager;
        this.talk_state = talkState;
    }
    //
    private StateControllerManager stateControllerManager;
    private TalkState talk_state;
    //
    @Override
    public void handleAction(UserActionEnum action){}
    //
    @Override
    public void update(){}
}
