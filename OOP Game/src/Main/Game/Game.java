package Main.Game;

import Main.Game.Controller.Controller;
import Main.Game.View.View;


/**
 * Created by mason on 3/6/16.
 */
public class Game implements Runnable {

    private View view;
    private Controller controller;

    private Thread thread;
    private boolean gameIsRunning;
    private final int FPS = 30;
    private final int targetTime = 1000 / FPS;

    public Game() {
        controller = new Controller();
        view = new View(controller, "The Unwanted..... Maybe");
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
            System.out.println(Long.toString(wait));
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


    // Get the thread that we're running on going.
    public void init() {
        gameIsRunning = true;
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

}
