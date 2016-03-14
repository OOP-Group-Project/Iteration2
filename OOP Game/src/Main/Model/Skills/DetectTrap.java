package Main.Model.Skills;

import Main.Model.DirectionEnum;
import Main.Model.Entity.Entity;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Map.Tile;
import sun.misc.Queue;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by AndyZhu on 7/3/2016.
 *
 */
public class DetectTrap extends SneakSkills {
    public DetectTrap (Entity entity) {
        super(entity, 2, 2);
    }
}


