package Main.Model.AreaEffect;

import Main.Model.Stats.StatsModifier;


/**
 * Created by Michael on 3/9/16.
 * Implemented by Peter Camejo on 3/11/16
 */

public class HealDamage extends AreaEffect {

    /*** Constructor ***/
    //Applies once
    public HealDamage(double healAmount){
        super(AreaEffectEnum.HEAL);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .lifeModifier(healAmount)
                .build();
        this.modifier = sm;

    }

    public HealDamage(double healAmount, int charge){
        super(AreaEffectEnum.HEAL, charge);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .lifeModifier(healAmount)
                .build();
        this.modifier = sm;

    }

}
