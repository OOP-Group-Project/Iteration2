package Main.Model.AreaEffect.Traps;

import Main.Model.Map.MapLocationPoint;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Peter Camejo on 3/13/2016.
 */
public class SlowingTrap extends Trap{
    /*** Constructor ***/
    public SlowingTrap(double slowAmount, MapLocationPoint location){
        super(TrapTypeEnum.SLOW , 0, location);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .movementModifier(-slowAmount)
                .build();

        this.modifier = sm;

    }

    public SlowingTrap(double slowAmount , int requiredDetectionSkill, MapLocationPoint location){
        super(TrapTypeEnum.SLOW , requiredDetectionSkill, location);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .movementModifier(-slowAmount)
                .build();

        this.modifier = sm;

    }
}
