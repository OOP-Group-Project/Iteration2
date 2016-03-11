package Main.Model.io;

import Main.Model.Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by johnkaufmann on 3/10/16.
 * TODO:
 */
public class io {
    Model model;
    public io() {

    }

    public io(Model model) {
        this.model = model;
    }

    //method will instantiate a load controller and return a model
    public Model load() {
        //read a file
        String mapFileName = "map.txt";
        String avatarFileName = "map.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader mapFileReader = new FileReader(mapFileName);
            FileReader avatarFileReader = new FileReader(avatarFileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader mapBufferedReader = new BufferedReader(mapFileReader);
            BufferedReader avatarBufferedReader = new BufferedReader(avatarFileReader);

            while((line = mapBufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Always close files.
            mapBufferedReader.close();
            avatarBufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        //set the map

        //set the avatar

        //TODO: implement the load entity array

        return model;
    }

    //method will save a given model
    public boolean save(Model model) {

        return false;
    }
}
