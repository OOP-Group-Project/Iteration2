package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.PauseState;
import Main.Model.State.TradeState;

/**
 * Created by Michael on 3/14/16.
 */
public class TradeStateController extends StateController {

    private StateControllerManager stateControllerManager;
    private TradeState tradeState;

    public TradeStateController(StateControllerManager stateControllerManager, TradeState tradeState){
        this.stateControllerManager = stateControllerManager;
        this.tradeState = tradeState;
    }

    @Override
    public void update() {

    }

    @Override
    public void handleAction(UserActionEnum action) {
        switch (action){
            case Select:
                stateControllerManager.setState(tradeState.getNextState());
                tradeState.init();
                break;
            case Up:
                tradeState.previousOption();
                break;
            case Down:
                tradeState.nextOption();
        }
    }
}
