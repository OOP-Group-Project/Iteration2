package Main.Model.Skills;

import Main.Model.Entity.Entity;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class DetectTrap extends SneakSkills {
    public DetectTrap (Entity entity, double cooldown, double manacost) {
        super(entity, cooldown, manacost);
    }

    public boolean activate() {
        return successfulPerfoemance();
    }
}
