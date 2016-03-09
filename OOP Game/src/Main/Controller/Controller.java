package Main.Controller;

import Main.Controller.GameStates.StateEnum;
import Main.Controller.Manager.GameStateManager;
import Main.Controller.Manager.KeyManager;
import Main.Model.Map.Map;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by mason on 3/6/16.
 */
public class Controller implements Runnable{

    private Thread thread;
    private boolean gameIsRunning;
    private final int FPS = 60;
    private final int targetTime = 1000 / FPS;

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

    public void update(KeyEvent k) {
        gameStateManager.update(k);
    }

    public StateEnum getCurrentState() {
        return gameStateManager.getCurrentState();
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
                update(keyboardManager.getKeyPressedState());

                //
                ticks++;
                delta--;
            }

            if( timer >= 1000000000 ) {
//                System.out.println("Ticks and Frames: " + ticks);
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
