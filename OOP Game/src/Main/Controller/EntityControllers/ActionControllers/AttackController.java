package Main.Controller.EntityControllers.ActionControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.AreaEffect.TakeDamage;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Skills.AngularEffect;
import Main.Model.Skills.RadialEffect;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by johnkaufmann on 3/12/16.
 * TODO:
 */
public class AttackController {
    private Entity entity;
    private Map map;
    private MapLocationPoint point;
    private DirectionEnum orientation;

    public AttackController(Map map, Entity entity) {
        this.entity = entity;
        this.map = map;
    }

    // gets the tile the attack is performed on and applys the area effect
    public void performMeleeAttack() {
        point = entity.getLocation().getAdjacent(entity.getOrientation());
        applyEffect(point);
    }

    //searchs for an NPC and applies an area effect on the first tile the npc is found on
    public void performRangeAttack() {
        orientation = entity.getOrientation();
        point = entity.getLocation().getAdjacent(orientation);
        while (map.getTile(point.x,point.y).getEntity() == null) point = point.getAdjacent(orientation);
        applyEffect(point);
    }

    public void performAngularAttack(int effectedRadius) {
        point = entity.getLocation();
        orientation = entity.getOrientation();
        sun.misc.Queue<MapLocationPoint> q = new AngularEffect().getAffectedArea(point.x, point.y, effectedRadius, orientation);
        while (!q.isEmpty()) {
            try {
                applyEffect(q.dequeue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public void performAngularAttack(int effectedRadius) {
//        orientation = entity.getOrientation();
//        point = entity.getLocation().getAdjacent(orientation);
//        DirectionEnum[] expansions = findExpansion();
//        for (int i = 1; i < effectedRadius; i++) {
//            //apply effect to the point you moved to then expand out
//            applyEffect(point);
//
//            //set up for expansion on both sides
//            MapLocationPoint leftSide = point;
//            MapLocationPoint rightSide = point;
//
//            //if even then expand out i/2 in both directions
//            //if odd expand out i/2 (truncated) in both directions
//            for (int j = 0; j < i/2; j++) {
//                leftSide = leftSide.getAdjacent(expansions[0]);
//                rightSide = rightSide.getAdjacent(expansions[1]);
//                applyEffect(leftSide);
//                applyEffect(rightSide);
//            }
//
//            //move to the next radius
//            point = point.getAdjacent(orientation);
//        }
//    }
//
//    private DirectionEnum[] findExpansion() {
//        orientation = entity.getOrientation();
//        DirectionEnum[] expansions = new DirectionEnum[2];
//        switch (orientation) {
//            case Up:
//                expansions[0] = DirectionEnum.DownLeft;
//                expansions[1] = DirectionEnum.DownRight;
//                break;
//            case Down:
//                expansions[0] = DirectionEnum.UpLeft;
//                expansions[1] = DirectionEnum.UpRight;
//                break;
//            case UpLeft:
//                expansions[0] = DirectionEnum.Down;
//                expansions[1] = DirectionEnum.UpRight;
//                break;
//            case DownRight:
//                expansions[0] = DirectionEnum.Up;
//                expansions[1] = DirectionEnum.DownLeft;
//                break;
//            case UpRight:
//                expansions[0] = DirectionEnum.UpLeft;
//                expansions[1] = DirectionEnum.Down;
//                break;
//            case DownLeft:
//                expansions[0] = DirectionEnum.Up;
//                expansions[1] = DirectionEnum.DownRight;
//                break;
//        }
//        return expansions;
//    }

    public void performRadiusAttack(int radius) {
        point = entity.getLocation();

        sun.misc.Queue<ArrayList<MapLocationPoint>> q = new RadialEffect().getAffectedArea(point.x, point.y, radius);
        int currentRadius = 1;
        while (!q.isEmpty()) {
            //System.out.println("Radius: " + currentRadius++);
            try {
                ArrayList<MapLocationPoint> current = q.dequeue();
                int size = current.size();
                for (int i = 0; i < size; i++) {
                    //Actions
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void applyEffect(MapLocationPoint point) {
        map.getTile(point.x,point.y).addAreaEffect(new TakeDamage());
    }

    // TODO: 3/13/16 implment spells
    public void performSpell(UserActionEnum u) {
        //perform fire spell

        //perform earth spell

        //perform wind spell
    }
}
