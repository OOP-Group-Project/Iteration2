package Main.Model.Entity;


import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Occupation;
import Main.Model.Occupation.Smasher;

/**
 * Created by walkhard on 2/18/16.
 */
public class Pet extends Entity {
    public Pet(EntityTypeEnum entityType, EntitySpeechEnum entitySpiel, Occupation occupation, MapLocationPoint location){
        super(entityType, entitySpiel, occupation, location, 1);
    }

    public Pet(MapLocationPoint location) {
        super(EntityTypeEnum.Pet, EntitySpeechEnum.PET, new Smasher(), location, 1);
    }

    public Pet(MapLocationPoint location, int level) {
        super(EntityTypeEnum.Pet, EntitySpeechEnum.PET, new Smasher(), location, level);
    }
}
