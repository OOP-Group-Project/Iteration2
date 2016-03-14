package Main.Model.State;

/**
 * Created by Michael on 3/14/16.
 */
public class TradeState extends State{

    public enum TradeOption{
        Cancel("Cancel Trade"){

            @Override
            protected StateEnum activate() {
                return StateEnum.PlayState;
            }

        }
        ,Trade("Trade") {
            @Override
            protected StateEnum activate() {
                return StateEnum.TradeState;
            }
        };

        private String name;
        private TradeOption(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }

        protected  abstract  StateEnum activate();

        protected  TradeOption previous(){
            if(this.ordinal() == 0){
                return TradeOption.values()[TradeOption.values().length - 1];
            }
            else {
                return TradeState.TradeOption.values()[this.ordinal() -1];
            }
        }

        protected  TradeOption next(){
            if(this.ordinal() == TradeOption.values().length - 1){
                return TradeOption.values()[0];
            }
            else {
                return TradeOption.values()[this.ordinal() +1];
            }
        }
    }
    //end of enum

    private TradeOption selected;

    public TradeState(){
        init();
    }

    public void init(){
        selected = TradeOption.values()[0];
    }

    public void previousOption(){
        selected = selected.previous();
    }

    public void nextOption(){
        selected = selected.next();
    }

    public StateEnum getNextState(){
        return selected.activate();
    }

    public String getStringSelected(){
        return  selected.getName();
    }
}
