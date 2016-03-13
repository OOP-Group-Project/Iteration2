package Main.Model.AreaEffect.Traps;

import Main.Model.AreaEffect.AreaEffect;
import Main.Model.Stats.StatsModifier;
import Main.Model.AreaEffect.AreaEffectEnum;

/**
 * Created by Peter Camejo on 3/13/2016.
 */
public class Trap extends AreaEffect {
    /*** Member Variables ***/
    private boolean isVisible;

    /*** Constructors ***/
    public Trap(){
        this.type = AreaEffectEnum.TRAP;
        this.modifier = null;
        this.isVisible = false;
    }

    public Trap(StatsModifier modifier , boolean isVisible){
        super(AreaEffectEnum.TRAP , 0);
        this.isVisible = isVisible;
    }

    /*** Methods ***/
    public void setIsVisible(boolean visible){this.isVisible = visible;}
    public boolean getIsVisible(){return this.isVisible;}

}