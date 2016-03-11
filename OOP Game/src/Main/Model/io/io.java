package Main.Model.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/11/16.
 * TODO:
 */
public class io {
    public io() {
    }

    public ArrayList<String> readFile(String FileName) {
        ArrayList<String> FileData = new ArrayList<>();

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(FileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            while ((line = bufferedReader.readLine()) != null) {
                FileData.add(line);
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return FileData;
    }
    public void writeFile() {

    }
}
