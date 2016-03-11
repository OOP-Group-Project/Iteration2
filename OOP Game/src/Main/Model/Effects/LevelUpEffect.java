package Main.Model.Effects;

import Main.Model.Entity.Entity;

/**
 * Created by Michael on 3/10/16.
 */
public class LevelUpEffect extends Effect {

    private double value;
    private String type;

    public LevelUpEffect(double value, String type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public void activate(Entity e){

    }

    @Override
    public void deactivate(Entity e){

    }
}
