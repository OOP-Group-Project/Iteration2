package Main;

import Main.Controller.Controller;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;
import Main.Model.Model;
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

    public Game() {
        /********************
         * Create the Model
         ********************/
        Model model = new Model();

        /*************************
         * Create the Controller (and all associated controllers)
         *************************/
        controller = new Controller(model);

        /************************
         * Create the View
         ************************/
        viewport = new Viewport(model, controller, "....The New World....");

    }

    public synchronized void start() {
        controller.start();
        viewport.start();
    }

}
