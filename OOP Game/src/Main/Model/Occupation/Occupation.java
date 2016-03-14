package Main.Model.Occupation;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by walkhard on 2/18/16.
 */

public abstract class Occupation {
    protected OccupationTypeEnum occupationType;
    //
    protected HashMap<String, Double> modify = new HashMap<>();

    public HashMap<String, Double> map(){return modify;}

    public abstract String toString();

    public OccupationTypeEnum getOccupationType() {
        return  occupationType;
    }
}
