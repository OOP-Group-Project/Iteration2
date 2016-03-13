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
//    private ArrayList<Entity> npcLocations;
//    private Npc[] npcLocations;

    // Stores locations of different entities, to be used with the NpcMovementGenerator
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
//        addToList(e);
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

//    public ArrayList<Entity> getNpcLocations(){
//        return npcLocations;
//    }

//    public void getAvatar(){
//        for(int i = 0; i < width; i++){
//            for(int j = 0; j < width; j++){
//                if (tiles[i][j].getEntity().getType() == EntityTypeEnum.Avatar){
//                    System.out.println(tiles[i][j].getEntity().getLocation());
////                    return tiles[i][j].getEntity().getLocation();
//                }
//            }
//        }
////        return null;
//    }

    public void setPlayerLocation(MapLocationPoint location){
        this.playerLocation = location;
    }

    public MapLocationPoint getPlayerLocation(){
        return playerLocation;
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

//    private void addToList(Entity e){
//        if(e.getType() == EntityTypeEnum.NPC){
//            npcLocations.add(e);
//        }
//        if(e.getType() == EntityTypeEnum.Avatar){
//
//        }
//        if(e.getType() == EntityTypeEnum.Pet){
//
//        }
//        if(e.getType() == EntityTypeEnum.Vehicle){
//
//        }
//    }

}
