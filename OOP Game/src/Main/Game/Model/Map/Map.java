package Main.Game.Model.Map;

import Main.Game.Model.DirectionEnum;
import Main.Game.Model.Entity.Entity;
import Main.Game.Model.Items.Item;
import Main.Game.Model.Terrain.Water;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Map {
	
	//TILE IMAGE USE
	private BufferedImage tileset;
	private int numTilesAcross;
	
	//MAP DIMENSIONS
	private Tile[][] tiles;
	private int numRows;
	private int numCols;

	private int width;
	private int height;

	
	//should be able to read from a path and set up the color for the tiles
	public void createTestMap(){
        for(int i = 0; i < width; i++){
            for (int j = 0; j < width; j++){
                tiles[i][j] = new Tile(new Water(),0,i,j);
            }
        }
	}
	
	//should be able to read from a path and set up the map
	public void loadMap(String path){
		
	}

	public void addEntity(Entity e, int xLocation, int yLocation, DirectionEnum direction) {
		tiles[xLocation][yLocation].addEntity(e);
	}

	public void addItem(Item i, int xLocation, int yLocation) {
		tiles[xLocation][yLocation].addItem(i);
	}


	public void render(Graphics g){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y].render(g,x,y);
			}
		}
	}
}
