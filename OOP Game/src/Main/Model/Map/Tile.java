package Main.Model.Map;

import Main.Model.Entity.Entity;
import Main.Model.Items.Item;
import Main.Model.Terrain.Terrain;
import Main.Model.Terrain.TerrainTypeEnum;

import java.awt.*;
import java.util.ArrayList;

public class Tile {

	public static final int TILE_SIDE = 32;

	private TerrainTypeEnum terrainType;
	private Entity entity = null;
	private ArrayList<Item> items;
	private int x;
	private int y;
	
	//TYPE OF TILES  (The type of tile is a class)
//	public static final int GRASS =0;
//	public static final int MOUNTAIN = 1;
//	public static final int WATER = 2;


	// Default constructor
	public Tile(){
		this.terrainType = TerrainTypeEnum.Grass;
	}
	
	public Tile(TerrainTypeEnum terrainType, int id, int x, int y){
		this.terrainType = terrainType;
		this.x = x;
		this.y = y;
	}

	public void addEntity(Entity e) {
		this.entity = e;
	}

	public Entity removeEntity() {
		Entity entityToRemove;
		entityToRemove = this.entity;
		this.entity = null;
		return entityToRemove;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public TerrainTypeEnum getTerrainType() {
		return terrainType;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Entity getEntity() {
		return entity;
	}
}
