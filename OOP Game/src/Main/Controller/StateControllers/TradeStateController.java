package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.StateEnum;
import Main.Model.State.TradeState;

import java.awt.*;

/**
 * Created by Peter Camejo on 3/14/2016.
 */
public class TradeStateController extends StateController {
    private StateControllerManager stateControllerManager;
    private TradeState tradeState;

    public TradeStateController(StateControllerManager stateControllerManager , TradeState tradeState){
        this.stateControllerManager = stateControllerManager;
        this.tradeState = tradeState;

    }

    public void init(){this.tradeState.init();}

    @Override
    public void handleAction(UserActionEnum action){
        switch(action){
            case Pause:
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
            case Left:
                tradeState.moveSelect(new Point(-1,0));
                break;
            case Right:
                tradeState.moveSelect(new Point(1,0));
                break;

        }

    }

    @Override
    public void update(){}
}
