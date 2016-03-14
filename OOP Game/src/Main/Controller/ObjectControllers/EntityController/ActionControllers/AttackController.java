package Main.Controller.ObjectControllers.EntityController.ActionControllers;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.AttackEffectController;
import Main.Controller.ObjectControllers.TimedObjectController;
import Main.Model.AreaEffect.AttackEffect;

import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Skills.RadialEffect;
import Main.Model.Stats.StatsModifier;

import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/12/16.
 * TODO:
 */
public class AttackController extends TimedObjectController{
    private Entity entity;
    private Map map;
    private MapLocationPoint point;
    private DirectionEnum orientation;
    private ObjectControllerManager objectControllerManager;

    public AttackController(ObjectControllerManager objectControllerManager, Map map, Entity entity) {
        this.entity = entity;
        this.map = map;
        this.objectControllerManager = objectControllerManager;
    }

    // gets the tile the attack is performed on and applys the area effect
    public void performMeleeAttack() {
        if(timer.isExpired()) {
            int msMeleeAttackRechargeSpeed = 100;
            timer.start(msMeleeAttackRechargeSpeed);
            point = entity.getLocation().getAdjacent(entity.getOrientation());
            applyEffect(10.0, 100, point);
        }

    }

    //searchs for an NPC and applies an area effect on the first tile the npc is found on
    public void performRangeAttack() {
        if(timer.isExpired()){
            int msRangedAttackRechargeSpeed = 100;
            timer.start(msRangedAttackRechargeSpeed);

            orientation = entity.getOrientation();
            point = entity.getLocation().getAdjacent(orientation);
            int distance = 0;
            int speed = 100;
            while (map.getTile(point.x,point.y).getEntity() == null) {
                point = point.getAdjacent(orientation);
                distance++;
            }
            applyEffect(distance*100, speed, point);

        }

    }

//    public void performAngularAttack(int effectedRadius) {
//        point = entity.getLocation();
//        orientation = entity.getOrientation();
//        sun.misc.Queue<MapLocationPoint> q = new AngularEffect().getAffectedArea(point.x, point.y, effectedRadius, orientation);
//        while (!q.isEmpty()) {
//            try {
//                applyEffect(q.dequeue());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public void performAngularAttack(int effectedRadius) {
        if(timer.isExpired()) {

            int msAngularAttackRechargeSpeed = 500;
            timer.start(msAngularAttackRechargeSpeed);

            int speed = 100;
            orientation = entity.getOrientation();
            point = entity.getLocation().getAdjacent(orientation);
            DirectionEnum[] expansions = findExpansion();
            for (int i = 1; i < effectedRadius; i++) {
                //apply effect to the point you moved to then expand out
                applyEffect(100 * (1/i) , 100*i, point);


                //set up for expansion on both sides
                MapLocationPoint leftSide = point;
                MapLocationPoint rightSide = point;

                //if even then expand out i/2 in both directions
                //if odd expand out i/2 (truncated) in both directions
                for (int j = 0; j < i/2; j++) {
                    leftSide = leftSide.getAdjacent(expansions[0]);
                    rightSide = rightSide.getAdjacent(expansions[1]);
                    applyEffect(100 * (1/i), 100*i, leftSide);
                    applyEffect(10.0 * (1/i), 100*i, rightSide);

                }

                //move to the next radius
                point = point.getAdjacent(orientation);
            }
        }

    }

    private DirectionEnum[] findExpansion() {
        orientation = entity.getOrientation();
        DirectionEnum[] expansions = new DirectionEnum[2];
        switch (orientation) {
            case Up:
                expansions[0] = DirectionEnum.DownLeft;
                expansions[1] = DirectionEnum.DownRight;
                break;
            case Down:
                expansions[0] = DirectionEnum.UpLeft;
                expansions[1] = DirectionEnum.UpRight;
                break;
            case UpLeft:
                expansions[0] = DirectionEnum.Down;
                expansions[1] = DirectionEnum.UpRight;
                break;
            case DownRight:
                expansions[0] = DirectionEnum.Up;
                expansions[1] = DirectionEnum.DownLeft;
                break;
            case UpRight:
                expansions[0] = DirectionEnum.UpLeft;
                expansions[1] = DirectionEnum.Down;
                break;
            case DownLeft:
                expansions[0] = DirectionEnum.Up;
                expansions[1] = DirectionEnum.DownRight;
                break;
        }
        return expansions;
    }

    public void performRadiusAttack(int radius) {
        if(timer.isExpired()) {
            int msRadiusAttackRechargeTime = 1000;
            timer.start(msRadiusAttackRechargeTime);

            point = entity.getLocation();

            sun.misc.Queue<ArrayList<MapLocationPoint>> q = new RadialEffect().getAffectedArea(point.x, point.y, radius);
            int currentRadius = 1;
            while (!q.isEmpty()) {
                //System.out.println("Radius: " + currentRadius++);
                try {
                    ArrayList<MapLocationPoint> current = q.dequeue();
                    int size = current.size();
                    for (int i = 0; i < size; i++) {
                        applyEffect(100*(1/currentRadius), 10 * currentRadius, current.get(i));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void applyEffect(double damageAmount , int charge, MapLocationPoint location) {
        AttackEffect attackEffect = new AttackEffect(damageAmount, charge, location);

        objectControllerManager.addObjectController(attackEffect, new AttackEffectController(attackEffect));
        map.getTile(location).addAttackEffect(attackEffect); //Peter: Added 10.00 for compiplation.
    }

    // TODO: 3/13/16 implment spells
    public void performSpell(UserActionEnum u) {
        //perform fire spell
        if(timer.isExpired()) {
            StatsModifier sm = new StatsModifier();

            switch(u) {
                case Spell1:
                    timer.start(300);
                    performAngularAttack(4);
                    sm = sm.builder().manaModifier(10.0).build();
                    entity.modifyStats(sm);
                    break;
                case Spell2:
                    timer.start(500);
                    performRadiusAttack(4);
                    sm = sm.builder().manaModifier(20.0).build();
                    entity.modifyStats(sm);
                    break;
                case Spell3:
                    timer.start(200);
                    performRangeAttack();
                    sm = sm.builder().manaModifier(10.0).build();
                    entity.modifyStats(sm);
                    break;
            }
        }


        //perform earth spell

        //perform wind spell
    }
}
