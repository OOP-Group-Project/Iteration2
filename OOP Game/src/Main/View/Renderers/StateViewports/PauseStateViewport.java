package Main.View.Renderers.StateViewports;

import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.State.PauseState;
import Main.Model.State.PlayState;
import Main.View.Graphics.GraphicsAssets;
import Main.View.Viewport;

import java.awt.*;

/**
 * Created by mason on 3/10/16.
 */
public class PauseStateViewport extends StateViewport {

    private Viewport viewport;
    private PauseState pauseState;
    private PlayStateViewport playStateViewport;

    public PauseStateViewport(Viewport viewport, PauseState pauseState, PlayStateViewport playStateViewport) {
        this.viewport = viewport;
        this.playStateViewport = playStateViewport;
        this.pauseState = pauseState;
    }

    public void render(Graphics graphics) {
        playStateViewport.render(graphics);
        graphics.setColor(new Color(0,0,0,(float)0.75));
        graphics.fillRect(viewport.getPxWidth()/4, viewport.getPxHeight()/4, viewport.getPxWidth()/2, viewport.getHeight()/2);
    }
}
