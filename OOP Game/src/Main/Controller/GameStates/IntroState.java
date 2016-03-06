package Main.Controller.GameStates;

import java.awt.Color;
import java.awt.Graphics;

import Main.Controller.Manager.GameStateManager;
import Main.Controller.Manager.KeysManager;
import Main.View.GamePanel;

public class IntroState extends GameState{
	
	final String title = "The Unwanted";
	
	
	//time to switch states
	private final long DURATION = 3000;
	
	private long start;
	
	
	public IntroState(GameStateManager gsm) {
		super(gsm);
	}

	
	@Override
	public void init() {
		start = System.currentTimeMillis();
	}

	@Override
	public void update() {
		handleInput();
		
		if(System.currentTimeMillis() - start > DURATION)
			gsm.setState(GameStateManager.START_MENU);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(0,0,(int)(Math.random()*256)));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
	}

	@Override
	public void handleInput() {
		if(KeysManager.isDown(KeysManager.ENTER))
			gsm.setState(GameStateManager.START_MENU);
	}

}
