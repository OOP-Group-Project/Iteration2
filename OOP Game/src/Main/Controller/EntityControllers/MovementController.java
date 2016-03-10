package Main.Controller.EntityControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.Map.Tile;
import Main.Model.Terrain.TerrainTypeEnum;

import java.awt.*;

/**
 * Created by johnkaufmann on 3/10/16.
 * TODO:
 */
public class MovementController {

    private UserActionEnum dir;
    private Map map;
    private boolean canWalkOnWater;
    private Entity entity;

    public MovementController(Map map, Entity entity) {
        this.map = map;
        this.entity = entity;
        this.canWalkOnWater = false;
    }

    public void move(UserActionEnum u) {
        Point point = entity.getLocation();

        System.out.print("Movement controller being used with direction: " + u);
        switch (u) {
            case Up:
                //move point
                point.translate(-1,0);
                //check out of bounds and check blocked
                if (checkOutOfBounds(point) || checkBlocked(point)) entity.move(DirectionEnum.Up);
                break;
            case UpLeft:
                //move point
                point.translate(0,-1);
                //check out of bounds and check blocked
                if (checkOutOfBounds(point) || checkBlocked(point)) entity.move(DirectionEnum.UpLeft);
                break;
            case UpRight:
                //move point
                point.translate(0,1);
                //check out of bounds and check blocked
                if (checkOutOfBounds(point) || checkBlocked(point)) entity.move(DirectionEnum.UpRight);
                break;
            case Down:
                //move point
                point.translate(1,0);
                //check out of bounds and check blocked
                if (checkOutOfBounds(point) || checkBlocked(point)) entity.move(DirectionEnum.Down);
                break;
            case DownLeft:
                //move point
                point.translate(1,-1);
                //check out of bounds and check blocked
                if (checkOutOfBounds(point) || checkBlocked(point)) entity.move(DirectionEnum.DownLeft);
                break;
            case DownRight:
                //move point
                point.translate(1,1);
                //check out of bounds and check blocked
                if (checkOutOfBounds(point) || checkBlocked(point)) entity.move(DirectionEnum.DownRight);
                break;
            default:
                System.out.print("Something went wrong with our movement in movement controller!");
        }
    }

    //checks to see if an index is out of bounds (JFK)
    private boolean checkOutOfBounds(Point point) {
        //checks to see if the given point is off the map
        if (!(point.x > map.getWidth() || point.x < 0 || point.x > map.getHeight() || point.x < 0))
            return true;
        else {
            //print statement
            System.out.print("Entity attempted to move out of bounds");
            return false;
        }
    }

    //checks to see if the tile is blocked
    private boolean checkBlocked(Point point) {
        //check blocked
        Tile tile = map.getTile(point.x, point.y);
        if (tile.getTerrainType() == TerrainTypeEnum.Grass) return true;
        if (tile.getTerrainType() == TerrainTypeEnum.Water) if (canWalkOnWater) return true;
        //print statement
        System.out.print("Entity attempted to move in a tile he couldn't!");
        return false;
    }
}
