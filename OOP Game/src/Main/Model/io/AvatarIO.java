package Main.Model.io;

import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Inventory.Inventory;
import Main.Model.Items.TakeAble;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Map.Tile;
import Main.Model.Occupation.Occupation;
import Main.Model.Occupation.Smasher;
import Main.Model.Occupation.Sneak;
import Main.Model.Occupation.Summoner;
import Main.Model.Stats.Stats;

import java.util.ArrayList;
import java.util.logging.FileHandler;

/**
 * Created by johnkaufmann on 3/12/16.
 * TODO:
 */
public class AvatarIO {

    io io;
    public AvatarIO() {
        this.io = new io();
    }

    //load an avatar given the current avatar and a filename
    public Avatar loadAvatar(Avatar avatar, String fileName) {
        /***************
         * Read a avatar file
         **************/

        ArrayList<String> FileData;
        FileData = io.readFile(fileName);


        //set up avatar parameters
        EntityTypeEnum type;
        Stats stats;
        Occupation occupation;
        Inventory inventory;
        MapLocationPoint location = new MapLocationPoint(0,0);
        int level = 1;

        //set the avatar parameters given file data
        for (int i = 0; i < FileData.size(); i++) {
            String line = FileData.get(i);
            String[] data = line.split(":", 2);
            switch (data[0]) {
                case "Name":
                    System.out.print("Loading " + data[1]);
                    break;
                case "Type":
                    System.out.println(" the " + data[1] + ".");
                    break;
                case "Occupation":
                    occupation = setOccupation(data[1]);
                    break;
                case "Level":
                    level = Integer.valueOf(data[1]);
                    break;
                case "Inventory":
                    inventory = setInventory(data[1]);
                    break;
                case "Location":
                    location = setLocation(data[1]);
                    break;
            }
        }

        //instantiate a new avatar;
        avatar = new Avatar(location);

        //level the entity up appropriately
        for (int i = 1; i < level; i++) {
            avatar.levelUp();
        }

        return avatar;
    }

    //load an avatar with no object or file name given
    public Avatar loadAvatar() {
        return loadAvatar(new Avatar(new MapLocationPoint(0,0)), "avatar");
    }

    //given a string x,y return the map location
    private MapLocationPoint setLocation(String s) {
        String[] loc = s.split(",");
        return new MapLocationPoint(Integer.valueOf(loc[0]),Integer.valueOf(loc[1]));
    }

    //given a count of how many items an entity and the index of the list along with the data of a file and the current inventory return an inventory
    private Inventory setInventory(int itemCount, int index, ArrayList<String> fileData, Inventory inventory) {
        // TODO: 3/12/16 uncomment when items implemented
//        for (int i = index; i < itemCount; i++) {
//            String[] line = fileData.get(i).split(":");
//            int individualItemCount = Integer.valueOf(line[1]);
//            for (int j = 0; j < individualItemCount; j++) {
//                inventory.addItem(new TakeAble(line[0]));
//            }
//        }
        return inventory;
    }

    //change in file structure TODO: 3/12/16 delete the old inventory creator if we keep this file struct
    private Inventory setInventory(String s) {
        Inventory inventory = new Inventory();

        // TODO: 3/12/16 uncomment when items are implemented
        String[] items = s.split(",");
        for (String item : items) {
//            inventory.addItem(new TakeAble(Integer.valueOf(item)));
        }

        return inventory;
    }

    //given a string containing the name of an occupation the file return an occupation (defaults to smasher if data corrupted)
    private Occupation setOccupation(String s) {
        switch (s) {
            case "Smasher":
                return new Smasher();
            case "Summoner":
                return new Summoner();
            case "Sneak":
                return new Sneak();
            default:
                System.out.print("ERROR IN OCCUPATION!");
                return new Smasher();
        }
    }

    public void saveAvatar(Avatar avatar) {
        ArrayList<String> fileData = new ArrayList<>();

        /**
         * Name:John
         * Type:Avatar
         * Occupation:Smasher
         * Level:3
         * Inventory:3
         * Takeable1:1
         * Takable2:1
         * Takable3:3
         * Location:0,2
         */

        String typeFormat = null;
        fileData.add(getName("Name:", avatar));
        fileData.add(getType("Type:", avatar));
        fileData.add(getOccupation("Occupation:", avatar));
        fileData.add(getLevel("Level:", avatar));
        // TODO: 3/12/16 uncomment when we finish printing out the inventory
//        fileData.add(getInventory("Inventory:", avatar));
        fileData.add(getLocation("Location:", avatar));

        io.writeFile(fileData,"avatar");
    }

    private String getLocation(String locationFormat, Avatar avatar) {
        return locationFormat + String.valueOf(avatar.getLocation().x)+","+String.valueOf(avatar.getLocation().y);
    }

    // TODO: 3/12/16 implement get inventory and shit
    private String getInventory(String inventoryFormat, Avatar avatar) {
        return avatar.toString();
    }

    private String getLevel(String levelFormat, Avatar avatar) {
        return levelFormat += String.valueOf(avatar.getStats().level());
    }

    private String getOccupation(String occupationFormat, Avatar avatar) {
        return occupationFormat + avatar.getOccupation().toString();
    }

    private String getType(String typeFormat, Avatar avatar) {
        switch (avatar.getType()) {
            case Avatar:
                return typeFormat + "Avatar";
            case NPC:
                return typeFormat + "NPC";
            case Pet:
                return typeFormat + "Pet";
            case Vehicle:
                return typeFormat + "Vehicle";
            default:
                return typeFormat + "NPC";
        }
    }

    // TODO: 3/12/16 change this if we implement a way to see the avatars name
    private String getName(String nameFormat, Avatar avatar) {
        return nameFormat + "John";
    }
}
