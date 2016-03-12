package Main.Controller.Manager;

import Main.Controller.StateControllers.StateController;
import Main.Model.State.StateEnum;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EnumMap;
import java.util.HashMap;

//singleton 
public class KeyboardManager implements KeyListener{

	private EnumMap<StateEnum, StateController> stateControllers;
	private StateControllerManager stateControllerManager;
	private HashMap<Integer, UserActionEnum> keyboardActionMapping;



	public KeyboardManager(StateControllerManager stateControllerManager, EnumMap<StateEnum, StateController> stateControllers) {
		this.stateControllers = stateControllers;
		this.stateControllerManager = stateControllerManager;
		keyboardActionMapping = new HashMap<>();

		setDefaultKeyActions();
	}

	// When we receive a key press event, we should parse what to do with the key and pass it off to the appropriate controller.
	@Override
	public void keyPressed(KeyEvent key) {
		StateEnum currentState = stateControllerManager.getCurrentState();
		UserActionEnum action = keyboardActionMapping.get(key.getKeyCode());
		if(action != null) {
			stateControllers.get(currentState).handleAction(action);
		}

	}

	@Override
	public void keyReleased(KeyEvent key){

	}

	@Override
	public void keyTyped(KeyEvent arg0) {}


	public void setDefaultKeyActions() {
		keyboardActionMapping.clear();
		keyboardActionMapping.put(KeyEvent.VK_W, UserActionEnum.Up);
		keyboardActionMapping.put(KeyEvent.VK_Q, UserActionEnum.UpLeft);
		keyboardActionMapping.put(KeyEvent.VK_E, UserActionEnum.UpRight);
		keyboardActionMapping.put(KeyEvent.VK_A, UserActionEnum.Left);
		keyboardActionMapping.put(KeyEvent.VK_D, UserActionEnum.Right);
		keyboardActionMapping.put(KeyEvent.VK_X, UserActionEnum.Down);
		keyboardActionMapping.put(KeyEvent.VK_Z, UserActionEnum.DownLeft);
		keyboardActionMapping.put(KeyEvent.VK_C, UserActionEnum.DownRight);
		keyboardActionMapping.put(KeyEvent.VK_NUMPAD8, UserActionEnum.Up);
		keyboardActionMapping.put(KeyEvent.VK_NUMPAD7, UserActionEnum.UpLeft);
		keyboardActionMapping.put(KeyEvent.VK_NUMPAD9, UserActionEnum.UpRight);
		keyboardActionMapping.put(KeyEvent.VK_NUMPAD4, UserActionEnum.Left);
		keyboardActionMapping.put(KeyEvent.VK_NUMPAD6, UserActionEnum.Right);
		keyboardActionMapping.put(KeyEvent.VK_NUMPAD2, UserActionEnum.Down);
		keyboardActionMapping.put(KeyEvent.VK_NUMPAD1, UserActionEnum.DownLeft);
		keyboardActionMapping.put(KeyEvent.VK_NUMPAD3, UserActionEnum.DownRight);
		keyboardActionMapping.put(KeyEvent.VK_ESCAPE, UserActionEnum.Pause);
		keyboardActionMapping.put(KeyEvent.VK_T, UserActionEnum.ViewUp);
		keyboardActionMapping.put(KeyEvent.VK_R, UserActionEnum.ViewUpLeft);
		keyboardActionMapping.put(KeyEvent.VK_Y, UserActionEnum.ViewUpRight);
		keyboardActionMapping.put(KeyEvent.VK_G, UserActionEnum.ViewDown);
		keyboardActionMapping.put(KeyEvent.VK_F, UserActionEnum.ViewDownLeft);
		keyboardActionMapping.put(KeyEvent.VK_H, UserActionEnum.ViewDownRight);
		
		keyboardActionMapping.put(KeyEvent.VK_I, UserActionEnum.Select);
	}

}
