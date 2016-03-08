package Main.Game.Controller.Manager;


/*
 * This class manages instantiating the states and switching between them.
 */


import java.util.EnumMap;

import Main.Game.Controller.GameStates.*;
import Main.Game.Controller.GameStates.GameStateEnum;
import Main.Game.Model.Map.Map;


public class GameStateManager {
	
	private EnumMap<GameStateEnum, GameState> gameStates;
	private GameStateEnum currentState;
	private GameStateEnum previousState;

	public GameStateManager(Map world){
		// Create the map for The gamestate types to gamestate objects
		gameStates = new EnumMap<>(GameStateEnum.class);

		// create all the state objects
		initializeStates(world);

		// set our first state
		previousState = GameStateEnum.LoadState;
		setState(GameStateEnum.LoadState);
	}

	private void initializeStates(Map world) {
		gameStates.put(GameStateEnum.LoadState, new LoadState(this, world));
		gameStates.put(GameStateEnum.PlayState, new PlayState(this, world));
	}
	
	public void setState(GameStateEnum state){
		previousState= currentState;
		currentState = (state);
	}

	public GameStateEnum getCurrentState() {
		return currentState;
	}
	
	public void update(){	
		gameStates.get(currentState).update();
	}

}
