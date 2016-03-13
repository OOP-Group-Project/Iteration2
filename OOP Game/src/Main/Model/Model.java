package Main.Model;

import Main.Model.AreaEffect.TakeDamage;
import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;

import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.State.*;
import Main.Model.Entity.Npc;
import Main.Model.io.MapIO;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * Created by mason on 3/9/16.
 */
public class Model {
    private Avatar player;
    private Npc skeleton;
    private ArrayList<Entity> nonPlayerEntities = new ArrayList<Entity>();
    private Map world;
    private EnumMap<StateEnum, State> states;

    public Model() {
        /********************
         * Create empty Player and World
         *
         * The references to these will be propagated through all the states as needed, so these are important.
         ********************/

        // Create a dummy character first
        player = new Avatar(new MapLocationPoint(0,0));


        // Create a dummy NPC
        skeleton = new Npc(new MapLocationPoint(2,11));

        // add skeleton
        nonPlayerEntities.add(skeleton);

        // Create the map first, we'll loadMap everything into it later
        world = new MapIO().loadMap("map.txt");

        // Test adding an area effect.
        world.getTile(1,7).addAreaEffect(new TakeDamage());

        /***********************
         * Create all the state objects
         ***********************/
        states = new EnumMap<>(StateEnum.class);
        states.put(StateEnum.LoadState, new LoadState(this));
        states.put(StateEnum.PlayState, new PlayState(world, player));
        states.put(StateEnum.PauseState, new PauseState());
        
        //INVENTORY & STATS  need to be pass to player and InventoryState
        states.put(StateEnum.InventoryState, new InventoryState());

        
        states.put(StateEnum.StartMenuState, new StartMenuState());

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

    public ArrayList<Entity> getNonPlayerEntities() {
        return nonPlayerEntities;
    }

}
