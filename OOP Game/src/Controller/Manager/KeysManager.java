package Controller.Manager;

import java.awt.event.KeyEvent;

//singleton 
public class KeysManager {
	
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
	
	
	public  static void update(){
		for (int i = 0; i < NUM_KEYS; i++) {
			prevKeyState[i] = keyState[i];
		}
	}
	
	public static void setKey(int key, boolean b){
		switch(key){
		
		case KeyEvent.VK_UP: 		keyState[UP] = b; 	break;
		case KeyEvent.VK_RIGHT: 	keyState[RIGHT] = b; break;
		case KeyEvent.VK_DOWN: 		keyState[DOWN] = b; break;
		case KeyEvent.VK_LEFT: 		keyState[LEFT] = b; break;
		case KeyEvent.VK_ENTER: 	keyState[ENTER] = b; break;
		case KeyEvent.VK_ESCAPE: 	keyState[ESCAPE] = b; break;
		
		}
	}
	
	public static boolean isPressed(int i) {
		return keyState[i] && !prevKeyState[i];
	}
	
	public static boolean isDown(int i) {
		return keyState[i];
	}
}
