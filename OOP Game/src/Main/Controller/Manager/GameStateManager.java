package Main.Controller.Manager;


/*
 * This class manages instantiating the states and switching between them.
 */


import java.util.EnumMap;

import Main.Controller.GameStates.State;
import Main.Controller.GameStates.StateEnum;
import Main.Controller.GameStates.LoadState;
import Main.Controller.GameStates.PlayState;
import Main.Model.Map.Map;


public class GameStateManager {
	
	private EnumMap<StateEnum, State> gameStates;
	private StateEnum currentState;
	private StateEnum previousState;

	public GameStateManager(Map world){
		// Create the map for The gamestate types to gamestate objects
		gameStates = new EnumMap<>(StateEnum.class);

		// create all the state objects
		initializeStates(world);

		// set our first state
		previousState = StateEnum.LoadState;
		setState(StateEnum.LoadState);
	}

	private void initializeStates(Map world) {
		gameStates.put(StateEnum.LoadState, new LoadState(this, world));
		gameStates.put(StateEnum.PlayState, new PlayState(this, world));
	}
	
	public void setState(StateEnum state){
		previousState = currentState;
		currentState = (state);
	}

	public StateEnum getCurrentState() {
		return currentState;
	}
	
	public void update(){	
		gameStates.get(currentState).update();
	}

}
