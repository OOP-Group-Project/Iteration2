package Main.Controller.ObjectControllers.EntityController.ActionControllers;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers.SkillsController;
import Main.Controller.ObjectControllers.TimedObjectController;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;

/**
 * Created by johnkaufmann on 3/10/16.
 * TODO:
 */
public class ActionController extends TimedObjectController {
    private Map map;
    private Entity entity;
    private AttackController AC;
    private SkillsController SC;
    private String occupation;

    public ActionController(Map map, Entity entity) {
        this.map = map;
        this.entity = entity;
        this.AC = new AttackController(map, entity);
        this.occupation = entity.getOccupation().toString();
    }

    public void performAction(UserActionEnum u) {
        //
        if(!entity.isDoingAction()) {
            entity.setDoingAction(true);

            // Calculate speed of action
            int speed = 100; // milliseconds

            this.timer.start(speed);
            // Do action

            // Attack!
            if (occupation == "Smasher" && u.ordinal() == 10) AC.performMeleeAttack();
            else if (occupation == "Sneak" && u.ordinal() == 10) AC.performRangeAttack();
            else if (occupation == "Summoner" && u.ordinal() > 10 && u.ordinal() < 14) AC.performSpell(u);
            else if (u.ordinal() > 24 && u.ordinal() < 27) SC.performSkill(u);
        }
    }

    @Override
    public void update() {
        super.update();
        if(timer.isExpired()) {
            entity.setDoingAction(false);
        }
    }
}
