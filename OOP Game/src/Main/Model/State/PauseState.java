package Main.Model.State;

import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;
import Main.Model.io.AreaEffectsIO;

/**
 * Created by mason on 3/10/16.
 */
public class PauseState extends State {
	
	public enum PauseOption{
		Resume("Resume"){

			@Override
			protected StateEnum activate() {
				return StateEnum.PlayState;
			}
			
		},
		KeyBinding("Key Binding"){
			protected StateEnum activate(){
				return StateEnum.KeyBindingsState;
			}
		}
		,MainMenu("Main Menu") {
			@Override
			protected StateEnum activate() {
				return StateEnum.StartMenuState;
			}
		};
		
		private String name;
		private PauseOption(String name){
			this.name = name;
		}
		public String getName(){
			return name;
		}
		protected abstract StateEnum activate();
		
		protected PauseOption previous(){
			if(this.ordinal() == 0){
				return PauseOption.values()[PauseOption.values().length - 1];
			} 
			else {
				return PauseOption.values()[this.ordinal() - 1];
			}
		}
		
		protected PauseOption next(){
			if(this.ordinal() == PauseOption.values().length -1){
				return PauseOption.values()[0];
			}
			else {
				return PauseOption.values()[this.ordinal() + 1];
			}
		}
	}
	//end of enum--------------------------- 
	
	
	private PauseOption selected;
	
    public PauseState() {
    	init();

    }
    
    public void init(){
    	selected = PauseOption.values()[0];
    }
    
    public void previusOption(){
		selected = selected.previous();
	}
	public void nextOption(){
		selected = selected.next();
	}
	
	public StateEnum getNextState(){
		return selected.activate();
	}
	public String getStringSelected(){
		return selected.getName();
	}
}
