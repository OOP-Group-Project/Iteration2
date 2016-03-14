package Main.Model.io;


import Main.Controller.Manager.UserActionEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Matthew on 3/14/2016.
 */
public class KeyBindingsIO {
    io io = new io();
    private ArrayList<Integer> arrayListInt;
    private ArrayList<UserActionEnum> arrayListEnum;

    public KeyBindingsIO() {
        arrayListInt = new ArrayList<Integer>();
        arrayListEnum = new ArrayList<UserActionEnum>();
    }

    public void setArrayLists(HashMap<Integer, UserActionEnum> keyboardActionMapping) {
        Iterator iter = keyboardActionMapping.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry pair = (Map.Entry) iter.next();
            arrayListInt.add(pair.getKey().hashCode());
            UserActionEnum actionEnum = ((UserActionEnum) pair.getValue());
            arrayListEnum.add(actionEnum);
        }
    }

    public void save() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i = 0; i < arrayListEnum.size(); ++i){
            String current = arrayListInt.get(i) + "," + arrayListEnum.get(i);
            arrayList.add(current);
        }
        System.out.println("saved");
        io.writeFile(arrayList, "keyBindings.txt");
    }

    public HashMap<Integer, UserActionEnum> load() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList = io.readFile("keyBindings.txt");
        HashMap<Integer, UserActionEnum> map = new HashMap<Integer, UserActionEnum>();

        for(int i = 0; i < arrayList.size(); ++i) {
            String[] current = new String[2];
            current = arrayList.get(i).split(",");
            map.put(Integer.parseInt(current[0]), UserActionEnum.valueOf(current[1]));
        }

        return map;
    }
}
