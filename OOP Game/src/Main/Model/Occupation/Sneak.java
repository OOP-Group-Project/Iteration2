package Main.Model.Occupation;

/**
 * Created by walkhard on 3/7/16.
 */
public class Sneak extends Occupation {
    public Sneak() {
        modify.put("str", 1.1);
        modify.put("agi", 1.3);
        modify.put("int", 1.0);
        modify.put("har", 1.1);
        occupationType = OccupationTypeEnum.Sneak;
    }

    @Override
    public String toString() {
        return "Sneak";
    }
}
