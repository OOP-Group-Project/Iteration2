package Main.Model.State;
import Main.Controller.Manager.StateControllerManager;
import Main.Model.Entity.*;

/**
 * Created by Peter Camejo on 3/12/16.
 */

public class TalkState extends State {

    private Entity targetNPC;

    public TalkState(){ targetNPC = null;}
    public TalkState(Entity targetNPC){this.targetNPC = targetNPC;}

    public void setTargetNPC(Entity targetNPC){this.targetNPC = targetNPC;}
    public Entity getTargetNPC(){return this.targetNPC;}
    public String getTargetNPCSpiel(){ return targetNPC.getSpiel().spiel();}



}

