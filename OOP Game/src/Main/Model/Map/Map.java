package Main.Model.Map;

import Main.Model.AreaEffect.AreaEffect;
import Main.Model.Entity.*;
import Main.Model.Items.Item;
import Main.Model.Terrain.TerrainTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;


public class Map {
	//MAP DIMENSIONS
	private Tile[][] tiles;
    private int width;
    private int height;
	private boolean visited[][];
    private MapLocationPoint playerLocation;
    private HashMap<EntityTypeEnum, MapLocationPoint> entityLocations;
    private ArrayList<MapLocationPoint> npcLocations;
//    private Npc[] npcLocations;

    // Stores locations of different entities, to be used with the NpcMovementController
    private Avatar[] avatarLocations;
    private Pet[] petLocations;
    private Vehicle[] vehicleLocations;

    public Map(int width, int height) {
        this.height = height;
        this.width = width;
        this.tiles = new Tile[width][height];
		this.visited = new boolean[width][height];
    }
	
	//should be able to read from a path and set up the color for the tiles
	public void createTestMap(){
        for(int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                tiles[i][j] = new Tile(TerrainTypeEnum.Grass,0);
            }
        }
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void addEntity(Entity e, int xLocation, int yLocation) {
		tiles[xLocation][yLocation].addEntity(e);
	}

	public void addItem(Item i, int xLocation, int yLocation) {
		tiles[xLocation][yLocation].addItem(i);
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}

    public void updateEntityLocation(Entity e){
        // If list doesn't contain an avatar, then add it
        if (!entityLocations.containsKey(EntityTypeEnum.Avatar)){
            entityLocations.put(EntityTypeEnum.Avatar,e.getLocation());

        // If list contains an avatar, can only be one, replace the value
        } else if (entityLocations.containsKey(EntityTypeEnum.Avatar)){
            entityLocations.replace(EntityTypeEnum.Avatar,e.getLocation());

        // If list doesn't contain NPC, then add it
        } else if (!entityLocations.containsKey(EntityTypeEnum.NPC)){
            entityLocations.put(EntityTypeEnum.NPC,e.getLocation());
        }
    }

    public void removeEntityLocation(MapLocationPoint location){
        if (entityLocations.containsValue(location)){

        }
    }

    public void setPlayerLocation(MapLocationPoint location){
        playerLocation = location;
    }

    public MapLocationPoint getPlayerLocation(){
        return playerLocation;
    }

    public void setNPCLocation(MapLocationPoint location){
        this.npcLocations.add(location);
    }

    public ArrayList<MapLocationPoint> getAvatarLocation(){
        return npcLocations;
    }

	public boolean isBlocked(int x, int y){
        return tiles[x][y].isBlocked();
	}

	public float getCost(int sx, int sy, int tx, int ty){
		return 1;
	}

    public void pathFinderVisited(int x, int y) {
        visited[x][y] = true;
    }

}
