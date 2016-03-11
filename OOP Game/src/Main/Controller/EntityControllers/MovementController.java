package Main.Controller.EntityControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Map.Tile;
import Main.Model.Terrain.TerrainTypeEnum;

import java.awt.*;

/**
 * Created by johnkaufmann on 3/10/16. JFK
 * TODO:
 */
public class MovementController {

    private Map map;
    private MapLocationPoint currentPoint;
    private boolean canWalkOnWater;
    private Entity entity;

    public MovementController(Map map, Entity entity) {
        this.map = map;
        this.entity = entity;
        this.canWalkOnWater = false;
        this.currentPoint = entity.getLocation();
    }

    public void move(UserActionEnum u) {
        MapLocationPoint endPoint = entity.getLocation();
        Tile startTile = map.getTile(currentPoint.x, currentPoint.y);

        System.out.println("Movement controller being used with direction: " + u);
        switch (u) {
            case Up:
                //move endPoint
                endPoint = endPoint.getAdjacent(DirectionEnum.Up);
                //check out of bounds and check blocked
                if (checkOutOfBounds(endPoint)) {
                    if (checkBlocked(endPoint)) {
                        entity.move(DirectionEnum.Up);
                        //activateTileEffect(endPoint);
                        changeTile(startTile, map.getTile(endPoint.x, endPoint.y));
                    }
                }
                break;
            case UpLeft:
                //move endPoint
                endPoint = endPoint.getAdjacent(DirectionEnum.UpLeft);
                //check out of bounds and check blocked
                if (checkOutOfBounds(endPoint)) {
                    if (checkBlocked(endPoint)) {
                        entity.move(DirectionEnum.UpLeft);
                        //activateTileEffect(endPoint);
                        changeTile(startTile, map.getTile(endPoint.x, endPoint.y));
                    }
                }
                break;
            case UpRight:
                //move endPoint
                endPoint = endPoint.getAdjacent(DirectionEnum.UpRight);
                //check out of bounds and check blocked
                if (checkOutOfBounds(endPoint)) {
                    if (checkBlocked(endPoint)) {
                        entity.move(DirectionEnum.UpRight);
                        //activateTileEffect(endPoint);
                        changeTile(startTile, map.getTile(endPoint.x, endPoint.y));
                    }
                }
                break;
            case Down:
                //move endPoint
                endPoint = endPoint.getAdjacent(DirectionEnum.Down);
                //check out of bounds and check blocked
                if (checkOutOfBounds(endPoint)) {
                    if (checkBlocked(endPoint)) {
                        entity.move(DirectionEnum.Down);
                        //activateTileEffect(endPoint);
                        changeTile(startTile, map.getTile(endPoint.x, endPoint.y));
                    }
                }
                break;
            case DownLeft:
                //move endPoint
                endPoint = endPoint.getAdjacent(DirectionEnum.DownLeft);
                //check out of bounds and check blocked
                if (checkOutOfBounds(endPoint)) {
                    if (checkBlocked(endPoint)) {
                        entity.move(DirectionEnum.DownLeft);
                        //activateTileEffect(endPoint);
                        changeTile(startTile, map.getTile(endPoint.x, endPoint.y));
                    }
                }
                break;
            case DownRight:
                //move endPoint
                endPoint = endPoint.getAdjacent(DirectionEnum.DownRight);
                //check out of bounds and check blocked
                if (checkOutOfBounds(endPoint)) {
                    if (checkBlocked(endPoint)) {
                        entity.move(DirectionEnum.DownRight);
                        //activateTileEffect(endPoint);
                        changeTile(startTile, map.getTile(endPoint.x, endPoint.y));
                    }
                }
                break;
            default:
                System.out.println("Something went wrong with our movement in movement controller!");
        }
    }

    //changes the tile the entity is on
    private void changeTile(Tile startTile, Tile endTile) {
        startTile.removeEntity();
        endTile.addEntity(entity);
    }

    //checks to see if an index is out of bounds (JFK)
    private boolean checkOutOfBounds(MapLocationPoint endPoint) {
        //checks to see if the given endPoint is off the map
        if ((endPoint.x < map.getWidth() && endPoint.x < map.getHeight()) && (endPoint.y < map.getWidth() && endPoint.y < map.getHeight()))
            return true;
        else {
            //print statement
            System.out.println("Entity attempted to move out of bounds");
            return false;
        }
    }

    //checks to see if the tile is blocked
    private boolean checkBlocked(MapLocationPoint endPoint) {
        //check blocked
        Tile tile = map.getTile(endPoint.x, endPoint.y);
        if (tile.getEntity() == null) {
            if (tile.getTerrainType() == TerrainTypeEnum.Grass) return true;
            if (tile.getTerrainType() == TerrainTypeEnum.Water) if (canWalkOnWater) return true;
            //print statement
            System.out.println("Entity attempted to move in a tile he couldn't!");
            return false;
        } else {
            return false;
        }
    }

    //check the next tile and then depending on what it is activate the effect. (UNCOMMENT WHEN YOU NEED EFFECT)
    /*private void activateTileEffect(MapLocationPoint endPoint) {
        Tile tile = map.getTile(endPoint.x, endPoint.y);
        //check that there is an effect
        if (tile.getEffect().equals(null)) return;
        tile.getEffect().applyEffect(entity);
    }*/
}
