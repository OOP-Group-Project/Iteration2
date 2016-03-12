package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.StartMenuState;

public class StartMenuStateController extends StateController{
	
	StateControllerManager stateControllerManager;
	StartMenuState startMenuState;
	
	public StartMenuStateController(StateControllerManager stateManager, StartMenuState startMenuState){
		this.stateControllerManager = stateManager;
		this.startMenuState = startMenuState;
		
		initState();
	}
	
	public void initState(){
		startMenuState.init();
	}
	
	@Override
	public void handleAction(UserActionEnum action) {
		
		switch(action){
		case Select:
			stateControllerManager.setState(startMenuState.getNextState());
			break;
		case Up:
			startMenuState.previusOption();
			break;
		case Down:
			startMenuState.nextOption();
		}
	}
	
	@Override
	public void update() {
		
	}
}
