package Main.Model.State;

import Main.Controller.Manager.StateControllerManager;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;

import java.awt.event.KeyEvent;

/**
 * Created by mason on 3/7/16.
 */
public class LoadState extends State {

    private Avatar player;
    private Map world;

    public LoadState(Map world, Avatar player) {
        this.player = player;
        this.world = world;
    }

    public void loadTestGame() {
        // create test map for now.
        world.createTestMap();
        world.addEntity(player, player.getLocation().x, player.getLocation().y, DirectionEnum.Down);

    }

    public Avatar getPlayer() {
        return player;
    }

}
