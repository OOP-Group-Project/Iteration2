package Main.Model.Terrain;

import Main.Controller.Manager.AssetManager;

/**
 * Created by walkhard on 2/18/16.
 */
public class Grass extends Terrain {

    public Grass(){
        super(AssetManager.grass);
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
