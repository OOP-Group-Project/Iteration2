package Main.Model.Terrain;

import Main.View.Graphics.GraphicsAssets;

/**
 * Created by walkhard on 2/18/16.
 */
public class Water extends Terrain {

    public Water(){
        super(GraphicsAssets.water);
    }

    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public boolean isHidden() {
        return true;
    }
}
