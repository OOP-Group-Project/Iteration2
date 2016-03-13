package Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
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
                new Enchantment(summoner).apply();
                break;
            case Skill2:
                new Boon(summoner).apply();
                break;
            case Skill3:
                new Bane(summoner).apply();
                break;
            case Skill4:
                new Staff(summoner).apply();
                break;
            default:
                System.out.print("Something went wrong in" + this.toString());
        }
    }
}
