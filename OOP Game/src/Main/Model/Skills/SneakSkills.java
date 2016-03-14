package Main.Model.Skills;

import Main.Model.Entity.Entity;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public abstract class SneakSkills extends Skills {
    public SneakSkills(Entity entity, double coolDownPeriod, double manaCost) {
        super(entity, coolDownPeriod, manaCost);
    }

    public boolean activate() {
        if (allCheck()) {
            enforceManaCost();
            timeWhenPerformed = System.currentTimeMillis();
            return true;
        }
        else {
            return false;
        }
    }
}
