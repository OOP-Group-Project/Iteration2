package Main.Controller.GameStates;

import Main.Controller.Manager.GameStateManager;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;

import java.awt.event.KeyEvent;

/**
 * Created by mason on 3/7/16.
 */
public class LoadState extends State {

    private Avatar player;

    public LoadState(GameStateManager gsm, Map world, Avatar player) {
        super(gsm, world);
        this.player = player;
    }

    public void loadTestGame() {
        // create test map for now.
        world.createTestMap();


        world.addEntity(player, player.getLocation().x, player.getLocation().y, DirectionEnum.Down);

    }

    public Avatar getPlayer() {
        return player;
    }

    @Override
    public void update(KeyEvent k) {
        loadTestGame();
        gsm.setState(StateEnum.PlayState);
    }
}
