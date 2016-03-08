package Main.View.Renderers.StateViewports;

import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.View.Viewport;

import java.awt.*;

/**
 * Created by mason on 3/6/16.
 */
public class PlayStateViewport extends StateViewport {

    private Entity entity;
    private Map world;

    public PlayStateViewport(Viewport view, Entity e, Map world) {
        super(view);
        this.entity = e;
        this.world = world;
    }

    public void render(Graphics g) {

    }

}
