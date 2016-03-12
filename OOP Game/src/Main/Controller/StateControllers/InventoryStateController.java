package Main.Controller.StateControllers;

import java.awt.Point;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Inventory.Inventory;
import Main.Model.Map.Map;
import Main.Model.State.InventoryState;
import Main.Model.State.LoadState;
import Main.Model.State.StateEnum;

public class InventoryStateController extends StateController{
	
	private StateControllerManager stateControllerManager;
	private InventoryState inventoryState;
	

	
	
	public InventoryStateController(StateControllerManager stateManager, InventoryState inventoryState) {
		stateControllerManager = stateManager;
		this.inventoryState = inventoryState;
	}

	@Override
	public void handleAction(UserActionEnum action) {
		
		switch(action){
			case Pause:
				inventoryState.init();
				stateControllerManager.setState(StateEnum.PlayState);
				break;
			case Select:
				inventoryState.init();
				stateControllerManager.setState(StateEnum.PlayState);
				break;
			case Up:
				inventoryState.moveSelect(new Point(0,-1));
				break;
			case Down:
				inventoryState.moveSelect(new Point(0,1));
				break;
			case Left:
				inventoryState.moveSelect(new Point(-1,0));
				break;
			case Right:
				inventoryState.moveSelect(new Point(1,0));
				break;
				
		}
	}

	@Override
	public void update() {

	}

}
