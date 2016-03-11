package Main.Model.AreaEffect;

import Main.Model.Stats.StatsEnum;

/**
 * Created by Michael on 3/9/16.
 */

public class LevelUp extends AreaEffect {

//    private static final long duration = 0;
//    private static final int value = 1;
//    private static final String name = "LevelUp";

    // Calls the AreaEffect constructor to create an associated effect
    // that can be applied to the player using player.applyEffect(effect);
    public LevelUp(){
        super(AreaEffectEnum.LevelUp);
//        this.type = AreaEffectEnum.LevelUp;
    }
}
