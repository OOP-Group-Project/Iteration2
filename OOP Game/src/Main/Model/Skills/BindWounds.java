package Main.Model.Skills;

import java.util.Random;

/**
 * Created by Matthew on 3/11/2016.
 */
public class BindWounds extends Skills {


    public BindWounds() {
        //sets cooldown period to 10 seconds
        super(10.0);
    }



    public int activate() {
        Random rand = new Random();
        int randomNum = rand.nextInt(100);
        if(level * 20 > randomNum) {
            return level * 3 + 4;
        }
        return 0;
        //return the number to increase health by
        //or actually increase health here?
    }


}
