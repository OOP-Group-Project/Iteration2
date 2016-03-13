package Main.View.Renderers.StateViewports;

import Main.Model.Inventory.Inventory;
import Main.Model.State.InventoryState;
import Main.Model.State.TalkState;
import Main.View.Viewport;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by Walkhard on 3/12/2016.
 */
public class TalkStateViewport extends StateViewport {
    //
    public TalkStateViewport(Viewport view, PlayStateViewport playStateViewport, TalkState talkState) {
        this.viewport = view;
        this.play_state_viewport = playStateViewport;
        this.talk_state = talkState;
    }
    //
    private Viewport viewport;
    private PlayStateViewport play_state_viewport;
    private TalkState talk_state;
    //
    @Override
    public void render(Graphics g){

    }
    //
    private void renderTitle(Graphics g) {

    }
    //
    private void renderTalk(Graphics g){

    }
}
