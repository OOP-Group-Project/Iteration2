package Controller.GameStates;

import java.awt.*;

import Controller.Manager.GameStateManager;
import Main.GamePanel;

public class StartMenuState extends GameState{

	public StartMenuState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(100,100, GamePanel.WIDTH,GamePanel.HEIGHT);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

}
