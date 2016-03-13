package Main.Model.State;

import Main.Model.DirectionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Entity.Npc;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;

import java.awt.*;

public class PlayState extends State {
    private Avatar player;
    private Map world;
    private MapLocationPoint centerPoint;

	public PlayState(Map world, Avatar entity) {
        this.world = world;
        this.player = entity;
        this.centerPoint = new MapLocationPoint(player.getLocation().x, player.getLocation().y);
	}

    public Avatar getPlayer() {
        return player;
    }


    public MapLocationPoint getCenterPoint() {
        return centerPoint;
    }

    public Map getWorld() {
        return world;
    }

    public void moveCenterPoint(DirectionEnum direction) {
        centerPoint.move(direction);
    }

    public void centerToAvatar() {
        this.centerPoint = (MapLocationPoint)player.getLocation().clone();
    }

}
