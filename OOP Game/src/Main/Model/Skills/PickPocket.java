package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Items.ItemTypeEnum;
import Main.Model.Items.ItemsList;
import Main.Model.Items.Takable;
import Main.Model.Requirement;
import Main.Model.Stats.StatsModifier;

/**
 * Created by AndyZhu on 7/3/2016.
 *
 */
public class PickPocket extends SneakSkills {

    public PickPocket (Entity entity) {
        super(entity, 5, 3);
        skillName = "Pick pocket";
    }
}