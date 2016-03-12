package Main.Model.Skills;

/**
 * Created by Matthew on 3/11/2016.
 */
public class Bargain extends Skills {

    public Bargain() {
        super(0);
    }

    public int activate() {
        //takes off level * 10 from the
        //price of the item in the shop
        return level * 10;
    }
}
