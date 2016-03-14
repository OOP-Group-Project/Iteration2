package Main.Model.AreaEffect;

import Main.Model.Map.MapLocationPoint;
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
    protected MapLocationPoint location;
    protected int charge;

    /*** Constructor ***/
    public AreaEffect(){
        this.type = null;
        this.modifier = null;
        this.charge = 0;
    }

    //For OneShot AreaEffect children super() calls
    public AreaEffect(AreaEffectEnum type, MapLocationPoint location){
        this.type = type;
        this.location = location;
        charge = 0;
    }

    public AreaEffect(AreaEffectEnum type, int charge, MapLocationPoint location){
        this.type = type;
        this.charge = charge;
        this.location = location;
    }

    public AreaEffect(AreaEffectEnum type , StatsModifier modifier , int charge, MapLocationPoint location){
        this.type = type;
        this.location = location;
        this.modifier = modifier;
        this.charge = charge;
    }

    public MapLocationPoint getLocation() {
        return location;
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
