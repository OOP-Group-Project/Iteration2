package Main.Controller.Manager;

import Main.Controller.ObjectControllers.ObjectController;
import Main.Controller.ObjectControllers.TimedObjectController;
import Main.Model.Model;

import java.util.HashMap;

/**
 * Created by mason on 3/12/16.
 */
public class ObjectControllerManager {

    private HashMap<Object, ObjectController> objectControllerHashMap;

    public ObjectControllerManager(Model model) {
        objectControllerHashMap = new HashMap<>();
    }

    public void addObjectController(Object object, ObjectController objectController) {
        objectControllerHashMap.put(object, objectController);
    }

    public boolean removeObjectController(Object object, ObjectController objectController) {
        return objectControllerHashMap.remove(object, objectController);
    }

    public ObjectController getObjectController(Object object) {
        return objectControllerHashMap.get(object);
    }

}
