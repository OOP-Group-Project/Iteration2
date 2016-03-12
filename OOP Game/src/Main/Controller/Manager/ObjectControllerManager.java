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
    private HashMap<Object, TimedObjectController> timedObjectControllerHashMap;

    public ObjectControllerManager(Model model) {
        objectControllerHashMap = new HashMap<>();
        timedObjectControllerHashMap = new HashMap<>();
    }

    public void addObjectController(Object object, ObjectController objectController) {

    }

    public void addObjectController(Object object, TimedObjectController timedObjectController) {

    }

    public boolean removeObjectController(Object objectKey, TimedObjectController timedObjectController) {
        return timedObjectControllerHashMap.remove(objectKey, timedObjectController);
    }

    public boolean removeObjectController(Object object, ObjectController objectController) {
        return objectControllerHashMap.remove(object, objectController);
    }

    public ObjectController getObjectController(Object object) {
        if(objectControllerHashMap.containsKey(object)) {
            return objectControllerHashMap.get(object);
        } else if(timedObjectControllerHashMap.containsKey(object)) {
            return timedObjectControllerHashMap.get(object);
        } else {
            return null;
        }
    }



}
