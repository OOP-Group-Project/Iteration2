package Main.Controller;

import Main.Model.DirectionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Entity.Mount;
import Main.Model.Entity.Npc;
import Main.Model.Entity.Pet;
import Main.Model.Map.Map;
import Main.Model.Map.Tile;
import Main.Model.Terrain.TerrainTypeEnum;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by johnkaufmann on 3/8/16.
 */
public class MovementController extends Controller {

    private DirectionEnum dir;
    private Map map;
    private boolean canWalkOnWater;

    public MovementController(Map world, Mount entity, boolean canWalkOnWater) {
        super(world, entity);
        this.canWalkOnWater = canWalkOnWater;
    }

    public MovementController(Map world, Avatar entity) {
        super(world, entity);
        map = world;
        this.canWalkOnWater = false;
    }

    public MovementController(Map world, Npc entity) {
        super(world, entity);
        map = world;
        this.canWalkOnWater = false;
    }

    public MovementController(Map world, Pet entity) {
        super(world, entity);
        map = world;
        this.canWalkOnWater = false;
    }

    @Override
    public void update(KeyEvent k) {
        if(k != null) {
            switch (k.getKeyCode()) {
                case KeyEvent.VK_NUMPAD8:
                    dir = DirectionEnum.Up;
                    if (validateInput()) {
                        entity.move(dir);
                    }
                    break;
                case KeyEvent.VK_UP:
                    dir = DirectionEnum.Up;
                    if (validateInput()) {
                        entity.move(dir);
                    }
                    break;
                case KeyEvent.VK_NUMPAD2:
                    dir = DirectionEnum.Down;
                    if (validateInput()) {
                        entity.move(dir);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    dir = DirectionEnum.Down;
                    if (validateInput()) {
                        entity.move(dir);
                    }
                    break;
                case KeyEvent.VK_NUMPAD9:
                    dir = DirectionEnum.UpRight;
                    if (validateInput()) {
                        entity.move(dir);
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    dir = DirectionEnum.UpRight;
                    if (validateInput()) {
                        entity.move(dir);
                    }
                    break;
                case KeyEvent.VK_NUMPAD3:
                    dir = DirectionEnum.DownRight;
                    if (validateInput()) {
                        entity.move(dir);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    dir = DirectionEnum.DownRight;
                    if (validateInput()) {
                        entity.move(dir);
                    }
                    break;
                case KeyEvent.VK_NUMPAD1:
                    dir = DirectionEnum.DownLeft;
                    if (validateInput()) {
                        entity.move(DirectionEnum.DownLeft);
                    }
                    break;
                case KeyEvent.VK_NUMPAD7:
                    dir = DirectionEnum.UpLeft;
                    if (validateInput()) {
                        entity.move(dir);
                    }
                    break;
            }
        }
    }

    @Override
    protected boolean validateInput() {
        Point point = entity.getLocation();
        switch (dir) {
            case Up:
                //move point
                point.translate(-1,0);
                //check out of bounds
                if (checkOutOfBounds(point)) {
                    return false;
                }
                //check blocked
                else if (checkBlocked(point)) {
                    return false;
                }
                else {
                    return true;
                }
                break;
            case UpLeft:
                //move point
                point.translate(0,-1);
                //check out of bounds
                if (checkOutOfBounds(point)) {
                    return false;
                }
                //check blocked
                else if (checkBlocked(point)) {
                    return false;
                }
                else {
                    return true;
                }
                break;
            case UpRight:
                //move point
                point.translate(0,1);
                //check out of bounds
                if (checkOutOfBounds(point)) {
                    return false;
                }
                //check blocked
                else if (checkBlocked(point)) {
                    return false;
                }
                else {
                    return true;
                }
                break;
            case Down:
                //move point
                point.translate(1,0);
                //check out of bounds
                if (checkOutOfBounds(point)) {
                    return false;
                }
                //check blocked
                else if (checkBlocked(point)) {
                    return false;
                }
                else {
                    return true;
                }
                break;
            case DownLeft:
                //move point
                point.translate(1,-1);
                //check out of bounds
                if (checkOutOfBounds(point)) {
                    return false;
                }
                //check blocked
                else if (checkBlocked(point)) {
                    return false;
                }
                else {
                    return true;
                }
                break;
            case DownRight:
                //move point
                point.translate(1,1);
                //check out of bounds
                if (checkOutOfBounds(point)) {
                    return false;
                }
                //check blocked
                else if (checkBlocked(point)) {
                    return false;
                }
                else {
                    return true;
                }
                break;
        }
    }

    //checks to see if an index is out of bounds (JFK)
    private boolean checkOutOfBounds(Point point) {
        //checks to see if the given point is off the map
        if (point.getX() > map.getWidth() || point.getX() < 0 || point.getY() > map.getHeight() || point.getY() < 0) {
            return false;
        }
        else {
            return true;
        }
    }

    //checks to see if the tile is blocked
    private boolean checkBlocked(Point point) {
        //check blocked
        Tile tile = map.getTile(point);
        if (tile.getTerrainType() == TerrainTypeEnum.Grass) {
            return true;
        }
        else if (tile.getTerrainType() == TerrainTypeEnum.Water && canWalkOnWater) {
            return true;
        }
        else {
            return false;
        }
    }

}
