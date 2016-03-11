package Main.Model.Entity;


import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Occupation;
import Main.View.Graphics.GraphicsAssets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by walkhard on 2/18/16.
 */
public class Npc extends Entity {

    public Npc(EntityTypeEnum entityType, Occupation occupation, MapLocationPoint location){
        super(entityType, occupation, location);
    }
}
