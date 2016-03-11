package Main.Model.io;

import Main.Model.Map.Map;
import Main.Model.Map.Tile;
import Main.Model.Model;
import Main.Model.Terrain.TerrainTypeEnum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/11/16.
 * TODO:
 */
public class MapIO {

    io io;
    public MapIO() {
        this.io = new io();
    }

    //method will instantiate a loadMap controller and return a model
    public Map loadMap(Map map) {
        /***************
         * Read a map
         **************/

        // The name of the file to open.
        String FileName = "map";

        ArrayList<String> FileData;
        FileData = io.readFile(FileName);

        //get the map dimensions
        String[] size = FileData.get(0).split(",",2);
        int width = Integer.valueOf(size[0]);
        int height = Integer.valueOf(size[1]);

        //remove the first line of the map file data for passing to construct map
        FileData.remove(0);

        //intiailize tiles array
        Tile[][] mapTiles = loadTiles(FileData, new Tile[width][height]);

        //set the up the new map
        map.setHeight(height);
        map.setWidth(width);
        map.setTiles(mapTiles);

        //set the avatar

        //TODO: implement the loadMap entity array

        return map;
    }

    //use this method to just generate the map from the data, no existing map needed!
    public Map loadMap() {
        /***************
         * Read a map
         **************/

        // The name of the file to open.
        String FileName = "map";

        ArrayList<String> FileData;
        FileData = io.readFile(FileName);

        //get the map dimensions
        String[] size = FileData.get(0).split(",",2);
        int width = Integer.valueOf(size[0]);
        int height = Integer.valueOf(size[1]);

        //instantiate the map
        Map map = new Map(width,height);

        //remove the first line of the map file data for passing to construct map
        FileData.remove(0);

        //intiailize tiles array
        Tile[][] mapTiles = loadTiles(FileData, new Tile[width][height]);

        //set the up the new map
        map.setHeight(height);
        map.setWidth(width);
        map.setTiles(mapTiles);

        //set the avatar

        //TODO: implement the loadMap entity array

        return map;
    }

    //should be able to read from a path and set up the map
    public Tile[][] loadTiles(ArrayList<String> data, Tile[][] tiles){
        for(int i = 0; i < data.size(); i++){
            String[] line = data.get(i).split(",");
            for (int j = 0; j < line.length; j++){
                int dataValue = Integer.valueOf(line[j]);
                if (dataValue < 10) tiles[i][j] = new Tile(TerrainTypeEnum.Grass,0,i,j);
                else if (dataValue < 20) tiles[i][j] = new Tile(TerrainTypeEnum.Mountain,0,i,j);
                else tiles[i][j] = new Tile(TerrainTypeEnum.Water,0,i,j);
            }
        }
        return tiles;
    }
}
