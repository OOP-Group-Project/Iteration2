package Main;

import Main.Controller.Controller;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;
import Main.View.Viewport;


/**
 * Created by mason on 3/6/16.
 */
public class Game {

    private Viewport viewport;
    private Controller controller;
    private Map world;
    private Avatar player;

    public Game() {

        // Create a dummy character first
        player = new Avatar();

        // Create the map first, we'll load everything into it later
        world = new Map(20, 20);

        // Create all the controllers ( which contain the gameStates).
        controller = new Controller(world);

        // Create the viewport to see into the world!
        viewport = new Viewport(player, world, controller, "Testing....");
    }


    public synchronized void start() {
        controller.start();
        viewport.start();
    }

}
