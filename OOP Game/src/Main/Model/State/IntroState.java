package Main.Model.State;

import Main.Controller.Manager.StateControllerManager;
import Main.Model.Map.Map;

import java.awt.event.KeyEvent;

public class IntroState extends State {
	
	final String title = "The Unwanted";
	private Map world;
	
	//time to switch states
	private final long DURATION = 3000;
	
	private long start;
	
	
	public IntroState(Map world) {
		this.world = world;
	}


}
