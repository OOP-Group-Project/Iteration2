package Main.Model.AreaEffect;


import Main.Model.Map.MapLocationPoint;

/**
 * Created by mason on 3/14/16.
 */
public class AttackEffect extends TakeDamage {

    public AttackEffect(double damageAmount , int charge, MapLocationPoint location) {
        super(damageAmount, charge, location);
    }

}
