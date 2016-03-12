package Main.Model.io;

import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;
import Main.Model.Map.Tile;

import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/12/16.
 * TODO:
 */
public class AvatarIO {

    io io;
    public AvatarIO() {
    }

    public Avatar saveAvatar(Avatar avatar, String fileName) {
        /***************
         * Read a avatar file
         **************/

        ArrayList<String> FileData;
        FileData = io.readFile(fileName);

        /**
         * protected EntityTypeEnum type;
         * protected Stats stats;
         * protected Occupation occupation;
         * protected Inventory inventory;
         * protected MapLocationPoint location;
         */

        //remove the first line of the map file data for passing to construct map
        FileData.remove(0);



        //set the avatar

        //TODO: implement the loadMap entity array

        return avatar;
    }
}
