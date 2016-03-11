package Main.Model.Stats;

/**
 * Created by Michael on 3/9/16.
 */
public abstract class Effect {

    private StatsStructure modifier;
    private long duration;
    private String description;

    public Effect(){
        duration = 0;
        description = null;
        modifier = new StatsStructure();
    }

    public Effect(StatsStructure modifier, long duration, String description){
        this.modifier = modifier;
        this.duration = duration;
        this.description = description;
    }
}
