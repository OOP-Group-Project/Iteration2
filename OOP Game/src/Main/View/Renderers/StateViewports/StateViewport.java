package Main.View.Renderers.StateViewports;

import Main.View.Viewport;

import java.awt.*;

/**
 * Created by mason on 3/7/16.
 */
public abstract class StateViewport {
    protected Viewport view;

    public StateViewport() {
        view = null;
    }

    public StateViewport(Viewport view) {
        this.view = view;
    }

    public abstract void render(Graphics g);
}
