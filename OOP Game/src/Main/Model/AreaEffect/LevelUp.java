package Main.Model.AreaEffect;


import Main.Model.Map.MapLocationPoint;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Michael on 3/9/16.
 * Implemented by Peter Camejo on 3/11/16
 */

/* Note: !!!! LevelUp does not have a StatModifier !!!!
 * My suggested implementation for applying this areaEffect would be
 *  to call Stats.levelUp() instead of the the typical Stats.modifyStats()
 *  This implementation seems far simpler than for LevelUp
 *  to have a statsModifier that modifies experience, as the amount
 *  of experience needed to levelUp would change as the level increases.
 *
 *  if(AreaEffect.getType == AreaEffectEnum.LEVELUP){
 *      Stats.levelUp();
 *  }else{
 *      Stats.modifyStats(AreaEffect.getModifier);
 *  }
 *
 */

public class LevelUp extends AreaEffect {
    /*** Constructor ***/

    //Applies Once
    public LevelUp(MapLocationPoint location){
        super(AreaEffectEnum.LEVELUP, location);
        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .experienceModifier(10)
                .build();
        this.modifier = sm;
    }

    public LevelUp(int charge, MapLocationPoint location){
        super(AreaEffectEnum.LEVELUP , charge, location);
        StatsModifier sm = new StatsModifier();
        sm = sm.builder()
                .experienceModifier(100)
                .build();
        this.modifier = sm;
    }

}
