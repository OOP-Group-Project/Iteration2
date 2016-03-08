package Main.Controller.GameStates;

import Main.Controller.Manager.GameStateManager;
import Main.Model.Map.Map;

public abstract class State {
	
	protected GameStateManager gsm;
	protected Map world;
	
	public State(GameStateManager gsm, Map world){
		this.gsm = gsm;
		this.world = world;
	}
	
	public abstract void update();
	public abstract void handleInput();
	
}
