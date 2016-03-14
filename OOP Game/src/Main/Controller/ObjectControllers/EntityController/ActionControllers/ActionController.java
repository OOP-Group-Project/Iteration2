package Main.Controller.ObjectControllers.EntityController.ActionControllers;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers.SkillsController;
import Main.Controller.ObjectControllers.TimedObjectController;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;

/**
 * Created by johnkaufmann on 3/10/16.
 * TODO:
 */
public class ActionController extends TimedObjectController {
    private Map map;
    private Entity entity;
    private AttackController AC;
    private SkillsController SC;
    private InteractionController IC;
    private String occupation;

    public ActionController(ObjectControllerManager objectControllerManager, Map map, Entity entity) {
        this.map = map;
        this.entity = entity;
        this.AC = new AttackController(objectControllerManager, map, entity);
        this.IC = new InteractionController(objectControllerManager, entity);
        this.occupation = entity.getOccupation().toString();
    }

    public void performAction(UserActionEnum u) {
        //
        if(!entity.isDoingAction()) {
            entity.setDoingAction(true);

            // Calculate speed of action
            int speed = 500; // milliseconds

            this.timer.start(speed);
            // Do action

            // Attack!
            if (occupation == "Smasher" && u == UserActionEnum.Attack) {
                AC.performMeleeAttack();
            } else if (occupation == "Sneak" && u == UserActionEnum.Attack) {
                AC.performRangeAttack();
            } else if (occupation == "Summoner" && u == UserActionEnum.Attack) {
                AC.performSpell(u);
            } else if (u.ordinal() > 24 && u.ordinal() < 27) {
                SC.performSkill(u);
            } else if (u == UserActionEnum.Interact) {
                MapLocationPoint adjacentLocation = entity.getLocation().getAdjacent(entity.getOrientation());
                IC.executeInteraction(map.getTile(entity.getLocation()), map.getTile(adjacentLocation));
            } else if(u == UserActionEnum.PickUpItem) {
                IC.executeInteraction(map.getTile(entity.getLocation()));
            }
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
