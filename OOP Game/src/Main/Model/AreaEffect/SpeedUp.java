package Main.Model.AreaEffect;

import Main.Model.Stats.StatsModifier;

/**
 * Created by Peter Camejo on 3/13/2016.
 */

public class SpeedUp extends AreaEffect{
    /*** Constructor ***/
    public SpeedUp(double amount){
        super(AreaEffectEnum.SPEEDUP);

        StatsModifier sm = new StatsModifier();

        sm = sm.builder()
                .movementModifier(amount)
                .build();

        this.modifier = sm;
    }

    public SpeedUp(double amount , int charge){
        super(AreaEffectEnum.SPEEDUP , charge);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .movementModifier(amount)
                .build();

        this.modifier = sm;

    }
}
