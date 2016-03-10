package Main.Game.Model.Items;

/**
 * Created by Matthew on 3/7/16.
 */
public class Interactive extends Items {

    String requirements;

    public Interactive(int id, String name, String url, String mods, String reqs){
        super(id, name, ItemTypeEnum.interactive, url, mods);
        requirements = reqs;
    }

    public void activate(){
        //activate item (increase skills?)
    }

    public boolean canActivate() {
        //does the entity have the requirements?
        return true;
    }

}
