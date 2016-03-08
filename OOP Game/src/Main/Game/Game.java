package Main.Game;

import Main.Game.Controller.Controller;
import Main.Game.Model.Entity.Avatar;
import Main.Game.Model.Map.Map;
import Main.Game.View.View;


/**
 * Created by mason on 3/6/16.
 */
public class Game implements Runnable {

    private View view;
    private Controller controller;
    private Map world;
    private Avatar player;

    private Thread thread;
    private boolean gameIsRunning;
    private final int FPS = 60;
    private final int targetTime = 1000 / FPS;

    public Game() {

        player = new Avatar();

        // Create the map first, we'll load everything into it later
        world = new Map();

        // Create all the controllers ( which contain the gameStates).
        controller = new Controller(world);

        // Create the view
        view = new View(world, controller, "The Unwanted..... Maybe");
    }

    // Run handles executing the render and update methods for everything at a precise rate of 60FPS
    @Override
    public void run() {
        long start;
        long elapsed;
        long wait;


        // IF the game isn't running yet, don't do anythign.
        while (gameIsRunning) {
            start = System.nanoTime();

            // Update and render
            controller.update();
            view.render();

            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            // Wait for 1/60 seconds to elapse and then repeat.
            if (wait > 0) {
                try {
                    Thread.sleep(wait);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public synchronized void startView() {
        view.start();
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
