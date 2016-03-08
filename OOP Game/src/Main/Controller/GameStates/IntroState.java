package Main.Controller.GameStates;

import Main.Controller.Manager.GameStateManager;
import Main.Model.Map.Map;

import java.awt.event.KeyEvent;

public class IntroState extends State {
	
	final String title = "The Unwanted";
	
	
	//time to switch states
	private final long DURATION = 3000;
	
	private long start;
	
	
	public IntroState(GameStateManager gsm, Map world) {
		super(gsm, world);
	}


	@Override
	public void update(KeyEvent k) {


	}



}
