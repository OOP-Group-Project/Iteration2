package Main.Game.Controller.Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.KeyEvent;

//singleton 
public class KeyManager implements KeyListener{
	
	public final static int NUM_KEYS = 8;
	
	// key num and value
	public final static int UP = 0;
	public final static int RIGHT = 1;
	public final static int DOWN = 2;
	public final static int LEFT = 3;
	public final static int ENTER = 4;
	public final static int ESCAPE = 5;

	public static boolean keyState[] = new boolean[NUM_KEYS];
	public static boolean prevKeyState[] = new boolean[NUM_KEYS];


	// When we receive a key press event, we should parse what to do with the key and pass it off to the appropriate controller.
	@Override
	public void keyPressed(KeyEvent key) {

		// TODO: Make the keyEvent if statement below configurable.
		// (Probably use a EnumMap with the key as the key that's pressed and the
		// value as an ActionEnum for what action to take (i.e. pause, move up, move down, etc.)
		if(key.getKeyCode() == KeyEvent.VK_ESCAPE) {
			// if we press escape, what do we do ???


			// Tell the gamestate to switch to the pause state.

		}

		if(key.getKeyCode() == KeyEvent.VK_I) {
			// If we press "i", what now?


			//
		}


	}

	@Override
	public void keyReleased(KeyEvent key){

	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
