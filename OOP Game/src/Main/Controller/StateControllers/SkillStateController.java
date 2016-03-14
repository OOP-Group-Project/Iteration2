package Main.Controller.StateControllers;

import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Model.State.SkillState;
import Main.Model.State.StatState;
import Main.Model.State.StateEnum;

public class SkillStateController extends StateController {

    private StateControllerManager stateControllerManager;
    private SkillState skillState;

    public SkillStateController(StateControllerManager stateManager, SkillState skillState) {
        stateControllerManager = stateManager;
        this.skillState = skillState;
    }

    @Override
    public void handleAction(UserActionEnum action) {

        switch(action){
            case SkillTree:
                stateControllerManager.setState(StateEnum.PlayState);
                break;
            case Up:
                skillState.previusOption();
                break;
            case Down:
                skillState.nextOption();
                break;
            case Select:
                skillState.select();
                break;
        }
    }

    @Override
    public void update() {

    }

}
