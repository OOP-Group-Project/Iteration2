package Main.Model.Occupation;

/**
 * Created by walkhard on 3/7/16.
 */
public class Summoner extends Occupation {
    public Summoner() {
        modify.put("str", 1.0);
        modify.put("agi", 1.0);
        modify.put("int", 1.3);
        modify.put("har", 1.0);
    }

    @Override
    public String toString() {
        return "Summoner";
    }
}
