package Main.Game.View;

import Main.Game.Controller.Controller;
import Main.Game.Controller.GameStates.GameStateEnum;
import Main.Game.View.Graphics.GraphicsAssets;
import Main.Game.View.Renderers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.EnumMap;


/**
 * Created by mason on 3/6/16.
 */
public class View extends JPanel {

    private JFrame frame;
    private Controller controller;
    private GraphicsAssets graphicsAssets;
    private EnumMap<GameStateEnum, RendererObject> renderers;

    // FOR RENDERING
    private BufferedImage bufferedImage;
    private Graphics g;

    // SCREEN DIMENSIONS
    private int pxWidth = 600;
    private int pxHeight = 400;

    public View(Controller controller, String gameTitle) {
        this.controller = controller;

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


        graphicsAssets = new GraphicsAssets();
        graphicsAssets.init();


        initializeRenderers();
    }

    private void initializeRenderers() {
        renderers = new EnumMap<>(GameStateEnum.class);
        renderers.put(GameStateEnum.PlayState, new PlayStateRenderer(this));
    }

    private void updateBounds() {
        pxWidth = this.getWidth();
        pxHeight = this.getHeight();
    }

    public void render() {
        // If we've changed the size of the window, update the pxWidth and pxHeight variables.
        updateBounds();

        // Get our current state.
        GameStateEnum currentState = controller.getCurrentState();

        // Get the graphics object
        g = super.getGraphics();

        // Clear the screen
        g.clearRect(0,0,pxWidth,pxHeight);

        // Render the current state
        renderers.get(currentState).render(g);

        // Get rid of everything.
        g.dispose();
    }

    public int getPxWidth() {
        return pxWidth;
    }

    public int getPxHeight() {
        return pxHeight;
    }

}
