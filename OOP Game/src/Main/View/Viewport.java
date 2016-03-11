package Main.View;

import Main.Controller.Controller;
import Main.Model.Model;
import Main.Model.State.InventoryState;
import Main.Model.State.PauseState;
import Main.Model.State.PlayState;
import Main.Model.State.State;
import Main.Model.State.StateEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;
import Main.View.Graphics.GraphicsAssets;
import Main.View.Renderers.ObjectRenderer;
import Main.View.Renderers.StateViewports.InventoryStateViewport;
import Main.View.Renderers.StateViewports.LoadStateViewport;
import Main.View.Renderers.StateViewports.PauseStateViewport;
import Main.View.Renderers.StateViewports.PlayStateViewport;
import Main.View.Renderers.StateViewports.StateViewport;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.EnumMap;


/**
 * Created by mason on 3/6/16.
 */
public class Viewport extends JFrame implements Runnable {
    public static Viewport viewport;
    private Controller controller;
    private Map world;
    private Avatar player;


    // This structure represents a mapping between teh current state of the game and what to render.
    private EnumMap<StateEnum, StateViewport> stateViewports;
    private ObjectRenderer objectRenderer;
    private GraphicsAssets graphicsAssets;

    // The buffered image is a "canvas" that we render to and the Graphics object is what we use to draw on the canvas
    private Canvas canvas;
    private Graphics g;
    private BufferStrategy bufferStrategy;

    // Screen dimensions are variable with how large the screen is at any one time.  Use the getters to reference them.
    private int pxWidth = 600;
    private int pxHeight = 400;

    public Viewport(Model model, Controller controller, String gameTitle) {
        viewport = this;
        this.player = model.getPlayer();
        this.world = model.getWorld();
        this.controller = controller;

        //******************************
        // Initialize the window
        //******************************
        setTitle(gameTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(pxWidth, pxHeight));
        canvas.setFocusable(false);

        this.add(canvas);
        this.pack();

        //******************************
        // Initialize the graphics
        //******************************
        graphicsAssets = new GraphicsAssets();
        graphicsAssets.init();

        //******************************
        // Initialize the stateViewports
        //******************************
        initializeRenderers(model.getStates());
        Viewport.viewport.addKeyListener(controller.getKeyListener());
        viewport.setFocusable(true);

    }


    // Each renderer is an object that stores how it should render a specific object to the game screen.
    // The state stateViewports can use individual object rednerers that are relevant to them (i.e., the playStateRenderer has an EntityRenderer and MapRenderer so that it can call both of their render methods)
    private void initializeRenderers(EnumMap<StateEnum, State> states) {
        // Start by initializing the object renderers
        objectRenderer = new ObjectRenderer(this, graphicsAssets);

        // Then initialize the state renderers
        stateViewports = new EnumMap<>(StateEnum.class);
        stateViewports.put(StateEnum.PlayState, new PlayStateViewport(this, graphicsAssets, (PlayState)states.get(StateEnum.PlayState)));
        stateViewports.put(StateEnum.LoadState, new LoadStateViewport(this));
        stateViewports.put(StateEnum.PauseState, new PauseStateViewport(this, (PauseState)states.get(StateEnum.PauseState), (PlayStateViewport)stateViewports.get(StateEnum.PlayState)));
       
        stateViewports.put(StateEnum.InventoryState,new InventoryStateViewport(this,(PlayStateViewport)stateViewports.get(StateEnum.PlayState),(InventoryState)states.get(StateEnum.InventoryState)));
    }


    // This function updates the pixel dimensions of the screen during the view object's update method
    private void updateBounds() {
        pxWidth = this.getWidth();
        pxHeight = this.getHeight();
    }

    // This renders the Viewport (which is the JPanel), which in turn calls the render method of the state that we are currently in.
    public void render() {
        // If we've changed the size of the window, update the pxWidth and pxHeight variables.
        updateBounds();

        // Get our current state.
        StateEnum currentState = controller.getCurrentState();

        bufferStrategy = this.canvas.getBufferStrategy();
        if(bufferStrategy == null) {
            this.canvas.createBufferStrategy(3);
            return;
        }

        // Get the graphics object
        g = bufferStrategy.getDrawGraphics();

        // Clear the screen
        g.clearRect(0, 0, pxWidth, pxHeight);

        // Render the current state
        stateViewports.get(currentState).render(g);

        // Clear the graphics buffer.
        bufferStrategy.show();
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
