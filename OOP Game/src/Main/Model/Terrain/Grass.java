package Main.Model.Terrain;

import Main.View.Graphics.GraphicsAssets;

/**
 * Created by walkhard on 2/18/16.
 */
public class Grass extends Terrain {

    public Grass(){
        super(GraphicsAssets.grass);
    }

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public boolean isHidden() {
        return false;
    }
}
