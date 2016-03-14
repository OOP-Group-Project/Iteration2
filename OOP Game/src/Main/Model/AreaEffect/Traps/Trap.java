package Main.Model.AreaEffect.Traps;

import Main.Model.AreaEffect.AreaEffect;
import Main.Model.AreaEffect.AreaEffectEnum;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Requirement;
import Main.Model.Stats.StatsModifier;


/**
 * Created by Peter Camejo on 3/13/2016.
 */
public class Trap extends AreaEffect {
    /*** Member Variables ***/
    protected boolean isVisible;
    protected TrapTypeEnum trapType;
    protected int requiredDetectionSkill; //Detection skilled need to make trap visible.

    /*** Constructors ***/
    public Trap(MapLocationPoint location){
        super(AreaEffectEnum.TRAP, 100, location);
        this.isVisible = false;
        this.requiredDetectionSkill = 0;
        this.trapType = null;
        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .lifeModifier(-10)
                .movementModifier(-100)
                .build();
        this.modifier = sm;
    }
    public Trap(TrapTypeEnum trapType,int requiredDetectionSkill, MapLocationPoint location){
        super(AreaEffectEnum.TRAP, location);
        this.isVisible = false;
        this.requiredDetectionSkill = requiredDetectionSkill;
        this.trapType = trapType;
    }

    /*** Methods ***/
    public void setIsVisible(boolean visible){this.isVisible = visible;}
    public boolean getIsVisible(){return this.isVisible;}
    public TrapTypeEnum getTrapType(){ return this.trapType;}
    public int getRequiredDetectionSkill(){return this.requiredDetectionSkill;}

}