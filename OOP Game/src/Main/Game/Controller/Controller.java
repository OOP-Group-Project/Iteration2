package Main.Game.Controller;

import Main.Game.Controller.GameStates.GameStateEnum;
import Main.Game.Controller.Manager.GameStateManager;
import Main.Game.Controller.Manager.KeyManager;

import java.awt.event.KeyListener;

/**
 * Created by mason on 3/6/16.
 */
public class Controller {

    KeyManager keyboardManager;
    GameStateManager gameStateManager;

    public Controller() {
        keyboardManager = new KeyManager();
        gameStateManager = new GameStateManager();
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
