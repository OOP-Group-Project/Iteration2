package Main.View.Renderers.StateViewports;

import Main.Model.State.TradeState;
import Main.View.Viewport;

import java.awt.*;

/**
 * Created by Michael on 3/14/16.
 */
public class TradeStateViewport extends StateViewport {

    private Viewport viewport;
    private TradeState tradeState;
    private PlayStateViewport playStateViewport;

    public TradeStateViewport(Viewport viewport, TradeState tradeState, PlayStateViewport playStateViewport){
        this.viewport = viewport;
        this.tradeState = tradeState;
        this.playStateViewport = playStateViewport;
    }


    @Override
    public void render(Graphics g) {

    }
}
