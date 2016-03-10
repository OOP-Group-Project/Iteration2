package Main.Model.AreaEffect;

import Main.Model.Stats.StatsEnum;

/**
 * Created by Michael on 3/9/16.
 */

public class HealDamage extends AreaEffect {

    private static final long duration = 0;
    private static final int value = 1;
    private static final String name = "HealDamage";

    public HealDamage(){
        super(StatsEnum.LIFE, value, duration, name);
        this.type = AreaEffectEnum.Heal;
    }

}
