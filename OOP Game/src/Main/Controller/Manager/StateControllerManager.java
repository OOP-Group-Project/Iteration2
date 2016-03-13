package Main.Controller.Manager;


/*
 * This class manages instantiating the states and switching between them.
 */


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EnumMap;

import Main.Controller.StateControllers.InventoryStateController;
import Main.Controller.StateControllers.LoadStateController;
import Main.Controller.StateControllers.PauseStateController;
import Main.Controller.StateControllers.PlayStateController;
import Main.Controller.StateControllers.StartMenuStateController;
import Main.Controller.StateControllers.StateController;
import Main.Model.Entity.Entity;
import Main.Model.Model;
import Main.Model.State.*;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;


public class StateControllerManager {
	
	private EnumMap<StateEnum, StateController> gameStateControllers;
	private StateEnum currentState;
	private StateEnum previousState;

	public StateControllerManager(Model model){
		// Create the map for The gamestate types to gamestate objects
		gameStateControllers = new EnumMap<>(StateEnum.class);

		// create all the state objects
		initializeStates(model.getStates(), model.getWorld(), model.getPlayer(), model.getNonPlayerEntities());

		// set our first state
		previousState = StateEnum.StartMenuState;
		setState(StateEnum.StartMenuState);
	}

	private void initializeStates(EnumMap<StateEnum, State> states, Map world, Avatar player, ArrayList<Entity> nonPlayerEntities) {
		gameStateControllers.put(StateEnum.LoadState, new LoadStateController(this, (LoadState)states.get(StateEnum.LoadState), player,nonPlayerEntities, world));
		gameStateControllers.put(StateEnum.PlayState, new PlayStateController(this, (PlayState)states.get(StateEnum.PlayState)));
		gameStateControllers.put(StateEnum.PauseState, new PauseStateController(this, (PauseState)states.get(StateEnum.PauseState)));
		
		//guessing
		gameStateControllers.put(StateEnum.InventoryState,new InventoryStateController(this, (InventoryState)states.get(StateEnum.InventoryState)));
		gameStateControllers.put(StateEnum.StartMenuState, new StartMenuStateController(this,(StartMenuState)states.get(StateEnum.StartMenuState)));
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
