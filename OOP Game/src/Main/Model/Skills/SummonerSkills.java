package Main.Model.Skills;

import Main.Model.Entity.Entity;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public abstract class SummonerSkills extends Skills {
    public SummonerSkills(Entity entity, double coolDownPeriod, double manaCost) {
        super(entity, coolDownPeriod, manaCost);
    }
}
