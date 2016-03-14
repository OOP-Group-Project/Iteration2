package Main.Model.State;
import Main.Controller.Manager.StateControllerManager;

/**
 * Created by Peter Camejo on 3/12/16.
 */

public class TalkState extends State {


    private enum Option {
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
            name = s;
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

        protected String getName() {
            return name;
        }
    }

    private Option selected;
    public TalkState(){ init();}

    public void init(){selected = Option.values()[0];}
    public void previousOption(){selected = selected.previous();}
    public void nextOption(){selected = selected.next();}

    public StateEnum getNextState(){ return selected.getState();}
    public String getStringSelected(){ return selected.getName();}

    public String[] getOptionsToString(){
        String[] o = new String[Option.values().length];

        for (int i = 0; i < o.length; i++) {
            o[i] = Option.values()[i].getName();
        }
        return o;
    }




}


