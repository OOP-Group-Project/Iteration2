package Main.Model.AreaEffect;

import Main.Model.Map.MapLocationPoint;
import Main.Model.Stats.StatsModifier;


/**
 * Created by Michael on 3/9/16.
 * Implemented by Peter Camejo on 3/11/16
 */

public class HealDamage extends AreaEffect {

    /*** Constructor ***/
    //Applies once
    public HealDamage(double healAmount, MapLocationPoint location){
        super(AreaEffectEnum.HEAL, location);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .lifeModifier(healAmount)
                .build();
        this.modifier = sm;

    }

    public HealDamage(double healAmount, int charge, MapLocationPoint location){
        super(AreaEffectEnum.HEAL, charge, location);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .lifeModifier(healAmount)
                .build();
        this.modifier = sm;

    }

}
