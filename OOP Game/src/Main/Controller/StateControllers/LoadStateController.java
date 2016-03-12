package Main.Controller.StateControllers;

import Main.Controller.EntityControllers.EntityController;
import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;
import Main.Model.State.LoadState;
import Main.Model.State.StateEnum;

import java.awt.event.KeyEvent;

/**
 * Created by mason on 3/9/16.
 */
public class LoadStateController extends StateController {

    private StateControllerManager stateManager;
    private LoadState loadState;
    private Map world;
    private Avatar player;

    public LoadStateController(StateControllerManager stateManager, LoadState loadState, Avatar player, Map world) {
        this.stateManager = stateManager;
        this.loadState = loadState;
        this.world = world;
        this.player = player;
    }

    @Override
    public void handleAction(UserActionEnum action) {

    }

    @Override
    public void update() {
        world.createTestMap();
        world.addEntity(player, player.getLocation().x, player.getLocation().y);
        stateManager.setState(StateEnum.PlayState);
    }
}
