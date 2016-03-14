package Main.Model.Skills;

import Main.Model.Entity.Entity;

/**
 * Created by walkhard on 2/18/16.
 */
public abstract class BaseSkills extends Skills {

    public BaseSkills(Entity entity, double coolDownPeriod, double manaCost) {
        super(entity, coolDownPeriod, manaCost);
    }

}
