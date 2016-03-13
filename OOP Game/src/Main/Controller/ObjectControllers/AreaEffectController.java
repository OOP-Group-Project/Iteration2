package Main.Controller.ObjectControllers;

import Main.Model.AreaEffect.AreaEffect;
import Main.Model.Entity.Entity;

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
}
