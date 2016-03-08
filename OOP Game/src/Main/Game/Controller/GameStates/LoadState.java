package Main.Game.Controller.GameStates;

import Main.Game.Controller.Manager.GameStateManager;
import Main.Game.Model.DirectionEnum;
import Main.Game.Model.Entity.Avatar;
import Main.Game.Model.Map.Map;

/**
 * Created by mason on 3/7/16.
 */
public class LoadState extends GameState {

    private Avatar player;

    public LoadState(GameStateManager gsm, Map world) {
        super(gsm, world);
    }

    public void loadTestGame() {
        // create test map for now.
        world.createTestMap();

        player = new Avatar(0,0);
        world.addEntity(player, 0,0, DirectionEnum.Down);
    }

    @Override
    public void handleInput() {

    }

    public Avatar getPlayer() {
        return player;
    }

    @Override
    public void update() {
        gsm.setState(GameStateEnum.PlayState);
    }
}
