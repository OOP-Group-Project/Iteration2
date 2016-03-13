package Main.Model.AreaEffect.Traps;

import Main.Model.Stats.StatsModifier;

/**
 * Created by Peter Camejo on 3/13/2016.
 */
public class SlowingTrap extends Trap{
    /*** Constructor ***/
    public SlowingTrap(double slowAmount){
        super(TrapTypeEnum.SLOW , 0);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .movementModifier(-slowAmount)
                .build();

        this.modifier = sm;

    }

    public SlowingTrap(double slowAmount , int requiredDetectionSkill){
        super(TrapTypeEnum.SLOW , requiredDetectionSkill);

        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .movementModifier(-slowAmount)
                .build();

        this.modifier = sm;

    }
}
