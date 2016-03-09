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
            if((e.getKeyCode() == KeyEvent.VK_NUMPAD8 || e.getKeyCode() == KeyEvent.VK_UP)){
                player.move(DirectionEnum.Up);
            }
            if((e.getKeyCode() == KeyEvent.VK_NUMPAD2 || e.getKeyCode() == KeyEvent.VK_DOWN)){
                player.move(DirectionEnum.Down);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD9){
                player.move(DirectionEnum.UpRight);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD3){
                player.move(DirectionEnum.DownRight);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD1){
                player.move(DirectionEnum.DownLeft);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD7){
                player.move(DirectionEnum.UpLeft);
            }
		}

	}
}
