package Main.Model.AreaEffect;

import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;


/**
 * Created by Michael on 3/9/16.
 * Worked on by Peter Camejo 3/13/2016
 */

public abstract class AreaEffect {
    /*** Member Variables ***/
    protected AreaEffectEnum type;
    protected StatsModifier modifier;
    protected int charge;

    /*** Constructor ***/
    public AreaEffect(){
        this.type = null;
        this.modifier = null;
        this.charge = 0;
    }

    //For OneShot AreaEffect children super() calls
    public AreaEffect(AreaEffectEnum type){
        this.type = type;
        charge = 0;
    }

    public AreaEffect(AreaEffectEnum type, int charge){
        this.type = type;
        this.charge = charge;
    }

    public AreaEffect(AreaEffectEnum type , StatsModifier modifier , int charge){
        this.type = type;
        this.modifier = modifier;
        this.charge = charge;
    }

    public int getCharge() {
        return charge;
    }

    /*** Methods ***/
    public StatsModifier getModifier(){return modifier;}
    public AreaEffectEnum getType(){
        return type;
    }

}
