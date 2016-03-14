package Main.Model.AreaEffect.Traps;

import Main.Model.Stats.StatsModifier;

/**
 * Created by Peter Camejo on 3/13/2016.
 */

//Lowers Strength when activated (Made this just in case we can't show off SlowingTrap
public class WeakeningTrap extends Trap{
    /*** Constructor ***/
    public WeakeningTrap(double amount){
        super(TrapTypeEnum.WEAKENING , 0);
        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .strengthModifier(-amount)
                .build();
        this.modifier = sm;
    }

    public WeakeningTrap(double amount , int requiredDetectionSkill){
        super(TrapTypeEnum.WEAKENING , requiredDetectionSkill);
        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .strengthModifier(amount)
                .build();
        this.modifier = sm;
    }

}
