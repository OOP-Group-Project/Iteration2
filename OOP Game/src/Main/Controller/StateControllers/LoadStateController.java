package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;
import Main.Model.Entity.Npc;
import Main.Model.Map.Map;
import Main.Model.State.LoadState;
import Main.Model.State.StateEnum;

import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mason on 3/9/16.
 */
public class LoadStateController extends StateController {

    private StateControllerManager stateManager;
    private LoadState loadState;
    private Map world;
    private ArrayList<Entity> nonPlayerEntities;
    private Avatar player;

    public LoadStateController(StateControllerManager stateManager, LoadState loadState, Avatar player, ArrayList<Entity> nonPlayerEntities, Map world) {
        this.stateManager = stateManager;
        this.loadState = loadState;
        this.world = world;
        this.player = player;
        this.nonPlayerEntities = nonPlayerEntities;
    }

    @Override
    public void handleAction(UserActionEnum action) {

    }

    @Override
    public void update() {
        world.addEntity(player, player.getLocation().x, player.getLocation().y);
        for(Entity e : nonPlayerEntities){
            world.addEntity(e,e.getLocation().x,e.getLocation().y);
        }
        stateManager.setState(StateEnum.PlayState);
    }
}
