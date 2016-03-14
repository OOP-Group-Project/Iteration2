package Main.Model.State;
import Main.Controller.Manager.StateControllerManager;
import Main.Model.Entity.Avatar;
import Main.Model.Entity.Npc;

/**
 * Created by Peter Camejo on 3/12/16.
 */

public class TalkState extends State {

    private Npc targetNPC;

    public enum Option {
        Trade("Trade") {
            protected StateEnum getState() {
                return StateEnum.TradeState;
            }
        },
        Exit("End") {
            protected StateEnum getState() {
                return StateEnum.PlayState;
            }
        };

        private String name;
        Option(String s) {
            this.name = s;
        }
        public String getName() {
            return this.name;
        }
        protected abstract StateEnum getState();

        protected Option previous() {
            if (this.ordinal() == 0) {
                return Option.values()[Option.values().length - 1];
            } else {
                return Option.values()[this.ordinal() - 1];
            }
        }

        protected Option next() {
            if (this.ordinal() == Option.values().length - 1) {
                return Option.values()[0];
            } else {
                return Option.values()[this.ordinal() + 1];
            }
        }


    }

    private Option selected;

    public TalkState(){ init();}
    public TalkState(Npc targetNPC){this.targetNPC = targetNPC; init();}

    public void init(){
        selected = Option.values()[0];
    }
    public void previousOption(){selected = selected.previous();}
    public void nextOption(){selected = selected.next();}

    public StateEnum getNextState(){ return selected.getState();}
    public void setTargetNPC(Npc targetNPC){this.targetNPC = targetNPC;}
    public Npc getTargetNPC(){return this.targetNPC;}
    public String getTargetNPCSpiel(){ return targetNPC.getSpiel().spiel();}
    public String getStringSelected(){ return selected.getName();}


}

