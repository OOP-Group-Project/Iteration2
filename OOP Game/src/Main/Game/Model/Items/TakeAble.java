package Main.Game.Model.Items;

import Main.Game.Model.Entity.Entity;

/**
 * Created by Matthew on 3/7/16.
 */
public class TakeAble extends Items {

    public TakeAble(int id, String name, String url, String mods){
        super(id, name, ItemTypeEnum.takeable, url, mods);
    }

    public void activate(Entity entity){
        if(canActivate(entity)) {
            //activate item
            //increase stats by the mods
            //entity.updateStats(mods)
        }
    }

    public boolean canActivate(Entity entity) {
        //any reqs for consumables?
        return true;
    }

}
