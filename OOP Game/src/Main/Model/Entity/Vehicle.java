package Main.Model.Entity;

import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Smasher;

/**
 * Created by johnkaufmann on 3/12/16.
 * TODO:
 */
public class Vehicle extends Entity {
    public Vehicle(MapLocationPoint location) {
        super(EntityTypeEnum.Vehicle, EntitySpeechEnum.TRASH, new Smasher(), location, 1);
    }
    public Vehicle(MapLocationPoint location, int level) {
        super(EntityTypeEnum.Vehicle, EntitySpeechEnum.TRASH, new Smasher(), location, level);
    }
}
