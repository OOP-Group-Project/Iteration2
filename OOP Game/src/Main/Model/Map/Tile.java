package Main.Model.Map;

import Main.Model.AreaEffect.AreaEffect;
import Main.Model.Entity.Entity;
import Main.Model.Items.Item;

import Main.Model.Terrain.TerrainTypeEnum;

import java.util.ArrayList;

public class Tile {

	private TerrainTypeEnum terrainType;
	private Entity entity = null;
	private ArrayList<Item> items = new ArrayList<>();
    private AreaEffect areaEffect;


	// Default constructor
	public Tile(){
		this.terrainType = TerrainTypeEnum.Grass;
	}
	
	public Tile(TerrainTypeEnum terrainType,int id) {
		this.terrainType = terrainType;
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
        this.areaEffect = areaEffect;
    }

	public AreaEffect getAreaEffect() {
		return areaEffect;
	}

	public boolean hasAreaEffect() {
		return areaEffect != null;
	}

	public TerrainTypeEnum getTerrainType() {
		return terrainType;
	}

	public Entity getEntity() {
		return entity;
	}

	public boolean isBlocked(){
		if (this.terrainType == TerrainTypeEnum.Grass){
			return false;
		}
		else return true;
	}

	public ArrayList<String> toTileString() {
		ArrayList<String> str = new ArrayList<>();
		for (Item item : items) {
			str.add(String.valueOf(item.getId()));
		}
		return str;
	}
}
