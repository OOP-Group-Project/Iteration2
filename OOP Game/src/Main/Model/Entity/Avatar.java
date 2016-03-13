package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Occupation.Occupation;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Smasher;
import Main.Model.Stats.StatsModifier;
import Main.View.Graphics.GraphicsAssets;

import java.awt.*;

/**
 * Created by walkhard on 2/18/16. Modified by John Kaufmann 3/9/16
 * TODO: Go over this class with mason to make sure nothing was wrongfully altered.
 * TODO: Implement methods.
 */
public class Avatar extends Entity{

    public Avatar(MapLocationPoint location) {
        super(EntityTypeEnum.Avatar, EntitySpeechEnum.PLAYER, new Smasher(), location);
    }

    public Avatar(Occupation o, MapLocationPoint location) {
        super(EntityTypeEnum.Avatar, EntitySpeechEnum.PLAYER, o, location);
    }

}
