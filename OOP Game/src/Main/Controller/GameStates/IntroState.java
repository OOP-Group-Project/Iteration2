package Main.Controller.GameStates;

import Main.Controller.Manager.GameStateManager;
import Main.Model.Map.Map;

public class IntroState extends State {
	
	final String title = "The Unwanted";
	
	
	//time to switch states
	private final long DURATION = 3000;
	
	private long start;
	
	
	public IntroState(GameStateManager gsm, Map world) {
		super(gsm, world);
	}


	@Override
	public void update() {
		handleInput();

	}


	@Override
	public void handleInput() {
//		if(KeyManager.isDown(KeyManager.ENTER))
//			gsm.setState(GameStateManager.START_MENU);
	}

}
