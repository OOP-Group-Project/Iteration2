package Main.Controller.Manager;

import Main.Controller.StateControllers.StateController;
import Main.Model.State.StateEnum;

import javax.swing.*;
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
		keyboardActionMapping.put(KeyEvent.VK_S, UserActionEnum.Interact);
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
		keyboardActionMapping.put(KeyEvent.VK_1, UserActionEnum.Attack);


		keyboardActionMapping.put(KeyEvent.VK_ENTER, UserActionEnum.Select);
		keyboardActionMapping.put(KeyEvent.VK_K, UserActionEnum.Interact);
		keyboardActionMapping.put(KeyEvent.VK_NUMPAD5, UserActionEnum.Select);
		keyboardActionMapping.put(KeyEvent.VK_SHIFT, UserActionEnum.Shift);
		keyboardActionMapping.put(KeyEvent.VK_CONTROL, UserActionEnum.Control);
		keyboardActionMapping.put(KeyEvent.VK_ENTER, UserActionEnum.Select);


		//all other keys set to none for key binding menu
		keyboardActionMapping.put(KeyEvent.VK_I, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_J, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_K, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_L, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_M, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_N, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_O, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_P, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_T, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_U, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_V, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_2, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_3, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_4, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_5, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_6, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_7, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_8, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_9, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_0, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_SPACE, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_ALT, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_ASTERISK, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_ADD, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_BACK_SLASH, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_CLOSE_BRACKET, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_COMMA, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_DECIMAL, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_DELETE, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_DIVIDE, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_EQUALS, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F1, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F2, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F3, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F4, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F5, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F6, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F7, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F8, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F9, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F10, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F11, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_F12, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_HOME, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_UP, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_TAB, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_SUBTRACT, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_SLASH, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_SEMICOLON, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_PLUS, UserActionEnum.None);
		keyboardActionMapping.put(KeyEvent.VK_OPEN_BRACKET, UserActionEnum.None);
	}

	public void removeKeyAction(KeyEvent key) {
		if (keyboardActionMapping.get(key) != null) {
			keyboardActionMapping.remove(key);
		}
	}

	public void addKeyAction(KeyEvent key, UserActionEnum action) {
		if (keyboardActionMapping.get(key) != null) {
			keyboardActionMapping.remove(key);
		}
		keyboardActionMapping.put(key.getKeyCode(), action);
	}

	public void addKeyAction(int key, UserActionEnum action) {
		if (keyboardActionMapping.get(key) != null) {
			keyboardActionMapping.remove(key);
		}
		keyboardActionMapping.put(key, action);
	}

	public void removeKeyAction(int key) {
		if (keyboardActionMapping.get(key) != null) {
			keyboardActionMapping.remove(key);
		}
	}



	public HashMap<Integer, UserActionEnum> getKeyboardActionMapping() {
		return keyboardActionMapping;
	}

}
