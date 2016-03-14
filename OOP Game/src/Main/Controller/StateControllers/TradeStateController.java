package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.PauseState;
import Main.Model.State.StateEnum;
import Main.Model.State.TradeState;

import java.awt.*;

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
            case Pause:
                tradeState.init();
                stateControllerManager.setState(StateEnum.PlayState);
                break;
            case Select:
                tradeState.init();
                stateControllerManager.setState(StateEnum.PlayState);
                break;
            case Up:
                tradeState.moveSelect(new Point(0,-1));
                break;
            case Down:
                tradeState.moveSelect(new Point(0,1));
                break;
        }
    }
}
