package Main.Model.State;

import Main.Model.Entity.Avatar;
import Main.Model.Map.Map;

public class PlayState extends State {
    private Avatar player;
    private Map world;

	public PlayState(Map world, Avatar entity) {
        this.world = world;
        this.player = entity;
	}

    public Avatar getPlayer() {
        return player;
    }

    public Map getWorld() {
        return world;
    }


}
