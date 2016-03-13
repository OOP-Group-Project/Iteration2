package Main.Model.Map;

import Main.Model.AreaEffect.AreaEffect;
import Main.Model.Entity.Entity;
import Main.Model.Items.Item;

import Main.Model.Terrain.TerrainTypeEnum;

import java.util.ArrayList;

public class Tile {

	private TerrainTypeEnum terrainType;
	private Entity entity = null;
	private ArrayList<Item> items;
    private AreaEffect areaEffect;
    private boolean hasEntity;


	// Default constructor
	
	public Tile(TerrainTypeEnum terrainType, int id) {
		this.terrainType = terrainType;
		items = new ArrayList<>();
	}

	public void addEntity(Entity e) {
		this.entity = e;
        this.hasEntity = true;
	}

	public Entity removeEntity() {
		Entity entityToRemove;
		entityToRemove = this.entity;
		this.entity = null;
        this.hasEntity = false;
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

	public boolean hasEntity() {
		return entity != null;
	}

	public boolean hasItems() {
		return !items.isEmpty();
	}
	public TerrainTypeEnum getTerrainType() {
		return terrainType;
	}

	public Entity getEntity() {
		return entity;
	}

    // Can add different types of conditions of whether  a tile is blocked for pathfinding (Iteration 3)?
	public boolean isBlocked(){
		if (terrainType == TerrainTypeEnum.Grass) {
            return false;
        }
        return true;
	}
}
