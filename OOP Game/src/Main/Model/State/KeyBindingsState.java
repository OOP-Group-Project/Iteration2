package Main.Model.State;

import Main.Controller.Controller;
import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KeyBindingsState extends State {

    private int currentIndex;
    private int totalElements;
    private Controller controller;

    private ArrayList<Integer> arrayListInt;
    private ArrayList<UserActionEnum> arrayListEnum;

    private int firstInt;
    private int secondInt;
    private UserActionEnum firstEnum;
    private UserActionEnum secondEnum;
    private boolean firstFound;
    private boolean secondFound;

    public KeyBindingsState() {
        arrayListEnum = new ArrayList<UserActionEnum>();
        arrayListInt = new ArrayList<Integer>();

        currentIndex = 0;
        firstFound = false;
        secondFound = false;
        firstInt = 0;
        secondInt = 0;
    }




    public void previusOption(){
        currentIndex = currentIndex - 1;
        if(currentIndex < 0) {
            currentIndex = totalElements - 1;
        }
    }
    public void nextOption(){
        currentIndex = currentIndex + 1;
        if(currentIndex == totalElements) {
            currentIndex = 0;
        }
    }
    public void select() {
        if (!firstFound) {
            firstInt = arrayListInt.get(currentIndex);
            firstEnum = arrayListEnum.get(currentIndex);
            firstFound = true;
        }
        else if (!secondFound) {
            secondInt = arrayListInt.get(currentIndex);
            secondEnum = arrayListEnum.get(currentIndex);
            secondFound = true;
            System.out.println("change");
            controller.getKeyManager().removeKeyAction(firstInt);
            controller.getKeyManager().removeKeyAction(secondInt);
            controller.getKeyManager().addKeyAction(secondInt, firstEnum);
            controller.getKeyManager().addKeyAction(firstInt, secondEnum);

            firstFound = false;
            secondFound = false;
        }
    }

    public int getCurrentIndex() {
        return currentIndex;
    }


    public void sendKeyManager(HashMap<Integer, UserActionEnum> keyboardActionMapping) {
        Iterator iter = keyboardActionMapping.entrySet().iterator();
        totalElements = 0;
        arrayListInt.clear();
        arrayListEnum.clear();
        while(iter.hasNext()){
            Map.Entry pair = (Map.Entry) iter.next();
            arrayListInt.add(pair.getKey().hashCode());
            UserActionEnum actionEnum = ((UserActionEnum) pair.getValue());
            totalElements++;
            arrayListEnum.add(actionEnum);
        }
    }

    public void sendController(Controller controller) {
        this.controller = controller;
    }

}
