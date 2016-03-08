package Main.Controller.GameStates;

import Main.Controller.Manager.GameStateManager;
import Main.Model.Map.Map;

import java.awt.event.KeyEvent;

public class PlayState extends State {

	public PlayState(GameStateManager gsm, Map world) {
		super(gsm, world);
	}

	@Override
	public void update(KeyEvent k) {
		if(k != null) {
			System.out.print(k.getKeyChar());
		}

	}
}
