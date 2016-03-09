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

    public LoadState(GameStateManager gsm, Map world) {
        super(gsm, world);
    }

    public void loadTestGame() {
        // create test map for now.
        world.createTestMap();


        world.addEntity(player, 0,0, DirectionEnum.Down);
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
