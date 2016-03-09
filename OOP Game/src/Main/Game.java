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
        player = new Avatar(4,4);

        // Create the map first, we'll load everything into it later
        world = new Map(7, 7);

        // Create all the controllers ( which contain the gameStates).
        controller = new Controller(world, player);

        // Create the viewport to see into the world!
        viewport = new Viewport(player, world, controller, "Testing....");
        Viewport.viewport.addKeyListener(controller.getKeyListener());
    }


    public synchronized void start() {
        controller.start();
        viewport.start();
    }

}
