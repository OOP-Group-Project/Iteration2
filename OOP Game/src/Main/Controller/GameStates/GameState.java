package Main.Controller.GameStates;

import java.awt.Graphics;

import Main.Controller.Manager.GameStateManager;

public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm){
		this.gsm = gsm;
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void render(Graphics g);
	public abstract void handleInput();
	
}
