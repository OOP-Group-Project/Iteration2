package Main.Controller.Manager;


/*
 * This class manages instantiating the states and switching between them.
 */


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EnumMap;

import Main.Controller.GameStates.State;
import Main.Controller.GameStates.StateEnum;
import Main.Controller.GameStates.LoadState;
import Main.Controller.GameStates.PlayState;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;


public class GameStateManager {
	
	private EnumMap<StateEnum, State> gameStates;
	private StateEnum currentState;
	private StateEnum previousState;

	public GameStateManager(Map world, Avatar player){
		// Create the map for The gamestate types to gamestate objects
		gameStates = new EnumMap<>(StateEnum.class);

		// create all the state objects
		initializeStates(world, player);

		// set our first state
		previousState = StateEnum.LoadState;
		setState(StateEnum.LoadState);
	}

	private void initializeStates(Map world, Avatar player) {
		gameStates.put(StateEnum.LoadState, new LoadState(this, world, player));
		gameStates.put(StateEnum.PlayState, new PlayState(this, world, player));
	}
	
	public void setState(StateEnum state){
		previousState = currentState;
		currentState = state;
	}

	public StateEnum getCurrentState() {
		return currentState;
	}
	
	public void update(KeyEvent k){
		gameStates.get(currentState).update(k);
	}

}