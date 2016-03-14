package Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.TimedObjectController;
import Main.Controller.Timer;
import Main.Model.AreaEffect.AreaEffectEnum;
import Main.Model.AreaEffect.Traps.Trap;
import Main.Model.Entity.Entity;
import Main.Model.Items.WeaponTypeEnum;
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
public class SneakController extends TimedObjectController {
    Entity sneak;
    Map map;
    Entity enemy;
    MapLocationPoint origin;
    MapLocationPoint targetLocation;
    Queue<MapLocationPoint> q = new Queue<>();
    LinearEffect le = new LinearEffect();
    Tile targetTile;
    StatsModifier sm;
    /*
    pick-pocket : self descriptive.
detect & remove trap : the higher this skill the more likely the avatar is to notice a trap; once the trap is detected, she may attempt to remove it : the higher her skill the more likely she is to succeed.
creep : ability to stealthily move from place to place; movement is slowed while creeping. A successfully creeping character can surprise and back-stab an unwary opponent for extra damage.
ranged weapon

     */
    PickPocket pickPocket = (PickPocket) sneak.getSkills().get(3);
    DetectAndRemoveTrap detectAndRemoveTrap = (DetectAndRemoveTrap) sneak.getSkills().get(4);
    Creep creep = (Creep) sneak.getSkills().get(5);
    RangedWeapon rangedWeapon = (RangedWeapon) sneak.getSkills().get(6);
    private boolean creepActivated = false;

    public SneakController(Entity sneak, Map map) {
        this.sneak = sneak;
        this.map = map;
    }

    public void performSkill(UserActionEnum u) {
        switch (u) {
            case Skill4:
                //Pick pocket
                origin = sneak.getLocation();
                q = le.getAffectedArea((int) origin.getX(), (int) origin.getY(), pickPocket.getLevel() / 5 + 1, sneak.getOrientation());
                while (!q.isEmpty()) {
                    try {
                        targetLocation = q.dequeue();
                        targetTile = map.getTile((int)targetLocation.getX(), (int) targetLocation.getY());
                        if (targetTile.hasEntity()) {
                            enemy = targetTile.getEntity();
                            if (pickPocket.activate()) {
                                //checks to see if there is an entity in front of the current entity
                                // and if so add the first item in their inventory to its own
                                if (enemy.getInventory().isThereAnItemAt(0)) {
                                    sneak.getInventory().addItem(enemy.getInventory().getItemAt(0));
                                    enemy.getInventory().removeItemAt(0);
                                }
                                break;
                            }
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
            case Skill5:
                //Detect and remove trap
                if (detectAndRemoveTrap.activate()) {
                    uncoverTrap();
                    disableTrap();
                }
                break;
            case Skill6:
                if(!creepActivated) {
                    // Calculate how long boon should last
                    timer.start((int)creep.getDuration());
                    sm = creep.activateCreep();
                    sneak.getStats().buff(sm);
                    creepActivated = true;
                }
                else if (creepActivated) {
                    targetLocation = sneak.getLocation().getAdjacent(sneak.getOrientation());
                    targetTile = map.getTile((int)targetLocation.getX(), (int)targetLocation.getY());
                    if (targetTile.hasEntity()) {
                        enemy = targetTile.getEntity();
                        sm = creep.attack();
                        enemy.getStats().modifyStats(sm);
                        creepActivated = false;
                        sneak.getStats().revert();
                        timer = new Timer();
                    }
                    else {
                        System.out.println("not target found");
                        //TODO: and do something?
                    }
                }
                break;
            case Skill7:
                if (validateRanged()) {
                    origin = sneak.getLocation();
                    q = le.getAffectedArea((int) origin.getX(), (int) origin.getY(), rangedWeapon.getLevel() / 2 + 1, sneak.getOrientation());
                    while (!q.isEmpty()) {
                        try {
                            targetLocation = q.dequeue();
                            targetTile = map.getTile((int) targetLocation.getX(), (int) targetLocation.getY());
                            if (targetTile.hasEntity()) {
                                enemy = targetTile.getEntity();
                                sm = rangedWeapon.attack();
                                enemy.getStats().modifyStats(sm);
                                break;
                            } else {
                                System.out.println("not target found");
                                //TODO: and do something?
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            default:
                System.out.print("Something went wrong in" + this.toString());
        }
    }

    private void disableTrap() {
        MapLocationPoint targetTile = sneak.getLocation().getAdjacent(sneak.getOrientation());
        map.getTile(targetTile.x,targetTile.y).removeAreaEffect();
    }

    //checks to see if there is a tile with a trap in front of the entity and if so uncover it
    private void uncoverTrap() {
        MapLocationPoint targetTile = sneak.getLocation().getAdjacent(sneak.getOrientation());
        Trap ae = (Trap)map.getTile(targetTile.x, targetTile.y).getAreaEffect();
        if (ae.getType() == AreaEffectEnum.TRAP) {
            ae.setIsVisible(true);
            System.out.println("You've found and removed a trap");
        }
    }

    private boolean validateRanged() {
        if (sneak.getEquipment().getWeapon().getWeaponType() == WeaponTypeEnum.FIST)
            return true;
        else {
            return false;
        }
    }

    public void update () {
        timer.tick();
        if(timer.isExpired() && creepActivated) {
            sneak.getStats().revert();
            creepActivated = false;
        }
    }

}
