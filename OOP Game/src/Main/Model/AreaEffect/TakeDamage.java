package Main.Model.AreaEffect;

import Main.Model.Stats.StatsEnum;

/**
 * Created by Michael on 3/9/16.
 */

public class TakeDamage extends AreaEffect {

    private static final long duration = 0;
    private static final int value =  -1;
    private static final String name = "TakeDamage";

    // Calls the AreaEffect constructor to create an associated effect
    // that can be applied to the player using player.applyEffect(effect);
    public TakeDamage(){
        super(StatsEnum.LIFE, value, duration, name);
        this.type = AreaEffectEnum.Damage;
    }
}
