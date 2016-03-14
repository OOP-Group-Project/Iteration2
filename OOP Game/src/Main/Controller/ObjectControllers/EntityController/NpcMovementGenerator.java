package Main.Controller.ObjectControllers.EntityController;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Map.*;

/**
 * Created by Michael on 3/12/16.
 */
public class NpcMovementGenerator {

    private Map map;
    private MapLocationPoint currentTargetLocation;
    private MapLocationPoint followedEntityLocation;
    private Entity followerEntity;
    private PathFinder pathFinder;
    private Path path;
    private int currentPathPosition = 0;

    /* The pathing controller determines the path for a followerEntity to take. Currently, it takes the followerEntity's level and directly
     translates it to a 1:1 search radius. For example, If Pet is of level 2 then it searches a radius of 2 for enemies.
    */
    public NpcMovementGenerator(Map map, Entity followedEntity , Entity followerEntity, Heuristic heuristic) {
        this.map = map;
        this.followerEntity = followerEntity;
        this.followedEntityLocation = followedEntity.getLocation();
        this.currentTargetLocation = new MapLocationPoint(followedEntityLocation.x, followedEntityLocation.y);
        this.pathFinder = new PathFinder(map, 1/*followerEntity.getStats().getLevel()*/, heuristic);
        this.path = pathFinder.findPath(followerEntity.getLocation().x, followerEntity.getLocation().y,  currentTargetLocation.x, currentTargetLocation.y);

    }

    public void update() {
        // Determines what the followerEntity should set as its currentTargetLocation
//        determineTarget(followerEntity.getType());

        // Gets the path from an followerEntity to targetEntity
        if((currentTargetLocation.x != followedEntityLocation.x || currentTargetLocation.y != followedEntityLocation.y)) {
            path = pathFinder.findPath(followerEntity.getLocation().x, followerEntity.getLocation().y,  currentTargetLocation.x, currentTargetLocation.y);
            currentPathPosition = 0;
            currentTargetLocation.x = followedEntityLocation.x;
            currentTargetLocation.y = followedEntityLocation.y;
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
                this.currentTargetLocation = map.getPlayerLocation();
            }
        }

    }

    private void findMinimum(){
        // for all npcs on the map, find the shortest distance and then go attack that
    }

    public UserActionEnum getNextMovement(){
        if(path != null) {
            return pointToEnum(path.getPoint(currentPathPosition), path.getPoint(currentPathPosition+1));
        }
        else {
            return null;
        }
    }

    private UserActionEnum pointToEnum(MapLocationPoint currentPoint, MapLocationPoint adjacentPoint) {
        int x1 = currentPoint.x;
        int y1 = currentPoint.y;
        int x2 = adjacentPoint.x;
        int y2 = adjacentPoint.y;
        // For all even cases of X
        // X positions are equal, check for y
        if (x1 % 2 == 0){
            if (x1 == x2) {
                if (y1 > y2) {
                    //followerEntity.move(DirectionEnum.Up);
                    return UserActionEnum.Up;
                }
                if (y1 < y2) {
                    //followerEntity.move(DirectionEnum.Down);
                    return UserActionEnum.Down;
                }
            } else if (y1 == y2) { // Y position are equal, check for x
                if (x1 > x2) {
                    //followerEntity.move(DirectionEnum.DownLeft);
                    return UserActionEnum.DownLeft;
                }
                if (x1 < x2) {
                    //followerEntity.move(DirectionEnum.DownRight);
                    return UserActionEnum.DownRight;
                }
            } else { // Neither Y nor X are equal, check X equivalents
                if (x1 > x2) {
                    //followerEntity.move(DirectionEnum.UpLeft);
                    return UserActionEnum.UpLeft;
                }
                if (x1 < x2) {
                    //followerEntity.move(DirectionEnum.UpRight);
                    return UserActionEnum.UpRight;
                }
            }
        } else { // Odd cases
            if (x1 == x2) {
                if (y1 > y2) {
                     //followerEntity.move(DirectionEnum.Up);
                    return UserActionEnum.Up;
                }
                if (y1 < y2) {
                   // followerEntity.move(DirectionEnum.Down);
                    return UserActionEnum.Down;
                }
            } else if (y1 == y2) {
                if (x1 > x2) {
                    //followerEntity.move(DirectionEnum.UpLeft);
                    return UserActionEnum.UpLeft;
                }
                if (x1 < x2) {
                    //followerEntity.move(DirectionEnum.UpRight);
                    return UserActionEnum.UpRight;
                }
            } else { // Neither Y nor X are equal, check X equivalents
                if (x1 > x2) {
                    //followerEntity.move(DirectionEnum.DownLeft);
                    return UserActionEnum.DownLeft;
                }
                if (x1 < x2) {
                    //followerEntity.move(DirectionEnum.DownRight);
                    return UserActionEnum.DownRight;
                }
            }
        }
        return null;
    }
}
