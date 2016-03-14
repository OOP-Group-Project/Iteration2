package Main.Model.AreaEffect;

import Main.Model.Map.MapLocationPoint;
import Main.Model.Stats.StatsModifier;

/**
 * Created by Matthew on 3/14/2016.
 */
public class Portal extends AreaEffect {

    private MapLocationPoint destination;

    public Portal(MapLocationPoint location, MapLocationPoint destination){
        super(AreaEffectEnum.PORTAL, location);
        this.destination = destination;
    }

    public MapLocationPoint getDestination() {
        return destination;
    }

}
