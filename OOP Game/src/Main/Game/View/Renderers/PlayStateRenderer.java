package Main.Game.View.Renderers;

import Main.Game.View.View;

import java.awt.*;

/**
 * Created by mason on 3/6/16.
 */
public class PlayStateRenderer extends RendererObject {

    public PlayStateRenderer(View view) {
        super(view);
    }

    public void render(Graphics g) {
        g.setColor(new Color(0,0,(int)(Math.random()*256)));
        g.fillRect(0, 0, view.getPxWidth(), view.getPxHeight());
    }

}
