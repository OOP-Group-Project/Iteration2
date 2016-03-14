package Main.Model.State;

import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;

/**
 * Created by mason on 3/13/16.
 */
public class ObservationState extends State {
    private Entity observedEntity;
    private Map world;
    private MapLocationPoint centerPoint;

    public ObservationState(Map world) {
        this.world = world;
        this.centerPoint = new MapLocationPoint(0,0);
    }

    public void init(MapLocationPoint observationStartPoint) {
        centerPoint = observationStartPoint;
    }

    public Entity getObservedEntity() {
        return observedEntity;
    }

    public MapLocationPoint getCenterPoint() {
        return centerPoint;
    }

    public Map getWorld() {
        return world;
    }

    public void moveCenterPoint(DirectionEnum direction) {
        centerPoint.move(direction);
    }


}
