package Main.Model.Skills;

import Main.Model.DirectionEnum;
import Main.Model.Map.MapLocationPoint;
import sun.misc.Queue;

/**
 * Created by AndyZhu on 12/3/2016.
 */
public class LinearEffects implements InfluenceArea {
    public Queue<MapLocationPoint> getAffectedArea(int x, int y, int length, DirectionEnum direction) {
        MapLocationPoint tempPoint;
        MapLocationPoint referencePoint;
        Queue<MapLocationPoint> locationPointQueue = new Queue<>();

        switch (direction) {

        }


        return locationPointQueue;
    }

}
