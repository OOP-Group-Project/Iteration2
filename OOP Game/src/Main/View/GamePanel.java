package Main.View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Main.Controller.Manager.AssetManager;
import Main.Controller.Manager.GameStateManager;
import Main.Controller.Manager.KeysManager;



public class GamePanel extends JPanel implements KeyListener, Runnable {

	// SCREEN DIMENSIONS
	public static final int WIDTH = 300;
	public static final int HEIGHT = WIDTH*4/5;
	public static final int SCALE = 2;

	// GAME LOOP
	private Thread thread;
	private boolean gameIsRunning;
	private final int FPS = 30;
	private final int targetTime = 1000 / FPS;

	// FOR RENDERING
	private BufferedImage imageToRender;
	private Graphics2D g;

	// KEEP TRACK GAME STATE
	private GameStateManager gsm;

	// TESTING WALKING ANIMATIONS
	int x = 0;

	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT *SCALE));
		setFocusable(true);
		requestFocus();
	}
	
	@Override
	// method called internally by toolkit
	// gets called whenever the this component gets added to a container
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			init();
			thread = new Thread(this);
			thread.start();
			super.addKeyListener(this);
		}
	};
	
	private void init() {
		gameIsRunning = true;
		imageToRender = new BufferedImage(WIDTH, HEIGHT, 1);
		g = (Graphics2D) imageToRender.getGraphics();
		gsm = new GameStateManager();
	}

	@Override
	public void run() {
		long start;
		long elapsed;
		long wait;

		while (gameIsRunning) {
			start = System.nanoTime();

			update();
			render();
			renderToScreen();

			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;

	
			if (wait > 0) {
				try {
					Thread.sleep(wait);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	private void update(){
		// Used to test walking animations
		x = (x + 1) % AssetManager.playerWalkDown.length;

		KeysManager.update();
		gsm.update();
	}

	// GameStateManager handles which state should be rendering
	private void render(){
		gsm.render(g);
	}

	// Renders the graphics from the specified state to the screen
	private void renderToScreen(){
		Graphics g2 = super.getGraphics();
		g2.drawImage(imageToRender, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);

//		Uncomment this to test the walking animations
//		g2.clearRect(0,0,WIDTH,HEIGHT);
//		g2.drawImage(AssetManager.playerWalkDown[x],10,10,null);
//		g2.drawImage(AssetManager.playerWalkRight[x],10,70,null);
//		g2.drawImage(AssetManager.playerWalkDown[x],10,130,null);
//		g2.drawImage(AssetManager.playerWalkLeft[x],10,190,null);
		g2.dispose();
	}
	
	
	
	//KEY EVENT LISTENER
	@Override
	public void keyPressed(KeyEvent key) {  KeysManager.setKey(key.getKeyCode(), true);	}

	@Override
	public void keyReleased(KeyEvent key) { KeysManager.setKey(key.getKeyCode(),false);	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}
