package Main.Controller.ObjectControllers;

import Main.Model.Actions.Attack;
import Main.Model.AreaEffect.AreaEffect;
import Main.Model.AreaEffect.AttackEffect;
import Main.Model.Entity.Entity;
import Main.Model.Map.Tile;

/**
 * Created by mason on 3/14/16.
 */
public class AttackEffectController extends TimedObjectController {

    private AttackEffect attackEffect;

    public AttackEffectController(AttackEffect attackEffect) {
        super(attackEffect.getCharge());
        this.attackEffect = attackEffect;
        timer.start();
    }

    public void activate(Entity entity) {
        if(timer.isExpired()) {
            entity.modifyStats(attackEffect.getModifier());
        }
    }

    public boolean canActivate() {
        return timer.isExpired();
    }

}
