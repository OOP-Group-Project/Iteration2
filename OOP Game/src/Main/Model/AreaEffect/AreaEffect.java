package Main.Model.AreaEffect;

import Main.Model.Stats.Effect;
import Main.Model.Stats.StatsEnum;
import Main.Model.Stats.StatsStructure;

/**
 * Created by Michael on 3/9/16.
 */

public abstract class AreaEffect {

    protected AreaEffectEnum type;
//    protected StatsStructure modifier;
//    protected Effect mEffect;


    /*
        This is a placeholder constructor to create an AreaEffect with a type.
        AreaEffect will take in a StateModifier
     */

    public AreaEffect(AreaEffectEnum type){
        this.type = type;
    }

    /* Old structure, waiting on StatsModifier class.


    public AreaEffect(StatsEnum statEnum, int value, long duration, String name){
        // Creates a new modifier which maps the statEum to the value
        modifier = new StatsStructure(statEnum,value);

        // Creates a new effect with the modifier, duration and description
        mEffect = new Effect(modifier , duration, name);
    }


    // Getters
    public Effect getEffect(){
        return mEffect;
    }
    */

    public AreaEffectEnum getType(){
        return type;
    }

}
