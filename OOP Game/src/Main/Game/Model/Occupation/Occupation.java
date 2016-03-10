package Main.Game.Model.Occupation;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by walkhard on 2/18/16.
 */

public abstract class Occupation {
    //
    protected Map<String, Double> modify = new HashMap<>();
    public Map map(){return modify;}
}
