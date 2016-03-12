package Main.View.Renderers.StateViewports;

import Main.View.Viewport;

import java.awt.*;

/**
 * Created by mason on 3/7/16.
 */
public abstract class StateViewport {
	
	protected int WIDTH = 700;
	protected int HEIGHT = 700;
	
    public abstract void render(Graphics g);

}
