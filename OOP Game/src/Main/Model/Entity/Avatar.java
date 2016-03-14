package Main.Model.Entity;

import Main.Model.Inventory.Inventory;
import Main.Model.Occupation.Occupation;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Smasher;

/**
 * Created by walkhard on 2/18/16. Modified by John Kaufmann 3/9/16
 * TODO: Go over this class with mason to make sure nothing was wrongfully altered.
 * TODO: Implement methods.
 */
public class Avatar extends Entity{
//
//    public Avatar(MapLocationPoint location, Inventory inv) {
//        super(EntityTypeEnum.Avatar, EntitySpeechEnum.PLAYER, new Smasher(), location, 1, inv);
//    }

    public Avatar(Occupation o, MapLocationPoint location, int level, Inventory inv) {
        super(EntityTypeEnum.Avatar, EntitySpeechEnum.PLAYER, o, location, level, inv);
    }

    public Avatar(Occupation o, MapLocationPoint location) {
        super(EntityTypeEnum.Avatar, EntitySpeechEnum.PLAYER, o, location, 1, new Inventory());
    }

}
