package Main.Model.Entity;


import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Occupation;
import Main.View.Graphics.GraphicsAssets;

import java.awt.*;

/**
 * Created by walkhard on 2/18/16.
 */
public class Pet extends Entity {
    public Pet(EntityTypeEnum entityType, EntitySpeechEnum entitySpiel, Occupation occupation, MapLocationPoint location){
        super(entityType, entitySpiel, occupation, location);
    }
}
