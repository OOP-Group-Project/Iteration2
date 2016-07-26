package Main.Model.Skills;

import Main.Model.DirectionEnum;
import Main.Model.Map.MapLocationPoint;
import sun.misc.Queue;

/**
 * Created by AndyZhu on 12/3/2016.
 */
public class LinearEffect implements InfluenceArea {
    public Queue<MapLocationPoint> getAffectedArea(int x, int y, int length, DirectionEnum direction) {
        MapLocationPoint tempPoint = new MapLocationPoint(x, y);

        Queue<MapLocationPoint> locationPointQueue = new Queue<>();

        for (int i = 1; i <= length; i++) {
            tempPoint = tempPoint.getAdjacent(direction);
            locationPointQueue.enqueue(tempPoint);
        }

        return locationPointQueue;
    }
}
