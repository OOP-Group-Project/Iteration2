package Main.Model.State;

import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;
import Main.Model.Occupation.Occupation;
import Main.Model.Occupation.Smasher;
import Main.Model.Occupation.Sneak;
import Main.Model.Occupation.Summoner;
import Main.Model.io.MapIO;

/**
 * Created by jcvarela on 3/13/2016.
 */
public class AvatarCreationState extends State {

    private Avatar avatar;

    public enum OccupationSelection{
        Smasher(new Smasher()),
        Sneak(new Sneak()),
        Summoner(new Summoner());

        protected Occupation occupation;
        protected String name;

         private OccupationSelection(Occupation occupation){
            this.occupation = occupation;
             this.name = occupation.toString();
        }

        public Occupation getOccupation(){
            return occupation;
        }
        public String getName() { return name;}

        protected OccupationSelection previous(){
            if(this.ordinal() == 0){
                return OccupationSelection.values()[OccupationSelection.values().length - 1];
            }
            else {
                return OccupationSelection.values()[this.ordinal() - 1];
            }
        }

        protected OccupationSelection next(){
            if(this.ordinal() == OccupationSelection.values().length -1){
                return OccupationSelection.values()[0];
            }
            else {
                return OccupationSelection.values()[this.ordinal() + 1];
            }
        }
    }

    private OccupationSelection selected;
    private Map map;
    private MapIO mapIO;

    public AvatarCreationState(Avatar avatar,Map map){
        this.avatar = avatar;
        this.map = map;

        init();
    }

    public void init(){
        selected = OccupationSelection.values()[0];
        mapIO = new MapIO();

    }

    public void previusOption(){
        selected = selected.previous();
    }
    public void nextOption(){
        selected = selected.next();
    }

    public void createGame(){
        avatar.setOccupation(selected.getOccupation());
        avatar.init(1);
        mapIO.loadMap(map);
    }
    public String getStringSelected(){
        return selected.getName();
    }

    public String[] getOptionsToString(){
        String[] o = new String[OccupationSelection.values().length];

        for (int i = 0; i < o.length; i++) {
            o[i] = OccupationSelection.values()[i].getName();
        }
        return o;
    }
}

