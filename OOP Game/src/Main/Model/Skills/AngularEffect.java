package Main.Model.Skills;

import Main.Model.DirectionEnum;
import Main.Model.Map.MapLocationPoint;
import sun.misc.Queue;

import java.util.ArrayList;


/**
 * Created by AndyZhu on 12/3/2016.
 *
 */

public class AngularEffect implements InfluenceArea {
    /* user manual
    AngularEffect ar = new AngularEffect();
    Queue<ArrayList<MapLocationPoint>> q = ar.getAffectedArea(5,4, DirectionEnum.Down, 4);
    int currentRadius = 1;
    while (!q.isEmpty()) {
        try {
            ArrayList<MapLocationPoint> list = q.dequeue();
            System.out.println("Radius: " + currentRadius++);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getX() + ", " + list.get(i).getY());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
    public Queue<ArrayList<MapLocationPoint>> getAffectedArea(int x, int y, DirectionEnum direction, int effectedRadius) {
        MapLocationPoint origin = new MapLocationPoint(x, y);
        DirectionEnum[] expansions = findExpansion(direction);
        MapLocationPoint point = origin;
        Queue<ArrayList<MapLocationPoint>> q = new Queue<>();
        for (int i = 1; i <= effectedRadius; i++) {
            ArrayList<MapLocationPoint> list = new ArrayList<>();
            //apply effect to the point you moved to then expand out
            point = point.getAdjacent(direction);
            list.add(point);
            //set up for expansion on both sides
            MapLocationPoint leftSide = point;
            MapLocationPoint rightSide = point;
            //if even then expand out i/2 in both directions
            //if odd expand out i/2 (truncated) in both directions
            for (int j = 0; j < Math.floor(i/2); j++) {
                leftSide = leftSide.getAdjacent(expansions[0]);
                rightSide = rightSide.getAdjacent(expansions[1]);
                list.add(leftSide);
                list.add(rightSide);
            }
            q.enqueue(list);
        }
        return q;
    }

    private static DirectionEnum[] findExpansion(DirectionEnum direction) {

        DirectionEnum[] expansions = new DirectionEnum[2];
        switch (direction) {
            case Up:
                expansions[0] = DirectionEnum.DownLeft;
                expansions[1] = DirectionEnum.DownRight;
                break;
            case Down:
                expansions[0] = DirectionEnum.UpLeft;
                expansions[1] = DirectionEnum.UpRight;
                break;
            case UpLeft:
                expansions[0] = DirectionEnum.Down;
                expansions[1] = DirectionEnum.UpRight;
                break;
            case DownRight:
                expansions[0] = DirectionEnum.Up;
                expansions[1] = DirectionEnum.DownLeft;
                break;
            case UpRight:
                expansions[0] = DirectionEnum.UpLeft;
                expansions[1] = DirectionEnum.Down;
                break;
            case DownLeft:
                expansions[0] = DirectionEnum.Up;
                expansions[1] = DirectionEnum.DownRight;
                break;
        }
        return expansions;
    }

}
