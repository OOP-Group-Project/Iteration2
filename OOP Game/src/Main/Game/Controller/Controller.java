package Main.Game.Controller;

import Main.Game.Controller.GameStates.GameStateEnum;
import Main.Game.Controller.Manager.GameStateManager;
import Main.Game.Controller.Manager.KeyManager;
import Main.Game.Model.Map.Map;

import java.awt.event.KeyListener;

/**
 * Created by mason on 3/6/16.
 */
public class Controller {

    KeyManager keyboardManager;
    GameStateManager gameStateManager;

    public Controller(Map world) {
        // Create all the controllers
        keyboardManager = new KeyManager();
        gameStateManager = new GameStateManager(world);
    }

    public KeyListener getKeyListener() {
        return keyboardManager;
    }

    public void update() {
        gameStateManager.update();
    }

    public GameStateEnum getCurrentState() {
        return gameStateManager.getCurrentState();
    }

}
