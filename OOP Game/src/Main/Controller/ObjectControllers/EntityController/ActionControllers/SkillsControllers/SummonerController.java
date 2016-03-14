package Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Skills.Bane;
import Main.Model.Skills.Boon;
import Main.Model.Skills.Enchantment;
import Main.Model.Skills.Staff;

/**
 * Created by johnkaufmann on 3/13/16.
 * TODO:
 */
public class SummonerController {
    Entity summoner;
    Map map;
    UserActionEnum skill;

    public SummonerController(Entity summoner, Map map) {
        this.summoner = summoner;
        this.map = map;
    }

    public void performSkill(UserActionEnum u) {
        switch (u) {
            case Skill1:
                Enchantment ec = new Enchantment(summoner);
                if (ec.allCheck()) applyEnchantment(ec);
                break;
            case Skill2:
                Boon bn = new Boon(summoner);
                if (bn.allCheck()) summoner.getStats().modifyStats(bn.activate());
                break;
            case Skill3:
                Bane be = new Bane(summoner);
                if (be.allCheck()) applyBane(be);
                break;
            case Skill4:
                new Staff(summoner).apply();
                break;
            default:
                System.out.print("Something went wrong in" + this.toString());
        }
    }

    private void applyBane(Bane be) {
        MapLocationPoint targetPoint = summoner.peek();
        Entity target = map.getTile(targetPoint.x,targetPoint.y).getEntity();
        if(target != null) target.getStats().modifyStats(be.activate());
    }

    private void applyEnchantment(Enchantment ec) {
        MapLocationPoint point = summoner.peek();
        Entity target = map.getTile(point.x,point.y).getEntity();
        if(target != null) target.getStats().modifyStats(ec.activate());
    }
}
