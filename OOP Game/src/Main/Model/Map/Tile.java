package Main.Model.Map;

import Main.Model.AreaEffect.AreaEffect;
import Main.Model.Entity.Entity;
import Main.Model.Items.Item;

import Main.Model.Terrain.TerrainTypeEnum;

import java.util.ArrayList;

public class Tile {

	public static final int TILE_SIDE = 32;

	private TerrainTypeEnum terrainType;
	private Entity entity = null;
	private ArrayList<Item> items;
    private boolean hasAreaEffect;
    private AreaEffect mAreaEffect;
	private int x;
	private int y;


	// Default constructor
	public Tile(){
		this.terrainType = TerrainTypeEnum.Grass;
	}
	
	public Tile(TerrainTypeEnum terrainType, boolean hasAreaEffect,int id, int x, int y){
		this.terrainType = terrainType;
        this.hasAreaEffect = hasAreaEffect;
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

    public void addAreaEffect(AreaEffect areaEffect){
        this.mAreaEffect = areaEffect;
        hasAreaEffect = true;
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

	public boolean isWalkable(){
		if (this.terrainType != TerrainTypeEnum.Grass){
			return true;
		}
		else return false;
	}
}
