package Main.Model;

import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.State.*;
import Main.Model.io.ItemsIO;
import Main.Model.io.MapIO;

import java.util.EnumMap;

/**
 * Created by mason on 3/9/16.
 */
public class Model {
    private Avatar player;
    private Map world;
    private EnumMap<StateEnum, State> states;

    public Model() {
        /********************
         * Create empty Player and World
         *
         * The references to these will be propagated through all the states as needed, so these are important.
         ********************/


        // Create an empty character first
        player = new Avatar(new MapLocationPoint(0,0));

        // Create the map first, we'll loadMap everything into it later
        world = new MapIO().loadMap("map.txt");
        world = new ItemsIO().loadItemsToMap(world, "Items.txt");

        new ItemsIO().saveItemsOnMap(world, "Items1.txt");
        // Test adding an area effect.
//        world.getTile(1,7).addAreaEffect(new TakeDamage());


        /***********************
         * Create all the state objects
         ***********************/
        states = new EnumMap<>(StateEnum.class);
        states.put(StateEnum.LoadState, new LoadState(this));
        states.put(StateEnum.PlayState, new PlayState(world, player));
        states.put(StateEnum.PauseState, new PauseState());
        
        //INVENTORY & STATS  need to be pass to player and InventoryState
        states.put(StateEnum.InventoryState, new InventoryState());
        states.put(StateEnum.StatState, new StatState(player));

        states.put(StateEnum.StartMenuState, new StartMenuState());
        states.put(StateEnum.AvatarCreationState,new AvatarCreationState(player));

        new MapIO().saveMap(world, "map.txt");
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


}
