package Main.Model.State;

import Main.Controller.Manager.StateControllerManager;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;
import Main.Model.Model;

import java.awt.event.KeyEvent;

/**
 * Created by mason on 3/7/16.
 */
public class LoadState extends State {

    Model model;

    public LoadState(Model model) {
        this.model = model;
    }

    public void loadTestGame() {
        // create test map for now.
        model.getWorld().createTestMap();
        model.getWorld().addEntity(model.getPlayer(), model.getPlayer().getLocation().x, model.getPlayer().getLocation().y);
    }

    public Avatar getPlayer() {
        return model.getPlayer();
    }

    public void loadNewGame() {
        // Look for the new game file

        // load it
       // model.load();
    }

    public void loadExistingGame() {

    }

}
