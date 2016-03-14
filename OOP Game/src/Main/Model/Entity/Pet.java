package Main.Model.Entity;


import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Occupation;
import Main.Model.Occupation.Smasher;
import Main.View.Graphics.GraphicsAssets;

import java.awt.*;

/**
 * Created by walkhard on 2/18/16.
 */
public class Pet extends Npc {
    public Pet(EntityTypeEnum entityType, EntitySpeechEnum entitySpiel, Occupation occupation, MapLocationPoint location){
        super(entityType, entitySpiel, occupation, location);
    }

    public Pet(MapLocationPoint location) {
        super(EntityTypeEnum.Pet, EntitySpeechEnum.PET, new Smasher(), location);
    }
}
