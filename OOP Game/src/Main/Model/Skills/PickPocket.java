package Main.Model.Skills;

import Main.Model.Entity.Entity;

/**
 * Created by AndyZhu on 7/3/2016.
 */
public class PickPocket extends SneakSkills {
    public PickPocket (Entity entity, double cooldown, double manacost) {
        super(entity, cooldown, manacost);
    }

    public boolean activate() {
        return successfulPerformance();
    }
}