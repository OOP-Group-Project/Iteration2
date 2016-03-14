package Main.Controller.EntityControllers.ActionControllers.SkillsControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;

/**
 * Created by johnkaufmann on 3/13/16.
 * TODO:
 */
public class SkillsController {
    Entity entity;
    Map map;
    UserActionEnum skill;
    String occupation;

    public SkillsController(Entity entity, Map map, UserActionEnum skill) {
        this.entity = entity;
        this.map = map;
        this.skill = skill;
        this.occupation = entity.getOccupation().toString();
    }


    public void performSkill(UserActionEnum u) {
        switch (occupation) {
            case "Smasher":
                new SmasherController(entity,map).performSkill(u);
                break;
            case "Summoner":
                new SummonerController(entity,map).performSkill(u);
                break;
            case "Sneak":
                new Main.Controller.EntityControllers.ActionControllers.SkillsControllers.SneakController(entity,map).performSkill(u);
                break;
            default:
                System.out.println("Something went wrong in " + this.toString());
        }
    }
}
