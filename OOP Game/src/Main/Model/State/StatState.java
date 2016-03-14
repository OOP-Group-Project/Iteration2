package Main.Model.State;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;


public class StatState extends State {

    private Entity entity;


    public StatState(Entity entity){
        this.entity = entity;

    }



    public Stats getStats(){
        return entity.getStats();
    }
}
