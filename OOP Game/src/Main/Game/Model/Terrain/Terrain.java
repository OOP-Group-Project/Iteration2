package Main.Game.Model.Terrain;

/**
 * Created by walkhard on 2/18/16.
 */
public abstract class Terrain {
    //
    protected boolean is_passable;
    public boolean isPassable(){return is_passable;}
    public void setPassable(boolean bool) {is_passable = bool;}
}
