package Main.Model.AreaEffect.Traps;

import Main.Model.Map.MapLocationPoint;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Peter Camejo on 3/13/2016.
 */
public class DamageTrap extends Trap {

    /*** Constructor ***/
    public DamageTrap(double damageAmount, MapLocationPoint location){
        super(TrapTypeEnum.DAMAGE , 0, location);
        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .lifeModifier(-damageAmount)
                .build();
        this.modifier = sm;
    }

    public DamageTrap(double damageAmount , int requiredDetectionSkill, MapLocationPoint location){
        super(TrapTypeEnum.DAMAGE , requiredDetectionSkill, location);
        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .lifeModifier(-damageAmount)
                .build();
        this.modifier = sm;
    }

}
