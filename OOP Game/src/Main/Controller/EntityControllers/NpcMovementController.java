package Main.Controller.EntityControllers;

import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Map.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Michael on 3/12/16.
 */
public class NpcMovementController {

    private Map map;
    private MapLocationPoint target;
    private Entity sourceEntity;
    private PathFinder pathFinder;
    private Path path;

    /* The pathing controller determines the path for a sourceEntity to take. Currently, it takes the sourceEntity's level and directly
     translates it to a 1:1 search radius. For example, If Pet is of level 2 then it searches a radius of 2 for enemies.
    */
    public NpcMovementController(Map map, Entity entity ,Entity sourceEntity, Heuristic heuristic) {
        this.map = map;
        this.sourceEntity = sourceEntity;
        this.target = entity.getLocation();
        pathFinder = new PathFinder(map, sourceEntity.getStats().getLevel(), heuristic);
    }

    public void update() {
        // Determines what the sourceEntity should set as its target
//        determineTarget(sourceEntity.getType());

        // Gets the path from an sourceEntity to targetEntity
        path = pathFinder.findPath(sourceEntity.getLocation().x, sourceEntity.getLocation().y,  target.getLocation().x, target.getLocation().y);
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

    private void determineTarget(EntityTypeEnum e){
//        MapLocationPoint targetLocation;

//        System.out.println(e);
//        if (e == EntityTypeEnum.Avatar){
//
//        }

        if (e == EntityTypeEnum.Pet){
            //search for enemy
            // if in range, go
            // else stay
        }
        if (e == EntityTypeEnum.NPC){
            if (map.getPlayerLocation() != null){
                this.target = map.getPlayerLocation();
            }
        }

    }

    private void findMinimum(){
        // for all npcs on the map, find the shortest distance and then go attack that
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
