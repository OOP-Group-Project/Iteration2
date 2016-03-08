package Main.Game.Controller.GameStates;

import Main.Game.Controller.Manager.GameStateManager;
import Main.Game.Model.Map.Map;

public abstract class GameState {
	
	protected GameStateManager gsm;
	protected Map world;
	
	public GameState(GameStateManager gsm, Map world){
		this.gsm = gsm;
		this.world = world;
	}
	
	public abstract void update();
	public abstract void handleInput();
	
}
