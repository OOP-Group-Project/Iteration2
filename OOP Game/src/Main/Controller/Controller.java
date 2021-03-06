package Main.Controller;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.EntityController.EntityController;
import Main.Controller.ObjectControllers.TimedObjectController;
import Main.Model.Model;
import Main.Model.State.StateEnum;
import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.KeyboardManager;
import Main.Model.io.KeyBindingsIO;

import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 * Created by mason on 3/6/16.
 */
public class Controller implements Runnable{

    private Thread thread;
    private boolean gameIsRunning;

    KeyboardManager keyboardManager;
    StateControllerManager stateControllerManager;
    ObjectControllerManager objectControllerManager;

    public Controller(Model model) {
        // Create all the controllers
        objectControllerManager = new ObjectControllerManager(model);
        stateControllerManager = new StateControllerManager(objectControllerManager, model);
        KeyBindingsIO io = new KeyBindingsIO();
        keyboardManager = new KeyboardManager(stateControllerManager, stateControllerManager.getGameStateControllers() /*, io.load()*/);
        // AIManager = new AIManager()
        // Construct all the entity controllers
        // NPCController pncc = new NPCController(aim)

    }

    public KeyListener getKeyListener() {
        return keyboardManager;
    }

    public KeyboardManager getKeyManager() { return keyboardManager;}

    public void setKeyManager(HashMap<Integer, UserActionEnum> keyboardActionMapping) {
        keyboardManager.setKeyboardActionMapping(keyboardActionMapping);
    }

    public void update() {
        stateControllerManager.update();
    }

    public StateEnum getCurrentState() {
        return stateControllerManager.getCurrentState();
    }

    // Run handles executing the render and update methods for everything at a precise rate of 60FPS
    public void run() {


        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (gameIsRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if( delta >= 1 ) {
                //DO STUFF
                update();

                //
                ticks++;
                delta--;
            }

            if( timer >= 1000000000 ) {
                //System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
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
