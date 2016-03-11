package Main.Model;

import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;
import Main.Model.Inventory.Inventory;
import Main.Model.Map.Map;
import Main.Model.State.*;
import Main.Model.Stats.Stats;

import java.util.EnumMap;
import java.util.HashMap;

/**
 * Created by mason on 3/9/16.
 */
public class Model {
    private Avatar player;
    private Entity nonPlayerEntities[];
    private Map world;
    private EnumMap<StateEnum, State> states;

    public Model() {
        /********************
         * Testing code: Creating player and world
         ********************/

        // Create a dummy character first
        player = new Avatar(0,0);

        // Create the map first, we'll load everything into it later
        world = new Map(100, 100);

        /***********************
         * Create all the state objects
         ***********************/
        states = new EnumMap<>(StateEnum.class);
        states.put(StateEnum.LoadState, new LoadState(this));
        states.put(StateEnum.PlayState, new PlayState(world, player));
        states.put(StateEnum.PauseState, new PauseState());
        
        //INVENTORY & STATS  need to be pass to player and InventoryState
        states.put(StateEnum.InventoryState, new InventoryState());
    }

    public Avatar getPlayer() {
        return player;
    }

    public Map getWorld() {
        return world;
    }

    public EnumMap<StateEnum, State> getStates() {
        return states;
    }

    public void load(String loadFile) {

    }

    public String save() {
        return "";
    }

    public Entity[] getNonPlayerEntities() {
        return nonPlayerEntities;
    }

}
