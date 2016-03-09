package Main.Controller.StateControllers;

import Main.Model.State.State;
import Main.Model.State.StateEnum;

import java.awt.event.KeyEvent;

/**
 * Created by mason on 3/9/16.
 */
public abstract class StateController {

    public abstract void handleInput(KeyEvent key);

    public abstract void update();

}
