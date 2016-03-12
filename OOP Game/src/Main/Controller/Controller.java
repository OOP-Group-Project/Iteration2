package Main.Controller;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.ObjectControllers.EntityController.EntityController;
import Main.Controller.ObjectControllers.TimedObjectController;
import Main.Model.Model;
import Main.Model.State.StateEnum;
import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.KeyboardManager;

import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 * Created by mason on 3/6/16.
 */
public class Controller implements Runnable{

    private Thread thread;
    private boolean gameIsRunning;
    private EntityController[] NonPlayerEntities;

    KeyboardManager keyboardManager;
    StateControllerManager stateControllerManager;
    ObjectControllerManager objectControllerManager;

    public Controller(Model model) {
        // Create all the controllers

        stateControllerManager = new StateControllerManager(model);
        objectControllerManager = new ObjectControllerManager(model);
        keyboardManager = new KeyboardManager(stateControllerManager, stateControllerManager.getGameStateControllers());
        // AIManager = new AIManager()
        // Construct all the entity controllers
        // NPCController pncc = new NPCController(aim)

    }

    public KeyListener getKeyListener() {
        return keyboardManager;
    }

    public void update() {
        stateControllerManager.update();
    }

    public StateEnum getCurrentState() {
        return stateControllerManager.getCurrentState();
    }

    // Run handles executing the render and update methods for everything at a precise rate of 60FPS
    public void run() {
        while (gameIsRunning) {
            update();
        }
        stop();
    }

    public synchronized void start() {
        if (gameIsRunning) {
            return;
        }
        gameIsRunning = true;
        thread = new Thread(this);
        thread.start();
    }


    public synchronized void stop() {
        if( !gameIsRunning ) {
            return;
        }
        gameIsRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
