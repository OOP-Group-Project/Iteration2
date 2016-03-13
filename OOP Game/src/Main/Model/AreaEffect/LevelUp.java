package Main.Model.AreaEffect;


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
    public LevelUp(){
        super(AreaEffectEnum.LEVELUP);
    }

    public LevelUp(int charge){
        super(AreaEffectEnum.LEVELUP , charge);
    }

}
