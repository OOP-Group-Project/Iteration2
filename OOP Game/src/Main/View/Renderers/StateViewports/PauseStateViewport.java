package Main.View.Renderers.StateViewports;

import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.View.Graphics.GraphicsAssets;
import Main.View.Viewport;

import java.awt.*;

/**
 * Created by mason on 3/10/16.
 */
public class PauseStateViewport extends PlayStateViewport {

    public PauseStateViewport(Viewport viewport, GraphicsAssets graphicsAssets, Entity player, Map world) {
        super(viewport, graphicsAssets, player, world);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }
}
