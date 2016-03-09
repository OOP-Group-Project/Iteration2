package Main.Game.Controller.GameStates;

import Main.Game.Controller.Manager.GameStateManager;

public class IntroState extends GameState{
	
	final String title = "The Unwanted";
	
	
	//time to switch states
	private final long DURATION = 3000;
	
	private long start;
	
	
	public IntroState(GameStateManager gsm) {
		super(gsm);
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
