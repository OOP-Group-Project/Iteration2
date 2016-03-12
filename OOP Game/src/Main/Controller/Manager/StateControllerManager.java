package Main.Controller.Manager;


/*
 * This class manages instantiating the states and switching between them.
 */


import java.awt.event.KeyEvent;
import java.util.EnumMap;

import Main.Controller.StateControllers.LoadStateController;
import Main.Controller.StateControllers.PauseStateController;
import Main.Controller.StateControllers.PlayStateController;
import Main.Controller.StateControllers.StateController;
import Main.Model.State.*;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;


public class StateControllerManager {
	
	private EnumMap<StateEnum, StateController> gameStateControllers;
	private StateEnum currentState;
	private StateEnum previousState;

	public StateControllerManager( EnumMap<StateEnum, State> states, Map world, Avatar player){
		// Create the map for The gamestate types to gamestate objects
		gameStateControllers = new EnumMap<>(StateEnum.class);

		// create all the state objects
		initializeStates(states, world, player);

		// set our first state
		previousState = StateEnum.LoadState;
		setState(StateEnum.LoadState);
	}

	private void initializeStates(EnumMap<StateEnum, State> states, Map world, Avatar player) {
		gameStateControllers.put(StateEnum.LoadState, new LoadStateController(this, (LoadState)states.get(StateEnum.LoadState), player, world));
		gameStateControllers.put(StateEnum.PlayState, new PlayStateController(this, (PlayState)states.get(StateEnum.PlayState)));
		gameStateControllers.put(StateEnum.PauseState, new PauseStateController(this, (PauseState)states.get(StateEnum.PauseState)));
	}
	
	public void setState(StateEnum state){
		previousState = currentState;
		currentState = state;
	}

	public EnumMap<StateEnum, StateController> getGameStateControllers() {
		return gameStateControllers;
	}

	public StateEnum getCurrentState() {
		return currentState;
	}

	public StateEnum getPreviousState() {
		return previousState;
	}
	
	public void update(){
		gameStateControllers.get(currentState).update();
	}

}
