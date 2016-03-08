package Main.View.Renderers.StateViewports;

import Main.View.Viewport;

import java.awt.*;

/**
 * Created by mason on 3/7/16.
 */
public abstract class StateViewport {
    protected Viewport viewport;

    public StateViewport() {
        viewport = null;
    }

    public StateViewport(Viewport view) {
        this.viewport = view;
    }

    public abstract void render(Graphics g);
}
