package Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Items.WeaponTypeEnum;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Map.Tile;
import Main.Model.Skills.*;
import Main.Model.Stats.StatsModifier;
import sun.misc.Queue;

import java.lang.annotation.Target;
import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/13/16.
 * TODO:
 */
public class SmasherController {
    Entity entity;
    Entity enemy;
    Map map;

    public SmasherController(Entity entity, Map map) {
        this.entity = entity;
        this.map = map;
    }

    public void performSkill(UserActionEnum u) {
        switch (u) {
            case Skill4:
                OneHandedWeapon ohw = (OneHandedWeapon) entity.getSkills().get(3);
                if (validateOneHanded()) {
                    MapLocationPoint targetLocation = entity.getLocation().getAdjacent(entity.getOrientation());
                    Tile targetTile = map.getTile((int)targetLocation.getX(), (int)targetLocation.getY());
                    if (targetTile.hasEntity()) {
                        enemy = targetTile.getEntity();
                        StatsModifier sm = ohw.activate();
                        enemy.getStats().modifyStats(sm);
                    }
                    else {
                        System.out.println("not target found");
                        //TODO: and do something?
                    }
                }
                break;
            case Skill5:
                TwoHandedWeapon thw = (TwoHandedWeapon) entity.getSkills().get(3);
                if (validateTwoHanded()) {
                    AngularEffect ar = new AngularEffect();
                    MapLocationPoint entityLocation = entity.getLocation();
                    Queue<ArrayList<MapLocationPoint> > q = ar.getAffectedArea((int)entityLocation.getX(), (int)entityLocation.getY(), entity.getOrientation(), 2);
                    while (!q.isEmpty()) {
                        try {
                            ArrayList<MapLocationPoint> list = q.dequeue();
                            for (MapLocationPoint targetLocation : list) {
                                Tile targetTile = map.getTile((int)targetLocation.getX(), (int)targetLocation.getY());
                                if (targetTile.hasEntity()) {
                                    enemy = targetTile.getEntity();
                                    StatsModifier sm = thw.activate();
                                    enemy.getStats().modifyStats(sm);
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case Skill6:
                Brawling brawling = (Brawling) entity.getSkills().get(3);
                if (validateBrawling()) {
                    MapLocationPoint targetLocation = entity.getLocation().getAdjacent(entity.getOrientation());
                    Tile targetTile = map.getTile((int)targetLocation.getX(), (int)targetLocation.getY());
                    if (targetTile.hasEntity()) {
                        enemy = targetTile.getEntity();
                        StatsModifier sm = brawling.activate();
                        enemy.getStats().modifyStats(sm);
                    }
                    else {
                        System.out.println("not target found");
                        //TODO: and do something?
                    }
                }
                break;
            default:
                System.out.print("Something went wrong in" + this.toString());
        }
    }

    private boolean validateBrawling() {
        if (entity.getEquipment().getWeapon().getWeaponType() == WeaponTypeEnum.FIST) return true;
        return false;
    }

    private boolean validateTwoHanded() {
        if (entity.getEquipment().getWeapon().getWeaponType() == WeaponTypeEnum.TWOHANDSWORD) return true;
        return false;
    }

    private boolean validateOneHanded() {
        if (entity.getEquipment().getWeapon().getWeaponType() == WeaponTypeEnum.ONEHANDSWORD)
            return true;
        return false;
    }
}
