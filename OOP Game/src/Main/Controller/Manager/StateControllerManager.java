package Main.Controller.Manager;


/*
 * This class manages instantiating the states and switching between them.
 */


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EnumMap;

import Main.Controller.StateControllers.*;
import Main.Model.Entity.Entity;
import Main.Model.Model;
import Main.Model.State.*;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;


public class StateControllerManager {
	
	private EnumMap<StateEnum, StateController> gameStateControllers;
	private StateEnum currentState;
	private StateEnum previousState;

	public StateControllerManager(ObjectControllerManager objectControllerManager, Model model){
		// Create the map for The gamestate types to gamestate objects
		gameStateControllers = new EnumMap<>(StateEnum.class);

		// create all the state objects
		gameStateControllers.put(StateEnum.LoadState, new LoadStateController(this, objectControllerManager, (LoadState)model.getStates().get(StateEnum.LoadState), model));
		gameStateControllers.put(StateEnum.PlayState, new PlayStateController(this, objectControllerManager, (PlayState)model.getStates().get(StateEnum.PlayState)));
		gameStateControllers.put(StateEnum.PauseState, new PauseStateController(this, (PauseState)model.getStates().get(StateEnum.PauseState)));
		gameStateControllers.put(StateEnum.InventoryState,new InventoryStateController(this, (InventoryState)model.getStates().get(StateEnum.InventoryState)));
		gameStateControllers.put(StateEnum.StartMenuState, new StartMenuStateController(this,(StartMenuState)model.getStates().get(StateEnum.StartMenuState)));
		gameStateControllers.put(StateEnum.TalkState, new TalkStateController(this, (TalkState)model.getStates().get(StateEnum.TalkState)));
		gameStateControllers.put(StateEnum.StatState, new StatStateController(this,(StatState)model.getStates().get(StateEnum.StatState)));

		// set our first state
		previousState = StateEnum.StartMenuState;
		setState(StateEnum.StartMenuState);
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
