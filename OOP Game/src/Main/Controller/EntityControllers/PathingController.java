package Main.Controller.EntityControllers;

import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Michael on 3/12/16.
 */
public class PathingController {

    private Map map;
    private Entity player;
    private Entity NPC;
    private PathFinder pathFinder;
    private Path path;
    private Heuristic heuristic;


    public PathingController(Map map, Entity player, Entity NPC, Heuristic heuristic) {
        this.map = map;
        this.player = player;
        this.NPC = NPC;
        this.heuristic = heuristic;
        pathFinder = new PathFinder(map, 5, heuristic);
    }

    public void update() {
        path = pathFinder.findPath(NPC.getLocation().x, NPC.getLocation().y, player.getLocation().x, player.getLocation().y);
//        System.out.print("path length: " + path.getLength());
        if (path != null) {
            for (int i = 0; i < path.getLength() - 1; i++) {
                System.out.println("current position: " + path.getPoint(i) + "nextPoint : " + path.getPoint(i+1));
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                System.out.println(map.getTile(path.getPoint(i).x,path.getPoint(i).y).getTerrainType());
                map.getTile(path.getPoint(i).x, path.getPoint(i).y).removeEntity();
                pathToDirection(path.getPoint(i),path.getPoint(i+1));
                map.getTile(path.getPoint(i+1).x, path.getPoint(i+1).y).addEntity(NPC);
            }
        }
    }


    private void pathToDirection(MapLocationPoint  currentPoint, MapLocationPoint nextPoint) {
        int x1 = currentPoint.x;
        int y1 = currentPoint.y;

        // Next position
        int x2 = nextPoint.x;
        int y2 = nextPoint.y;

        pointToEnum(x1, x2, y1, y2);
    }

    private void pointToEnum(int x1, int x2, int y1, int y2) {

        // For all odd cases of X
        // X positions are equal, check for y
        if (x1 % 2 == 0){
            if (x1 == x2) {
                if (y1 > y2) {
                    NPC.move(DirectionEnum.Up);
                }
                if (y1 < y2) {
                    NPC.move(DirectionEnum.Down);
                }
            } else if (y1 == y2) { // Y position are equal, check for x
                if (x1 > x2) {
                    NPC.move(DirectionEnum.DownLeft);
                }
                if (x1 < x2) {
                    NPC.move(DirectionEnum.DownRight);
                }
            } else { // Neither Y nor X are equal, check X equivalents
                if (x1 > x2) {
                    NPC.move(DirectionEnum.UpLeft);
                }
                if (x1 < x2) {
                    NPC.move(DirectionEnum.UpRight);
                }
            }
        } else { // Odd cases
            if (x1 == x2) {
                if (y1 > y2) {
                     NPC.move(DirectionEnum.Up);
                }
                if (y1 < y2) {
                    NPC.move(DirectionEnum.Down);
                }
            } else if (y1 == y2) {
                if (x1 > x2) {
                    NPC.move(DirectionEnum.UpLeft);
                }
                if (x1 < x2) {
                    NPC.move(DirectionEnum.UpRight);
                }
            } else { // Neither Y nor X are equal, check X equivalents
                if (x1 > x2) {
                    NPC.move(DirectionEnum.DownLeft);
                }
                if (x1 < x2) {
                    NPC.move(DirectionEnum.DownRight);
                }
            }
        }
    }
}
