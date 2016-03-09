package Main.Controller.GameStates;

import Main.Controller.Manager.GameStateManager;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;

import java.awt.event.KeyEvent;

public class PlayState extends State {

    private Avatar player;

	public PlayState(GameStateManager gsm, Map world, Avatar entity) {
		super(gsm, world);
        player = entity;
	}

	@Override
	public void update(KeyEvent e) {
		if(e != null) {
            if((e.getKeyCode() == KeyEvent.VK_NUMPAD8 || e.getKeyCode() == KeyEvent.VK_W)){
                player.move(DirectionEnum.Up);
            }
            if((e.getKeyCode() == KeyEvent.VK_NUMPAD2 || e.getKeyCode() == KeyEvent.VK_S)){
                player.move(DirectionEnum.Down);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD9 || e.getKeyCode() == KeyEvent.VK_E){
                player.move(DirectionEnum.UpRight);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD3 || e.getKeyCode() == KeyEvent.VK_D){
                player.move(DirectionEnum.DownRight);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD1 || e.getKeyCode() == KeyEvent.VK_A){
                player.move(DirectionEnum.DownLeft);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD7 || e.getKeyCode() == KeyEvent.VK_Q){
                player.move(DirectionEnum.UpLeft);

            }
		}

	}
}
