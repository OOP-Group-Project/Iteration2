package Main.Controller.Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

//singleton 
public class KeyManager implements KeyListener{
	private KeyEvent currentKeyState;
	private KeyEvent prevKeyState;
	private Stack<KeyEvent> keys = new Stack<>();


	// When we receive a key press event, we should parse what to do with the key and pass it off to the appropriate controller.
	@Override
	public void keyPressed(KeyEvent key) {
		if (key != null) {
			keys.push(key);
		}
//		currentKeyState = key;
//		System.out.print(currentKeyState);
	}

	@Override
	public void keyReleased(KeyEvent key){
		prevKeyState = key;
		currentKeyState = null;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

	public KeyEvent getKeyPressedState() {
		if (keys.isEmpty()) return null;
		return keys.peek();
	}

}
