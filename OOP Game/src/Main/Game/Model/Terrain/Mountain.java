package Main.Game.Model.Terrain;

import Main.Controller.Manager.AssetManager;

/**
 * Created by walkhard on 2/18/16.
 */
public class Mountain extends Terrain {

    public Mountain(){
        super(AssetManager.mountain);
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
