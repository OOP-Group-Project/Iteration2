package Controller.Manager;

import java.awt.Graphics2D;

import Controller.GameStates.*;



public class GameStateManager {
	
	public final static int NUM_STATES = 2;
	
	public final static int INTRO = 0;
	public final static int START_MENU = 1;
	
	private GameState[] gameStates;
	private int currentState;
	
	public GameStateManager(){
		
		//JukeBox.init(); // music
		
		gameStates = new GameState[NUM_STATES];
		setState(INTRO);
	}
	
	public void setState(int i){
		
		currentState = i;
		
		switch(i){
		
		case INTRO: 			gameStates[i] = new IntroState(this); break;
		case START_MENU:		gameStates[i] = new StartMenuState(this); break;
		
		}
		
		gameStates[i].init();
	}
	
	public void update(){	
		if(gameStates[currentState] != null)
			gameStates[currentState].update();
		
	}
	
	public void render(Graphics2D g){
		if(gameStates[currentState] != null)
			gameStates[currentState].render(g);
	}
}
