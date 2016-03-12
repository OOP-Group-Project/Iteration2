package Main.Model.AreaEffect;

import Main.Model.Entity.Entity;
import Main.Model.Map.MapLocationPoint;


/**
 * Created by Matthew on 3/11/2016.
 */
public class Portal extends AreaEffect {

    private MapLocationPoint mapLocationPoint;

    public Portal(int x, int y){
        super(AreaEffectEnum.Portal);
        mapLocationPoint = new MapLocationPoint(x, y);
    }

    public void applyEffect(Entity entity) {

    }

}
