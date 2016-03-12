package Main.Model.io;

import Main.Model.Map.Map;
import Main.Model.Map.Tile;
import Main.Model.Terrain.TerrainTypeEnum;

import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/11/16.
 * INSTRUCTIONS: Call new MapIO().load(parameters) to load a previous game's map.txt
 * and new MapIO().save(map.txt) to save the current game's map.txt.
 *
 * USE CASE: Check Model to see an example of it instantiating the world
 */
public class MapIO {

    io io;
    public MapIO() {
        this.io = new io();
    }

    //method will instantiate a loadMap controller and return a model
    public Map loadMap(Map map, String fileName) {
        /***************
         * Read a map.txt
         **************/

        ArrayList<String> FileData;
        FileData = io.readFile(fileName);

        //get the map.txt dimensions
        String[] size = FileData.get(0).split(",",2);
        int width = Integer.valueOf(size[0]);
        int height = Integer.valueOf(size[1]);

        //remove the first line of the map.txt file data for passing to construct map.txt
        FileData.remove(0);

        //intiailize tiles array
        Tile[][] mapTiles = loadTiles(FileData, new Tile[width][height]);

        //set the up the new map.txt
        map.setHeight(height);
        map.setWidth(width);
        map.setTiles(mapTiles);

        //set the avatar

        //TODO: implement the loadMap entity array

        return map;
    }

    //load map.txt given an existing map.txt
    public Map loadMap(Map map) {
        return loadMap(map, "map.txt");
    }

    //given a file name load a map.txt with all other generic properties
    public Map loadMap(String fileName) {
        return loadMap(new Map(0,0), fileName);
    }

    //load generic map.txt
    public Map loadMap() {
        return loadMap(new Map(0,0));
    }

    //should be able to read from a path and set up the map.txt
    private Tile[][] loadTiles(ArrayList<String> data, Tile[][] tiles){
        for(int j = 0; j < data.size(); j++){
            String[] line = data.get(j).split(",");
            for (int i = 0; i < line.length; i++){
                int dataValue = Integer.valueOf(line[i]);
                if(dataValue == 0) tiles[i][j] = new Tile(TerrainTypeEnum.None, 0);
                else if (dataValue < 10 && dataValue > 0) tiles[i][j] = new Tile(TerrainTypeEnum.Grass,0);
                else if (dataValue < 20 && dataValue > 0) tiles[i][j] = new Tile(TerrainTypeEnum.Mountain,0);
                else tiles[i][j] = new Tile(TerrainTypeEnum.Water,0);
            }
        }
        return tiles;
    }

    //given a map.txt and a filename it will write the file out in a io readable format
    public void saveMap(Map map, String fileName) {
        //initialize variables
        int height = map.getHeight();
        int width = map.getWidth();

        //turn data into array list
        ArrayList<String> data = new ArrayList<>();
        data.add(Integer.toString(width)+","+Integer.toString(height));

        //format object
        for (int j = 0; j < height; j++) {
            String line = "";
            String delimeter = ",";
            for (int i = 0; i < width; i++) {
                if (i+1 == width) delimeter = "";
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
                    case None:
                        line += "00" + delimeter;
                        break;
                }
            }
            data.add(line);
        }

        //serialize data
        io.writeFile(data, fileName);
    }

    //given a map.txt it will serialize and write a data file for that map.txt
    public void saveMap(Map map) {
        saveMap(map, "map.txt");
    }

}
