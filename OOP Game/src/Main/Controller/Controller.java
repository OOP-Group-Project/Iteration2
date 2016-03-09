package Main.Controller;

import Main.Controller.GameStates.StateEnum;
import Main.Controller.Manager.GameStateManager;
import Main.Controller.Manager.KeyManager;
import Main.Model.Entity.*;
import Main.Model.Map.Map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by mason on 3/6/16. Altered by John Kaufmann 3/8/16.
 * TODO: Delete commented out code with permission of Mason.
 * TODO: find out if NPCs and Pets need a gamestate
 */
public class Controller /* implements Runnable */{  //(commented out by john kaufmann)

//    (commented out by john kaufmann)
//    private Thread thread;
//    private boolean gameIsRunning;
//    private final int FPS = 60;
//    private final int targetTime = 1000 / FPS;

    protected KeyManager keyboardManager;
    protected GameStateManager gameStateManager;
    protected Entity entity;


    // Initialize controllers based on need (JFK)
    public Controller(Map world, Avatar entity) {
        // Create all the controllers
        keyboardManager = new KeyManager();
        gameStateManager = new GameStateManager(world, entity);
        this.entity = entity;
    }

    // NPC's and Pet's and Mounts should not need a gamestate?? (JFK)
    public Controller(Map world, Npc entity) {
        // Create all the controllers
        keyboardManager = new KeyManager();
        this.entity = entity;
    }

    public Controller(Map world, Pet entity) {
        // Create all the controllers
        keyboardManager = new KeyManager();
        this.entity = entity;
    }

    public Controller(Map world, Mount entity) {
        // Create all the controllers
        keyboardManager = new KeyManager();
        this.entity = entity;
    }

    // get key listener to use (JFK)
    public KeyListener getKeyListener() {
        return keyboardManager;
    }

    // call this repeatedly given outside events it will control models if game is currently running (editted by john kaufmann)
    public void handleInput(KeyEvent k) {
        if (true) { //TODO: check controller should be updating
            gameStateManager.update(k);
            update(k);
        }
    }

    // called as a result of update. Takes in the key event and then handles the input and alters models (JFK)
    public void update(KeyEvent k) {
        return;
    }

    // gets the current gamestate from the gamestate manager
    public StateEnum getCurrentState() {
        return gameStateManager.getCurrentState();
    }

    protected boolean validateInput() {
        return false;
    }

    // Run handles executing the render and update methods for everything at a precise rate of 60FPS (commented out by john kaufmann)
//    public void run() {
//        int fps = 60;
//        double timePerTick = 1000000000 / fps;
//        double delta = 0;
//        long now;
//        long lastTime = System.nanoTime();
//        long timer = 0;
//        int ticks = 0;
//
//        while (gameIsRunning) {
//            now = System.nanoTime();
//            delta += (now - lastTime) / timePerTick;
//            timer += now - lastTime;
//            lastTime = now;
//
//            if( delta >= 1 ) {
//                //DO STUFF
//                update(keyboardManager.getKeyPressedState());
//
//                //
//                ticks++;
//                delta--;
//            }
//
//            if( timer >= 1000000000 ) {
////                System.out.println("Ticks and Frames: " + ticks);
//                ticks = 0;
//                timer = 0;
//            }
//        }
//        stop();
//    }

//    (commented out by john kaufmann
//    public synchronized void start() {
//        if (gameIsRunning) {
//            return;
//        }
//        gameIsRunning = true;
//        thread = new Thread(this);
//        thread.start();
//    }

//    (commented out by john kaufmann
//    public synchronized void stop() {
//        if( !gameIsRunning ) {
//            return;
//        }
//        gameIsRunning = false;
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
