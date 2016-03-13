package Main.Controller.ObjectControllers.EntityController;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.TimedObjectController;
import Main.Model.Entity.Entity;
import Main.Model.Map.Map;

/**
 * Created by johnkaufmann on 3/10/16.
 * TODO:
 */
public class ActionController extends TimedObjectController{
    private Entity entity;
    private Map map;

    public ActionController(Map map, Entity entity) {
        this.map = map;
        this.entity = entity;
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

        }
    }

    @Override
    public void tick() {
        super.tick();
        if(timer.isExpired()) {
            entity.setDoingAction(false);
        }
    }
}
