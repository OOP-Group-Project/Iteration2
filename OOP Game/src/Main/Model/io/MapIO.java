package Main.Model.io;

import Main.Model.Map.Map;
import Main.Model.Map.Tile;
import Main.Model.Terrain.TerrainTypeEnum;

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
    public Map loadMap(Map map, String fileName) {
        /***************
         * Read a map
         **************/

        ArrayList<String> FileData;
        FileData = io.readFile(fileName);

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

    //load map given an existing map
    public Map loadMap(Map map) {
        return loadMap(map, "map");
    }

    //given a file name load a map with all other generic properties
    public Map loadMap(String fileName) {
        return loadMap(new Map(0,0), fileName);
    }

    //load generic map
    public Map loadMap() {
        return loadMap(new Map(0,0));
    }

    //should be able to read from a path and set up the map
    private Tile[][] loadTiles(ArrayList<String> data, Tile[][] tiles){
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

    //given a map it will serialize and write a data file for that map
    public void saveMap(Map map) {
        saveMap(map, "map.txt");
    }

    public void saveMap(Map map, String fileName) {
        //initialize variables
        int height = map.getHeight();
        int width = map.getWidth();

        //turn data into array list
        ArrayList<String> data = new ArrayList<>();
        data.add(Integer.toString(width)+","+Integer.toString(height));

        //format object
        for (int i = 0; i < height; i++) {
            String line = "";
            String delimeter = ",";
            for (int j = 0; j < width; j++) {
                if (j+1 == width) delimeter = "";
                switch (map.getTile(i,j).getTerrainType()) {
                    case Grass:
                        line += "01" + delimeter;
                        break;
                    case Mountain:
                        line += "10" + delimeter;
                        break;
                    case Water:
                        line += "20" + delimeter;
                        break;
                }
            }
            data.add(line);
        }

        //serialize data
        io.writeFile(data, fileName);
    }
}
