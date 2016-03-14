package Main.Model.AreaEffect.Traps;

import Main.Model.Map.MapLocationPoint;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Peter Camejo on 3/13/2016.
 */

//Lowers Strength when activated (Made this just in case we can't show off SlowingTrap
public class WeakeningTrap extends Trap{
    /*** Constructor ***/
    public WeakeningTrap(double amount, MapLocationPoint location){
        super(TrapTypeEnum.WEAKENING , 0, location);
        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .strengthModifier(-amount)
                .build();
        this.modifier = sm;
    }

    public WeakeningTrap(double amount , int requiredDetectionSkill, MapLocationPoint location){
        super(TrapTypeEnum.WEAKENING , requiredDetectionSkill, location);
        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .strengthModifier(amount)
                .build();
        this.modifier = sm;
    }

}
