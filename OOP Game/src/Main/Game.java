package Main;

import Main.Controller.Controller;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;
import Main.Model.State.LoadState;
import Main.Model.State.PlayState;
import Main.Model.State.State;
import Main.Model.State.StateEnum;
import Main.View.Viewport;

import java.util.EnumMap;


/**
 * Created by mason on 3/6/16.
 */
public class Game {

    private Viewport viewport;
    private Controller controller;
    private Map world;
    private Avatar player;
    private EnumMap<StateEnum, State> states;

    public Game() {

        // Create a dummy character first
        player = new Avatar(0,0);

        // Create the map first, we'll load everything into it later
        world = new Map(100, 100);

        // Create all the states
        states = new EnumMap<>(StateEnum.class);
        states.put(StateEnum.LoadState, new LoadState(world, player));
        states.put(StateEnum.PlayState, new PlayState(world, player));

        // Create all the controllers ( which contain the gameStates).
        controller = new Controller(states, world, player);

        // Create the viewport to see into the world!
        viewport = new Viewport(player, world, controller, "Testing....");
        Viewport.viewport.addKeyListener(controller.getKeyListener());
        viewport.setFocusable(true);
    }

    public synchronized void start() {
        controller.start();
        viewport.start();
    }

}
