package Main.Game.Controller.Manager;


/*
 * This class manages instantiating the states and switching between them.
 */


import java.util.EnumMap;

import Main.Game.Controller.GameStates.*;
import Main.Game.Controller.GameStates.GameStateEnum;
import Main.Game.View.View;


public class GameStateManager {
	
	private EnumMap<GameStateEnum, GameState> gameStates;
	private GameStateEnum currentState;
	private GameStateEnum previousState;
	
	public GameStateManager(){

		//JukeBox.init(); // music

		gameStates = new EnumMap<GameStateEnum, GameState>(GameStateEnum.class);

		initializeStates();

		previousState = GameStateEnum.PlayState;
		setState(GameStateEnum.PlayState);
	}

	private void initializeStates() {
		gameStates.put(GameStateEnum.PlayState, new PlayState(this));
	}
	
	public void setState(GameStateEnum state){
//		View.removeKeyListener(state);
		currentState = (state);
//		View.addKeyListener(state);

	}

	public GameStateEnum getCurrentState() {
		return currentState;
	}
	
	public void update(){	
		gameStates.get(currentState).update();
	}

}
