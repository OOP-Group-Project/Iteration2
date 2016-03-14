package Main.Model.AreaEffect;


import Main.Model.Map.MapLocationPoint;
import Main.Model.Stats.StatsModifier;

import java.awt.geom.Area;

/**
 * Created by Michael on 3/9/16.
 * Implemented by Peter Camejo 3/11/16
 */

public class InstantDeath extends AreaEffect{

    /*** Constructor ***/
    public InstantDeath(MapLocationPoint location){
        super(AreaEffectEnum.DEATH, location);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .lifeModifier(-Double.MAX_VALUE) //Ain't playin' games
                .build();
        this.modifier = sm;
    }


}
