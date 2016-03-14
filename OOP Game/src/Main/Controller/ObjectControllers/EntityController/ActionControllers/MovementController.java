package Main.Controller.ObjectControllers.EntityController.ActionControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.TimedObjectController;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Map.Tile;
import Main.Model.Terrain.TerrainTypeEnum;

/**
 * Created by johnkaufmann on 3/10/16. JFK
 * TODO:
 */
public class MovementController extends TimedObjectController{

    private Map map;
    private MapLocationPoint currentPoint;
    private boolean canWalkOnWater;
    private boolean canTravelOverMountains;
    private Entity entity;

    public MovementController(Map map, Entity entity) {
        this.map = map;
        this.entity = entity;
        this.currentPoint = entity.getLocation();

        // TODO: check the entity's occupation to determine if they can walk on water.
        this.canTravelOverMountains = false;
        this.canWalkOnWater = false;
    }

    public void move(UserActionEnum u) {
        if(!entity.isMoving()) {
            /*****************************
             * If the entity isn't moving, tell it that it's moving
             *****************************/
            entity.setMoving(true);
            //System.out.println("Entity is moving");

            /*****************************
             * Set the the movement timer to start ticking (When it expires, it'll tell the entity that it's stopped moving.)
             *****************************/
            // Calculate how fast the entity moves
            int speedInMs = 200;

            // Timer will allow the number of milliseconds passed as an argument elapse before saying that the entity is no longer moving.
            timer.start(speedInMs);

            /*****************************
             * Do our movement
             *****************************/
            MapLocationPoint endPoint = entity.getLocation();
            Tile startTile = map.getTile(entity.getLocation().x, entity.getLocation().y);

            //System.out.println("Movement controller being used with direction: " + u);
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
                    entity.setOrientation(DirectionEnum.Up);
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
                    entity.setOrientation(DirectionEnum.UpLeft);
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
                    entity.setOrientation(DirectionEnum.UpRight);
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
                    entity.setOrientation(DirectionEnum.Down);
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
                    entity.setOrientation(DirectionEnum.DownLeft);
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
                    entity.setOrientation(DirectionEnum.DownRight);
                    break;
                default:
                    System.out.println("Something went wrong with our movement in movement controller!");
            }
        }
        if (entity.getType() == EntityTypeEnum.Avatar){
            map.setPlayerLocation(entity.getLocation());
        }
    }

    /*****************************
     * This method updates the timer.  WHen the timer expires, tell the entity that it's stopped moving.
     *****************************/
    @Override
    public void update() {
        super.update();
        if(timer.isExpired() && entity.isMoving()) {
            //System.out.println("Entity has finished moving");
            entity.setMoving(false);
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
        if ((endPoint.x < map.getWidth() && endPoint.x >= 0) && (endPoint.y >= 0 && endPoint.y < map.getHeight()))
            return true;
        else {
            //print statement
            System.out.println("Entity attempted to move out of bounds");
            return false;
        }
    }

    //checks to see if the tile is blocked
    public boolean checkBlocked(MapLocationPoint endPoint) {
        //check blocked
        if(checkOutOfBounds(endPoint)) {
            Tile endpointTile = map.getTile(endPoint.x, endPoint.y);
            if (endpointTile.getEntity() == null) {
                if (endpointTile.getTerrainType() == TerrainTypeEnum.Grass) return true;
                if (endpointTile.getTerrainType() == TerrainTypeEnum.Water) if (canWalkOnWater) return true;
                if (endpointTile.getTerrainType() == TerrainTypeEnum.Mountain) if (canTravelOverMountains) return true;
                //print statement
                System.out.println("Entity attempted to move in a tile he couldn't!");
                return false;
            }
        }
        return false;

    }

    //check the next tile and then depending on what it is activate the effect. (UNCOMMENT WHEN YOU NEED EFFECT)
    /*private void activateTileEffect(MapLocationPoint endPoint) {
        Tile tile = map.getTile(endPoint.x, endPoint.y);
        //check that there is an effect
        if (tile.getEffect().equals(null)) return;
        tile.getEffect().applyEffect(entity);
    }*/
}
