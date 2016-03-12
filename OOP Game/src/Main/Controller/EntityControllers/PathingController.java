package Main.Controller.EntityControllers;

import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Heuristic;
import Main.Model.Map.Map;
import Main.Model.Map.Path;
import Main.Model.Map.PathFinder;

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


    public PathingController(Map map, Entity player, Entity NPC, Heuristic heuristic){
        this.map = map;
        this.player = player;
        this.NPC = NPC;
        this.heuristic = heuristic;
        pathFinder = new PathFinder(map,50,heuristic);
    }

    public void update(){
        path = pathFinder.findPath(NPC.getLocation().x,NPC.getLocation().y,player.getLocation().x,player.getLocation().y);
        System.out.print("path length: " + path.getLength());
        if(path != null){
            System.out.println("current position: " + NPC.getLocation().x  + " ," + NPC.getLocation().y + "nextPoint : " + path.getPoint(0));
            for(int i = 0; i < path.getLength() - 1; i++){
                System.out.println("NPC location " + NPC.getLocation());
//                try{
//                    Thread.sleep(500);
//                } catch (Exception e){
//
//                }

                NPC.move(path.getPoint(i));
            }
        }
    }
}
