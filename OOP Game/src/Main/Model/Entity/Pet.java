package Main.Model.Entity;


import Main.Model.Inventory.Inventory;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Occupation;
import Main.Model.Occupation.Smasher;

/**
 * Created by walkhard on 2/18/16.
 */
public class Pet extends Npc {
    public Pet(EntityTypeEnum entityType, EntitySpeechEnum entitySpiel, Occupation occupation, MapLocationPoint location, int level, Inventory inv){
        super(entityType, entitySpiel, occupation, location, level, inv);
    }

    public Pet(MapLocationPoint location) {
        super(EntityTypeEnum.Pet, EntitySpeechEnum.PET, new Smasher(), location, 1, new Inventory());
    }

    public Pet(MapLocationPoint location, int level) {
        super(EntityTypeEnum.Pet, EntitySpeechEnum.PET, new Smasher(), location, level, new Inventory());
    }
}
