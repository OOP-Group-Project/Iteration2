package Main.Controller.Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//singleton 
public class KeyManager implements KeyListener{
	private KeyEvent currentKeyState;
	private KeyEvent prevKeyState;


	// When we receive a key press event, we should parse what to do with the key and pass it off to the appropriate controller.
	@Override
	public void keyPressed(KeyEvent key) {
		currentKeyState = key;
	}

	@Override
	public void keyReleased(KeyEvent key){
		prevKeyState = key;
		currentKeyState = null;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

	public KeyEvent getKeyPressedState() {
		return currentKeyState;
	}

}
