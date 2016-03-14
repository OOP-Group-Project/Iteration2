package Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.TimedObjectController;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;

import Main.Model.Map.MapLocationPoint;
import Main.Model.Map.Tile;
import Main.Model.Skills.*;
import Main.Model.Stats.StatsModifier;
import sun.misc.Queue;

/**
 * Created by johnkaufmann on 3/13/16.
 * TODO:
 */
public class SummonerController extends TimedObjectController{
    Entity summoner;
    Entity enemy;
    Map map;
    MapLocationPoint targetLocation;
    Tile targetTile;
    StatsModifier sm;
    UserActionEnum skill;
    Enchantment ec = (Enchantment) summoner.getSkills().get(3);
    Boon boon = (Boon) summoner.getSkills().get(4);
    Bane bane = (Bane) summoner.getSkills().get(5);
    Staff staff = (Staff) summoner.getSkills().get(6);
    private boolean boonActivated = false;

    public SummonerController(Entity summoner, Map map) {
        this.summoner = summoner;
        this.map = map;
    }

    public void performSkill(UserActionEnum u) {
        switch (u) {
            case Skill4:
                targetLocation = summoner.getLocation().getAdjacent(summoner.getOrientation());
                targetTile = map.getTile((int)targetLocation.getX(), (int)targetLocation.getY());
                if (targetTile.hasEntity()) {
                    enemy = targetTile.getEntity();
                    sm = ec.activate();
                    enemy.getStats().modifyStats(sm);
                }
                else {
                    System.out.println("not target found");
                    //TODO: and do something?
                }
                break;
            case Skill5:
                if(!boonActivated) {
                    // Calculate how long boon should last
                    timer.start((int)boon.getDuration());
                    sm = boon.activate();
                    summoner.getStats().buff(sm);
                    boonActivated = true;
                }
                break;
            case Skill6:
                MapLocationPoint origin = summoner.getLocation();
                LinearEffect le = new LinearEffect();
                Queue<MapLocationPoint> q = le.getAffectedArea((int) origin.getX(), (int) origin.getY(), bane.getLevel() / 2 + 1, summoner.getOrientation());
                while (!q.isEmpty()) {
                    try {
                        targetLocation = q.dequeue();
                        targetTile = map.getTile((int)targetLocation.getX(), (int) targetLocation.getY());
                        if (targetTile.hasEntity()) {
                            enemy = targetTile.getEntity();
                            sm = bane.activate();
                            enemy.getStats().modifyStats(sm);
                            break;
                        }
                        else {
                            System.out.println("not target found");
                            //TODO: and do something?
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case Skill7:
                targetLocation = summoner.getLocation().getAdjacent(summoner.getOrientation());
                targetTile = map.getTile((int)targetLocation.getX(), (int)targetLocation.getY());
                if (targetTile.hasEntity()) {
                    enemy = targetTile.getEntity();
                    sm = staff.activate();
                    enemy.getStats().modifyStats(sm);
                }
                else {
                    System.out.println("not target found");
                    //TODO: and do something?
                }
                break;
            default:
                System.out.print("Something went wrong in" + this.toString());
        }
    }


    @Override
    public void update() {
        timer.tick();
        if(timer.isExpired() && boonActivated) {
            summoner.getStats().revert();
            boonActivated = false;
        }
    }
}
