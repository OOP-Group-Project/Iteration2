package Main.Controller.ObjectControllers;

import Main.Model.AreaEffect.AreaEffect;
import Main.Model.AreaEffect.AreaEffectEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;

/**
 * Created by mason on 3/12/16.
 */
public class AreaEffectController extends TimedObjectController {

    private AreaEffect areaEffect;

    public AreaEffectController(AreaEffect areaEffect, int msChargeTime) {
        super(msChargeTime);
        this.areaEffect = areaEffect;
    }

    public void activate(Entity entity) {
        if(timer.isExpired()) {
            timer.start();
            entity.modifyStats(areaEffect.getModifier());
        }
    }

    public void activate(Entity entity, Map map) {
        if(timer.isExpired()) {
            timer.start();
            map.addEntity(entity, areaEffect.getDestination());
            entity.setLocation(areaEffect.getDestination());
        }
    }
}
