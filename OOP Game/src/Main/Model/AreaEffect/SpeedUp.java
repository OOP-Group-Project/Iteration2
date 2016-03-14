package Main.Model.AreaEffect;

import Main.Model.Map.MapLocationPoint;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Peter Camejo on 3/13/2016.
 */

public class SpeedUp extends AreaEffect{
    /*** Constructor ***/
    public SpeedUp(double amount, MapLocationPoint location){
        super(AreaEffectEnum.SPEEDUP, location);

        StatsModifier sm = new StatsModifier();

        sm = sm.builder()
                .movementModifier(amount)
                .build();

        this.modifier = sm;
    }

    public SpeedUp(double amount , int charge, MapLocationPoint location){
        super(AreaEffectEnum.SPEEDUP , charge, location);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .movementModifier(amount)
                .build();

        this.modifier = sm;

    }
}
