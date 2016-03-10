package Main.Game.Model.Items;

import Main.Game.Model.Entity.Entity;

/**
 * Created by Matthew on 3/7/16.
 */
public class OneShot extends Items {

    public OneShot(int id, String name, String url, String mods) {
        super(id, name, ItemTypeEnum.oneshot, url, mods);

    }

    public void activate(Entity entity){
        //increase entity's stats by the mods
    }
}
