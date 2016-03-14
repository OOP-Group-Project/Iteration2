package Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.ObjectController;
import Main.Controller.ObjectControllers.TimedObjectController;
import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.OccupationTypeEnum;
import Main.Model.Skills.*;
import sun.misc.Queue;

import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/13/16.
 * TODO:
 */
public class SkillsController extends ObjectController{
    Entity entity;
    Map map;
    OccupationTypeEnum occupation;
    boolean observing = false;
    ObjectController occupationSkills = null;

    public SkillsController(Entity entity, Map map) {
        this.entity = entity;
        this.map = map;
        this.occupation = entity.getOccupation().getOccupationType();
        switch(occupation) {
            case Summoner:
                occupationSkills = new SummonerController(entity, map);
                break;
            case Smasher:
                occupationSkills = new SmasherController(entity, map);
                break;
            case Sneak:
                occupationSkills = new SneakController(entity, map);
        }
    }

    public void performSkill(UserActionEnum u) {
        switch (u) {
            case Skill1:
                //Bind wounds
                BindWounds bs1 = (BindWounds) entity.getSkills().get(0);
                bs1.activate();
                break;
            case Skill2:
                //Bargain
                Bargain bs2 = (Bargain) entity.getSkills().get(1);
                double discount = bs2.activate();
                System.out.println("The price of all items to sold/purchase has been decreased/increased by " + discount);
                break;
            case Skill3:
                //Observation
                Observation bs3 = (Observation) entity.getSkills().get(2);
                if (!observing) {
                    observing = true;
                    AngularEffect ar = new AngularEffect();
                    MapLocationPoint entityLocation = entity.getLocation();
                    Queue<ArrayList<MapLocationPoint>> q = ar.getAffectedArea((int) entityLocation.getX(), (int) entityLocation.getY(), entity.getOrientation(), 4);
                    int currentRadius = 1;
                    while (!q.isEmpty()) {
                        try {
                            ArrayList<MapLocationPoint> list = q.dequeue();
                            for (MapLocationPoint targetLocation : list) {
                                if (map.getTile((int) targetLocation.getX(), (int) targetLocation.getY()).hasEntity()) {
                                    Entity target = map.getTile((int) targetLocation.getX(), (int) targetLocation.getY()).getEntity();
                                    ArrayList<String> arrString = bs3.activate(target, currentRadius);
                                    for (String str : arrString)
                                        System.out.println(str);
                                    break;
                                }
                            }
                            currentRadius++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else if (observing) {
                    //close window
                    observing = false;
                }
                break;
            case Skill4:case Skill5:case Skill6:case Skill7:
                switch (occupation) {
                    case Smasher:
                        ((SmasherController)occupationSkills).performSkill(u);
                        break;
                    case Summoner:
                        ((SummonerController)occupationSkills).performSkill(u);
                        break;
                    case Sneak:
                        ((SneakController)occupationSkills).performSkill(u);
                        break;
                    default:
                        System.out.println("Something went wrong in " + this.toString());
                        break;
                }
            break;

        }

    }

    public void update() {
        switch (occupation) {
            case Summoner:
                ((SummonerController)occupationSkills).update();
                break;
            case Sneak:
                ((SneakController)occupationSkills).update();
                break;
        }
    }
}
