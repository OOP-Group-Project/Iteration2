package Main.Model.AreaEffect;

import Main.Model.Map.MapLocationPoint;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Michael on 3/9/16.
 * Implemented by Peter Camejo 3/13/16
 */

public class TakeDamage extends AreaEffect {
    /*** Constructor ***/
    //Applies Once
    public TakeDamage(double damageAmount, MapLocationPoint location){
        super(AreaEffectEnum.DAMAGE, location);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .lifeModifier(-damageAmount)
                .build();
        this.modifier = sm;
    }

    public TakeDamage(double damageAmount , int charge, MapLocationPoint location){
        super(AreaEffectEnum.DAMAGE , charge, location);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .lifeModifier(-damageAmount)
                .build();
        this.modifier = sm;

    }

}
