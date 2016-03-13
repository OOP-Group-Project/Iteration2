package Main.Controller.EntityControllers.ActionControllers;

import Main.Controller.EntityControllers.ActionControllers.SkillsControllers.SkillsController;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;

/**
 * Created by johnkaufmann on 3/10/16.
 * TODO:
 */
public class ActionController {
    Map map;
    Entity entity;
    AttackController AC;
    SkillsController SC;
    String occupation;

    public ActionController(Map map, Entity entity) {
        this.map = map;
        this.entity = entity;
        this.AC = new AttackController(map, entity);
        this.occupation = entity.getOccupation().toString();
    }

    public void performAction(UserActionEnum u) {
        if (occupation == "Smasher" && u.ordinal() == 10) AC.performMeleeAttack();
        else if (occupation == "Sneak" && u.ordinal() == 10) AC.performRangeAttack();
        else if (occupation == "Summoner" && u.ordinal() > 10 && u.ordinal() < 14) AC.performSpell(u);
        else if (u.ordinal() > 24 && u.ordinal() < 27) SC.performSkill(u);
    }
}
