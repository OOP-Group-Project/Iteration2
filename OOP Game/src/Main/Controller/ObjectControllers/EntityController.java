package Main.Controller.ObjectControllers;

import Main.Model.Entity.Entity;
import Main.Model.Map.Map;

/**
 * Created by mason on 3/9/16.
 */
public class EntityController {

    private ActionController actionController;
    private MovementController movementController;

    public EntityController(Entity entity, Map world) {
        this.actionController = new ActionController(entity, world);
        this.movementController = new MovementController(entity, world);
    }
}
