package Main.Controller.EntityControllers;

import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Map.*;
import Main.Model.Skills.RadialEffect;

import java.util.ArrayList;

/**
 * Created by Michael on 3/12/16.
 */
public class NpcMovementController {

    private Map map;
    private MapLocationPoint target;
    private Entity sourceEntity;
    private PathFinder pathFinder;
    private Path path;
    private ArrayList<Entity> entityLocations;

    /* The pathing controller determines the path for a sourceEntity to take. Currently, it takes the sourceEntity's level and directly
     translates it to a 1:1 search radius. For example, If Pet is of level 2 then it searches a radius of 2 for enemies.
    */
    public NpcMovementController(Map map ,Entity sourceEntity, Heuristic heuristic) {
        this.map = map;
        this.sourceEntity = sourceEntity;
        this.target = map.getPlayerLocation();
        pathFinder = new PathFinder(map, sourceEntity.getStats().getLevel(), heuristic);
    }

    public void update() {
        // Determines what the sourceEntity should set as its target
        target = determineTarget(sourceEntity.getType());


        //check if the pet is by the enemy

        // Check for any null cases
        if (target != null) {
            // Gets the path from an sourceEntity to targetEntity
            path = pathFinder.findPath(sourceEntity.getLocation().x, sourceEntity.getLocation().y, target.getLocation().x, target.getLocation().y);
            if (path != null) {
                for (int i = 0; i < path.getLength() - 2; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    moveTowardsTarget(i);
                }
            }
        }
    }

    private MapLocationPoint determineTarget(EntityTypeEnum e){
//        System.out.println("E type: " + e);
        if (e == EntityTypeEnum.NPC){
            if (map.getPlayerLocation() != null){
                target = map.getPlayerLocation();
                return target;
            }
        }
        if (e == EntityTypeEnum.Pet){
            // Search the radius around a pet for an npc
            searchRadius();

            // There are no NPCs in radius, set Player as target
            if(entityLocations.size() == 0){
                target = map.getPlayerLocation();
                return target;

            // There are NPCs, find the closest NPC and attack
            } else {
//                System.out.println("There are mobs");
               target = findMinimum(sourceEntity.getLocation().x, sourceEntity.getLocation().y,entityLocations);
                return target;
            }
        }
        return null;
    }

    // Search a radius equal to the aggro range for Entities
    private void searchRadius(){
        entityLocations = new ArrayList<>();
        sun.misc.Queue<MapLocationPoint> q = new RadialEffect().getAffectedArea(sourceEntity.getLocation().x, sourceEntity.getLocation().y, sourceEntity.getStats().getLevel()/2);
        while(!q.isEmpty()){
            try{
                MapLocationPoint temp;
                temp = q.dequeue();
                if (map.getTile(temp.x,temp.y).getEntity().getType() == EntityTypeEnum.NPC){
                    entityLocations.add(map.getTile(temp.x,temp.y).getEntity());
                }
            } catch (Exception e){
                //
            }
        }
    }

    private MapLocationPoint findMinimum(int sx,int sy,ArrayList<Entity> entityLocations){
        // for all npcs on the map, find the shortest distance and then go attack that
        int temp;
        int minimum = 100;
        int j = 0;

        for(int i = 0; i < entityLocations.size(); i++){
            MapLocationPoint point = entityLocations.get(i).getLocation();
//            System.out.println(entityLocations.get(i).getLocation());
            temp = (int)pathFinder.getHeuristicCost(sx, sy, point.x, point.y);
            if (temp < minimum){
                minimum = temp;
                j = i;
            }
        }

        return entityLocations.get(j).getLocation();
    }

    private void moveTowardsTarget(int i){
        map.getTile(path.getPoint(i).x, path.getPoint(i).y).removeEntity();
        moveInDirection(path.getPoint(i),path.getPoint(i+1));
        map.getTile(path.getPoint(i+1).x, path.getPoint(i+1).y).addEntity(sourceEntity);
    }

    // Refactor to make more sense

    private void moveInDirection(MapLocationPoint  currentPoint, MapLocationPoint nextPoint) {
        int x1 = currentPoint.x;
        int y1 = currentPoint.y;

        // Next position
        int x2 = nextPoint.x;
        int y2 = nextPoint.y;

        pointToEnum(x1, x2, y1, y2);
    }

    private void pointToEnum(int x1, int x2, int y1, int y2) {
        // For all even cases of X
        // X positions are equal, check for y
        if (x1 % 2 == 0){
            if (x1 == x2) {
                if (y1 > y2) {
                    sourceEntity.move(DirectionEnum.Up);
                }
                if (y1 < y2) {
                    sourceEntity.move(DirectionEnum.Down);
                }
            } else if (y1 == y2) { // Y position are equal, check for x
                if (x1 > x2) {
                    sourceEntity.move(DirectionEnum.DownLeft);
                }
                if (x1 < x2) {
                    sourceEntity.move(DirectionEnum.DownRight);
                }
            } else { // Neither Y nor X are equal, check X equivalents
                if (x1 > x2) {
                    sourceEntity.move(DirectionEnum.UpLeft);
                }
                if (x1 < x2) {
                    sourceEntity.move(DirectionEnum.UpRight);
                }
            }
        } else { // Odd cases
            if (x1 == x2) {
                if (y1 > y2) {
                     sourceEntity.move(DirectionEnum.Up);
                }
                if (y1 < y2) {
                    sourceEntity.move(DirectionEnum.Down);
                }
            } else if (y1 == y2) {
                if (x1 > x2) {
                    sourceEntity.move(DirectionEnum.UpLeft);
                }
                if (x1 < x2) {
                    sourceEntity.move(DirectionEnum.UpRight);
                }
            } else { // Neither Y nor X are equal, check X equivalents
                if (x1 > x2) {
                    sourceEntity.move(DirectionEnum.DownLeft);
                }
                if (x1 < x2) {
                    sourceEntity.move(DirectionEnum.DownRight);
                }
            }
        }
    }
}
