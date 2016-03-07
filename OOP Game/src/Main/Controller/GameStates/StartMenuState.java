package Main.Controller.GameStates;

import java.awt.*;

import Main.Controller.Manager.GameStateManager;
import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;
import Main.Model.Map.Hexagon;

public class StartMenuState extends GameState{

	private Avatar mAvatar = new Avatar();
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
//		mAvatar.render(g, 15, 15);
//		Hexagon Render Test with coordinates
		Hexagon.setSide(15);
		for (int i=0;i<25;i++) {
			for (int j=0;j<25;j++) {
				Hexagon.render(i,j,g);
			}
		}
//		g.setColor(Color.RED);
//		g.fillRect(100,100, GamePanel.WIDTH,GamePanel.HEIGHT);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

}
