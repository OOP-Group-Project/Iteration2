package Main.Game.Controller.GameStates;

import Main.Game.Controller.Manager.GameStateManager;

public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm){
		this.gsm = gsm;
	}
	
	public abstract void update();
	public abstract void handleInput();
	
}
