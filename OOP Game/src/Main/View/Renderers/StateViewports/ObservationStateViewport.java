package Main.View.Renderers.StateViewports;

import Main.Model.State.ObservationState;
import Main.View.Viewport;

import java.awt.*;

/**
 * Created by mason on 3/13/16.
 */
public class ObservationStateViewport extends StateViewport {

    private PlayStateViewport playStateViewport;
    private ObservationState observationState;
    private Viewport viewport;

    public ObservationStateViewport(Viewport viewport, PlayStateViewport playStateViewport, ObservationState observationState) {
        this.playStateViewport = playStateViewport;
        this.observationState = observationState;
        this.viewport = viewport;
    }

    @Override
    public void render(Graphics g) {
   //     playStateViewport.render(g, observationState.getCenterPoint());
    }
}
