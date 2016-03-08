package Main.Game.View;

import Main.Game.Controller.Controller;
import Main.Game.Controller.GameStates.GameStateEnum;
import Main.Game.Model.Map.Map;
import Main.Game.View.Graphics.GraphicsAssets;
import Main.Game.View.Renderers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.EnumMap;


/**
 * Created by mason on 3/6/16.
 */
public class View extends JPanel implements Runnable {

    private JFrame frame;
    private Controller controller;
    private Map world;
    private GraphicsAssets graphicsAssets;

    // This structure represents a mapping between teh current state of the game and what to render.
    private EnumMap<GameStateEnum, RendererObject> renderers;

    // The buffered image is a "canvas" that we render to and the Graphics object is what we use to draw on the canvas
    private Graphics2D g;

    // Screen dimensions are variable with how large the screen is at any one time.  Use the getters to reference them.
    private int pxWidth = 600;
    private int pxHeight = 400;

    public View(Map world, Controller controller, String gameTitle) {
        this.world = world;
        this.controller = controller;

        // Initialize the window
        frame = new JFrame();
        frame.setTitle(gameTitle);

        this.setPreferredSize(new Dimension(pxWidth, pxHeight));
        this.setFocusable(true);
        this.requestFocus();

        frame.add(this);
        frame.setResizable(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(new Dimension(pxWidth, pxHeight));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(controller.getKeyListener());


        // Initialize the graphics
        graphicsAssets = new GraphicsAssets();
        graphicsAssets.init();

        // Initialize the renderers
        initializeRenderers();
    }


    // Each renderer is an object that stores how it should render a specific object to the game screen.
    // The state renderers have individual object rednerers that are relevant to them (i.e., the playStateRenderer has an EntityRenderer and MapRenderer so that it can call both of their render methods)
    private void initializeRenderers() {
        renderers = new EnumMap<>(GameStateEnum.class);
        renderers.put(GameStateEnum.PlayState, new PlayStateRenderer(this));
        renderers.put(GameStateEnum.LoadState, new LoadStateRenderer(this));
    }


    // This function updates the pixel dimensions of the screen during the view object's update method
    private void updateBounds() {
        pxWidth = this.getWidth();
        pxHeight = this.getHeight();
    }

    // This renders the View (which is the JPanel), which in turn calls the render method of the state that we are currently in.
    public void render() {
        // If we've changed the size of the window, update the pxWidth and pxHeight variables.
        updateBounds();

        // Get our current state.
        GameStateEnum currentState = controller.getCurrentState();

        // Get the graphics object
        g = (Graphics2D)super.getGraphics();

        // Clear the screen

            g.clearRect(0, 0, pxWidth, pxHeight);

        // Render the current state
        renderers.get(currentState).render(g);

        // Clear the graphics buffer.
        g.dispose();
    }

    @Override
    public void run() {

        while(true) {
            long lastTime = System.currentTimeMillis();

            render();

            double delta = System.currentTimeMillis() - lastTime;
            if(delta < 50) {
                try {
                    Thread.sleep(((long)(50 - delta)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void start() {
        new Thread(this).start();
    }


    public int getPxWidth() {
        return pxWidth;
    }

    public int getPxHeight() {
        return pxHeight;
    }

}
