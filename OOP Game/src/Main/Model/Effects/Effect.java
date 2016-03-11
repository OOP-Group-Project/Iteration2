package Main.Model.Effects;

import Main.Model.Entity.Entity;

/**
 * Created by Michael on 3/10/16.
 */
public abstract class Effect {

    public abstract void activate(Entity e);

    public abstract void deactivate(Entity e);
}
