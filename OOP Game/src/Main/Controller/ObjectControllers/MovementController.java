package Main.Controller.ObjectControllers;

import Main.Model.Entity.Entity;
import Main.Model.Map.Map;

/**
 * Created by mason on 3/9/16.
 */
public class MovementController {

    private Map world;
    private Entity entity;

    public MovementController(Entity entity, Map world) {
        this.entity = entity;
        this.world = world;
    }
}
