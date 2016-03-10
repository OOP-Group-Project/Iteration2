package Main.Controller.Manager;

import Main.Controller.StateControllers.StateController;
import Main.Model.State.StateEnum;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EnumMap;

//singleton 
public class KeyManager implements KeyListener{

	private EnumMap<StateEnum, StateController> stateControllers;
	private StateControllerManager stateControllerManager;

	public KeyManager(StateControllerManager stateControllerManager, EnumMap<StateEnum, StateController> stateControllers) {
		this.stateControllers = stateControllers;
		this.stateControllerManager = stateControllerManager;
	}

	// When we receive a key press event, we should parse what to do with the key and pass it off to the appropriate controller.
	@Override
	public void keyPressed(KeyEvent key) {
		StateEnum currentState = stateControllerManager.getCurrentState();
		stateControllers.get(currentState).handleInput(key);
	}

	@Override
	public void keyReleased(KeyEvent key){

	}

	@Override
	public void keyTyped(KeyEvent arg0) {}




}
