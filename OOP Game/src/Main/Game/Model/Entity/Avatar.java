package Main.Game.Model.Entity;

import Main.Model.Actions.Actions;
import Main.Model.Equipped.Equipped;
import Main.Model.Inventory.Inventory;
import Main.Model.Occupation.Occupation;
import Main.Model.Stats.Stats;

/**
 * Created by walkhard on 2/18/16.
 */
public class Avatar extends Entity{
    public Avatar(Main.Model.Actions.Actions Actions, Main.Model.Inventory.Inventory inventory, Equipped equippedItems, Main.Model.Occupation.Occupation occupation, Main.Model.Stats.Stats stats, int xPosition, int yPosition) {
        super(Actions, inventory, equippedItems, occupation, stats, xPosition, yPosition);
    }

    @Override
    protected boolean performAction(Actions action) {
        return false;
    }
}
