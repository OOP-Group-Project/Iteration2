package Main.Model.State;

import Main.Controller.Controller;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Skills.Skills;
import Main.Model.Stats.Stats;

import java.util.ArrayList;


public class SkillState extends State {

    private Entity entity;
    private int currentIndex;
    private int totalElements;
    private int totalSkillpoints;
    ArrayList<Skills> arrayList;

    public SkillState(Entity entity){
        this.entity = entity;
        totalSkillpoints = entity.getSkillPoints();
        arrayList = entity.getSkills();
    }


    public ArrayList<Skills> getSkills(){
        arrayList = entity.getSkills();
        totalElements = arrayList.size();
        return arrayList;
    }

    public int getSkillPoints() {
        totalSkillpoints = entity.getSkillPoints();
        return entity.getSkillPoints();
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
        if (totalSkillpoints > 0) {
            totalSkillpoints--;
            arrayList.get(currentIndex).increaseLevel();
        }
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

}

