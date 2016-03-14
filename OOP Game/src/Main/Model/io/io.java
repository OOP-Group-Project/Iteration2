package Main.Model.io;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/11/16.
 * INSTRUCTIONS: Given a file name it will break that file up based on its comma seperated values (CSV)
 * and store it into an array list that may be altered in a specific IO controller. Please note that
 * save file must have pre-formatted array list data. That means that there needs to be a seperate class
 * specific to that model that pre-formats the data before sending it to be saved.
 *
 * USE CASE: new io().readFile(stringfile) and new io().saveFile(pre-formatted array data). See MapIO for
 * example use cases. Should only be used in the io package.
 */
public class io {
    public io() {
    }

    public ArrayList<String> readFile(String fileName) {
        ArrayList<String> fileData = new ArrayList<>();

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            while ((line = bufferedReader.readLine()) != null) {
                fileData.add(line);
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file named "+fileName+" it wasn't found! Copy it from the repo Andy!");
            System.exit(2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileData;
    }

    public void writeFile(ArrayList<String> data, String fileName) {
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                    new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            for (String line : data) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
