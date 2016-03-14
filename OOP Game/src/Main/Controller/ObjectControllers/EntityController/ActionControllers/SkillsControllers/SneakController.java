package Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.AreaEffect.AreaEffect;
import Main.Model.AreaEffect.AreaEffectEnum;
import Main.Model.AreaEffect.Traps.Trap;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Skills.*;

/**
 * Created by johnkaufmann on 3/13/16.
 * TODO:
 */
public class SneakController {
    Entity sneak;
    Map map;

    public SneakController(Entity sneak, Map map) {
        this.sneak = sneak;
        this.map = map;
    }

    public void performSkill(UserActionEnum u) {
        switch (u) {
            case Skill1:
//                if (new PickPocket(sneak).activate()) pickpocket();
                break;
            case Skill2:
                new DetectTrap()
//                if (new DetectTrap(sneak,100,0).activate()) uncoverTrap();
//                    if (new RemoveTrap(sneak,100,0).activate()) disableTrap();
                break;
            case Skill3:
                Creep c = new Creep(sneak);
                if (c.activate()) sneak.getStats().modifyStats(c.attack());
                break;
            case Skill4:
                sneak.getStats().modifyStats(new RangedWeapon(sneak).activate());
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
        if (ae.getType() == AreaEffectEnum.TRAP)
            ae.setIsVisible(true);
    }

    //checks to see if there is an entity in front of the current entity and if so add the first item in their inventory to its own
    private void pickpocket() {
        Entity target = map.getTile(sneak.getLocation().x, sneak.getLocation().y).getEntity();
        if (target != null && target.getInventory().isThereAnItemAt(0))
            sneak.getInventory().addItem(target.getInventory().getItemAt(0));
    }
}
