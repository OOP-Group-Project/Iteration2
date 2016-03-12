package Main.Model.Skills;

import Main.Model.DirectionEnum;
import Main.Model.Map.MapLocationPoint;
import sun.misc.*;

/**
 * Created by AndyZhu on 7/3/2016.
 *
 * Hey visitor, for radial effects, I store the MapLocationPoint(s) of affected tiles to a Queue
 * When use, just dequeue everything in the queue.
 * TODO: do we need to further extend it to include the distance of a single point to the origin?
 */
public class RadialEffect implements InfluenceArea {

    public Queue<MapLocationPoint> getAffectedArea(int x, int y, int radius) {

        MapLocationPoint tempPoint;
        MapLocationPoint upPoint;
        Queue<MapLocationPoint> locationPointQueue = new Queue<>();

        //loop from (radius = 1) to (radius = radius).
        for (int i = 1; i <= radius; i++) {
            upPoint = new MapLocationPoint(x, y - i);
            tempPoint = upPoint;

            //loop from Up (j = 0) -> UpRight 1 -> DownRight 2 -> Down 3 -> DownLeft 4 -> UpLeft 5
            for (int j = 0; j < 6; j++) {
                //switch statement decides the direction
                switch (j) {
                    case 0:
                        //these loops actually add the location of affected tiles to the queue
                        for (int k = 0; k < i; k++) {
                            tempPoint = tempPoint.getAdjacent(DirectionEnum.DownRight);
                            //TODO: add constraints for the other boundaries
                            if (tempPoint.getX()>=0 && tempPoint.getY() >= 0)
                                locationPointQueue.enqueue(tempPoint);
                        }
                        break;
                    case 1:
                        for (int k = 0; k < i; k++) {
                            tempPoint = tempPoint.getAdjacent(DirectionEnum.Down);
                            if (tempPoint.getX()>=0 && tempPoint.getY() >= 0)
                                locationPointQueue.enqueue(tempPoint);
                        }
                        break;
                    case 2:
                        for (int k = 0; k < i; k++) {
                            tempPoint = tempPoint.getAdjacent(DirectionEnum.DownLeft);
                            if (tempPoint.getX()>=0 && tempPoint.getY() >= 0)
                                locationPointQueue.enqueue(tempPoint);
                        }
                        break;
                    case 3:
                        for (int k = 0; k < i; k++) {
                            tempPoint = tempPoint.getAdjacent(DirectionEnum.UpLeft);
                            if (tempPoint.getX()>=0 && tempPoint.getY() >= 0)
                                locationPointQueue.enqueue(tempPoint);
                        }
                        break;
                    case 4:
                        for (int k = 0; k < i; k++) {
                            tempPoint = tempPoint.getAdjacent(DirectionEnum.Up);
                            if (tempPoint.getX()>=0 && tempPoint.getY() >= 0)
                                locationPointQueue.enqueue(tempPoint);
                        }
                        break;
                    case 5:
                        for (int k = 0; k < i; k++) {
                            tempPoint = tempPoint.getAdjacent(DirectionEnum.UpRight);
                            if (tempPoint.getX()>=0 && tempPoint.getY() >= 0)
                                locationPointQueue.enqueue(tempPoint);
                        }
                        break;
                    default:
                        System.out.println("Something is wrong with your Hexagon-search");
                        break;
                }
            }
        }
        return locationPointQueue;
    }
}
