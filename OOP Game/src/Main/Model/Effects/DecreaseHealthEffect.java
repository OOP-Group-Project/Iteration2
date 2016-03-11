package Main.Model.Effects;

import Main.Model.Entity.Entity;
import Main.Model.Stats.*;

/**
 * Created by Michael on 3/10/16.
 */
public class DecreaseHealthEffect extends Effect{

    private double value;
    private String type;

    public DecreaseHealthEffect(double value, String type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public void activate(Entity e){
//        e.modify();
    }

    @Override
    public void deactivate(Entity e){
//        e.modify();
    }
}
