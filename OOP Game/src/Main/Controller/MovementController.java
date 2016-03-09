package Main.Controller;

import Main.Model.DirectionEnum;
import Main.Model.Entity.Avatar;
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

    public MovementController(Map world, Avatar entity) {
        super(world, entity);
    }

    public MovementController(Map world, Npc entity) {
        super(world, entity);
    }

    public MovementController(Map world, Pet entity) {
        super(world, entity);
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
        Tile tile;
        switch (dir) {
            case DirectionEnum.:
                tile = map.getTile(point.move(x,y));
                if (tile.getTerrainType() == TerrainTypeEnum.Grass) {
                    return true;
                }
                else { return false; }
                break;
        }
    }

}
