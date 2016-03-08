package Main.Game.Model.Map;

import Main.Game.Model.Entity.Entity;
import Main.Game.Model.Items.Item;
import Main.Game.Model.Terrain.Terrain;

import java.awt.*;
import java.util.ArrayList;

public class Tile {

	public static final int TILE_SIDE = 32;

	private Terrain mTerrain;
	private Entity entity;
	private ArrayList<Item> items;
	private int id;
	private int x;
	private int y;
	
	//TYPE OF TILES  (The type of tile is a class)
//	public static final int GRASS =0;
//	public static final int MOUNTAIN = 1;
//	public static final int WATER = 2;


	// Default constructor
	public Tile(){
		this.mTerrain = null;
		this.id = 0;
	}
	
	public Tile(Terrain mTerrain, int id, int x, int y){
		this.mTerrain = mTerrain;
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public void addEntity(Entity e) {
		this.entity = e;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void render(Graphics g, int x, int y){
		g.drawImage(mTerrain.getTerrainType(),x,y,TILE_SIDE,TILE_SIDE,null);
	}
}
