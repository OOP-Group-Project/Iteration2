package Main.Model.Skills;

import Main.Model.DirectionEnum;
import Main.Model.Map.MapLocationPoint;
import sun.misc.Queue;

/**
 * Created by AndyZhu on 12/3/2016.
 */
public class AngularEffect implements InfluenceArea {
    public Queue<MapLocationPoint> getAffectedArea(int x, int y, int length, DirectionEnum direction) {
        // the referencePoint is the point on the line
        MapLocationPoint referencePoint = new MapLocationPoint(x, y);
        Queue<MapLocationPoint> locationPointQueue = new Queue<>();

        switch (direction) {
            case Up:
                for (int i = 1; i <= length; i++) {
                    referencePoint = referencePoint.getAdjacent(direction);
                    locationPointQueue.enqueue(referencePoint);
                    switch (i) {
                        case 1:
                            break;
                        case 2:case 3:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownLeft));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownRight));
                            break;
                        case 4:case 5:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownLeft));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownLeft).getAdjacent(DirectionEnum.DownLeft));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownRight));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownRight).getAdjacent(DirectionEnum.DownRight));
                            break;
                        default:
                            System.out.println("Something's wrong with AngularEffect");
                            break;
                    }
                }
                break;

            case UpRight:
                for (int i = 1; i <= length; i++) {
                    referencePoint = referencePoint.getAdjacent(direction);
                    locationPointQueue.enqueue(referencePoint);
                    switch (i) {
                        case 1:
                            break;
                        case 2:case 3:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpLeft));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Down));
                            break;
                        case 4:case 5:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpLeft));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpLeft).getAdjacent(DirectionEnum.UpLeft));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Down));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Down).getAdjacent(DirectionEnum.Down));
                            break;
                        default:
                            System.out.println("Something's wrong with AngularEffect");
                            break;
                    }
                }
                break;

            case DownRight:
                for (int i = 1; i <= length; i++) {
                    referencePoint = referencePoint.getAdjacent(direction);
                    locationPointQueue.enqueue(referencePoint);
                    switch (i) {
                        case 1:
                            break;
                        case 2:case 3:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Up));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownLeft));
                            break;
                        case 4:case 5:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Up));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Up).getAdjacent(DirectionEnum.Up));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownLeft));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownLeft).getAdjacent(DirectionEnum.DownLeft));
                            break;
                        default:
                            System.out.println("Something's wrong with AngularEffect");
                            break;
                    }
                }
                break;

            case Down:
                for (int i = 1; i <= length; i++) {
                    referencePoint = referencePoint.getAdjacent(direction);
                    locationPointQueue.enqueue(referencePoint);
                    switch (i) {
                        case 1:
                            break;
                        case 2:case 3:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpLeft));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpRight));
                            break;
                        case 4:case 5:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpLeft));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpLeft).getAdjacent(DirectionEnum.UpLeft));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpRight));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpRight).getAdjacent(DirectionEnum.UpRight));
                            break;
                        default:
                            System.out.println("Something's wrong with AngularEffect");
                            break;
                    }
                }
                break;
            
            case DownLeft:
                for (int i = 1; i <= length; i++) {
                    referencePoint = referencePoint.getAdjacent(direction);
                    locationPointQueue.enqueue(referencePoint);
                    switch (i) {
                        case 1:
                            break;
                        case 2:case 3:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Up));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownRight));
                            break;
                        case 4:case 5:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Up));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Up).getAdjacent(DirectionEnum.Up));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownRight));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.DownRight).getAdjacent(DirectionEnum.DownRight));
                            break;
                        default:
                            System.out.println("Something's wrong with AngularEffect");
                            break;
                    }
                }
                break;

            case UpLeft:
                for (int i = 1; i <= length; i++) {
                    referencePoint = referencePoint.getAdjacent(direction);
                    locationPointQueue.enqueue(referencePoint);
                    switch (i) {
                        case 1:
                            break;
                        case 2:case 3:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Down));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpRight));
                            break;
                        case 4:case 5:
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Down));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.Down).getAdjacent(DirectionEnum.Down));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpRight));
                            locationPointQueue.enqueue(referencePoint.getAdjacent(DirectionEnum.UpRight).getAdjacent(DirectionEnum.UpRight));
                            break;
                        default:
                            System.out.println("Something's wrong with AngularEffect");
                            break;
                    }
                }
                break;


        }

        return locationPointQueue;
    }
}
