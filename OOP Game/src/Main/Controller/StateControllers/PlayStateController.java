package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.State.PlayState;
import Main.Model.State.State;

import java.awt.event.KeyEvent;

/**
 * Created by mason on 3/9/16.
 */
public class PlayStateController extends StateController {

    private StateControllerManager stateControllerManager;
    private PlayState playState;

    public PlayStateController(StateControllerManager stateControllerManager, PlayState playState) {
        this.stateControllerManager = stateControllerManager;
        this.playState = playState;
    }

    @Override
    public void update() {

    }

    @Override
    public void handleInput(KeyEvent e) {
        if(e != null) {
            if((e.getKeyCode() == KeyEvent.VK_NUMPAD8 || e.getKeyCode() == KeyEvent.VK_W)){
                playState.getPlayer().move(DirectionEnum.Up);
            }
            if((e.getKeyCode() == KeyEvent.VK_NUMPAD2 || e.getKeyCode() == KeyEvent.VK_S)){
                playState.getPlayer().move(DirectionEnum.Down);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD9 || e.getKeyCode() == KeyEvent.VK_E){
                playState.getPlayer().move(DirectionEnum.UpRight);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD3 || e.getKeyCode() == KeyEvent.VK_D){
                playState.getPlayer().move(DirectionEnum.DownRight);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD1 || e.getKeyCode() == KeyEvent.VK_A){
                playState.getPlayer().move(DirectionEnum.DownLeft);
            }
            if(e.getKeyCode() == KeyEvent.VK_NUMPAD7 || e.getKeyCode() == KeyEvent.VK_Q){
                playState.getPlayer().move(DirectionEnum.UpLeft);
            }
        }
    }
}

