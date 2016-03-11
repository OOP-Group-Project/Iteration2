package Main.Model.io;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/11/16.
 * TODO:
 */
public class io {
    public io() {
    }

    public ArrayList<String> readFile(String fileName) {
        ArrayList<String> FileData = new ArrayList<>();

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

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
