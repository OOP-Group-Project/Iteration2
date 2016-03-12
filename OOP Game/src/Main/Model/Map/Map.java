package Main.Model.Map;

import Main.Model.AreaEffect.AreaEffect;
import Main.Model.Entity.Entity;
import Main.Model.Items.Item;
import Main.Model.Terrain.TerrainTypeEnum;


public class Map {
	//MAP DIMENSIONS
	private Tile[][] tiles;
    private int width;
    private int height;
	private boolean visited[][];

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
                tiles[i][j] = new Tile(TerrainTypeEnum.Grass,false,0,i,j);
            }
        }
	}
	
	//should be able to read from a path and set up the map
	public void loadMap(String path){
		
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

	public boolean isWalkable(int x, int y){
		return tiles[x][y].isWalkable();
	}

	public float getCost(int sx, int sy, int tx, int ty){
		return 1;
	}

	public void pathFinderVisited(int x, int y) {
		visited[x][y] = true;
	}

}
