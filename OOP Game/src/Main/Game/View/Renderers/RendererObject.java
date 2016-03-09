package Main.Game.View.Renderers;

import Main.Game.View.View;

import java.awt.*;

/**
 * Created by mason on 3/6/16.
 */

// Note: this is named this way because there is already a "Renderer" class defined and it was causing issues.
public abstract class RendererObject {

    protected View view;

    RendererObject(View view) {
        this.view = view;
    }

    public abstract void render(Graphics g);

}
