package Main;

import Main.Controller.Controller;
import Main.Controller.MovementController;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;
import Main.Model.Occupation.Occupation;
import Main.View.Viewport;
import Main.Controller.Manager.KeyManager;


/**
 * Created by mason on 3/6/16.
 */
public class Game implements Runnable{

    private Viewport viewport;
    private MovementController controller;
    private Map world;
    private Avatar player;
    private boolean gameIsRunning;
    private KeyManager keyboardManager;

    public Game() {
        keyboardManager = new KeyManager();

        // Create a dummy character first
//        player = new Avatar();

        // Create the map first, we'll load everything into it later
        world = new Map(7, 7);

        // Create all the controllers ( which contain the gameStates).
        controller = new MovementController(world, player);

        // Create the viewport to see into the world!
        viewport = new Viewport(player, world, controller, "Testing....");
        Viewport.viewport.addKeyListener(controller.getKeyListener());
    }


    public synchronized void init() {
        start();
        viewport.start();
    }

    //Run handles executing the render and update methods for everything at a precise rate of 60FPS (JFK)
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
                controller.update(keyboardManager.getKeyPressedState());

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

    //start
    public synchronized void start() {
        if (gameIsRunning) {
            return;
        }
        gameIsRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    (commented out by john kaufmann
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
