package Main.Model.io;

import Main.Model.Items.*;
import Main.Model.Items.ItemBuilders.*;
import Main.Model.Map.Map;
import Main.Model.Map.Tile;

import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/12/16.
 * TODO: implement this class
 */
public class ItemsIO {
    io io = new io();
    public ItemsIO() {
    }

    public Map loadItemsToMap(Map map, String fileName) {
        ArrayList<String> data = new io().readFile(fileName);

        for (String d : data) {
            System.out.println(d);
            String[] itemdata = d.split("-");
            String[] coordinates = itemdata[1].split(",");
            int x = Integer.valueOf(coordinates[0]);
            int y = Integer.valueOf(coordinates[1]);
            Item item = getItem(itemdata[0]);
            int itemcount = Integer.valueOf(itemdata[2]);
            for (int i = 0; i < itemcount; i++) {
                map.addItem(item,x,y);
            }
        }
        return map;
    }

    /**
     * Determine item given id;
     */

    private Item getItem(String id) {
        int idnum = Integer.valueOf(id);
        if (idnum > 0 && idnum < 8) return getWeapon(idnum); //new ItemBuilder().TakableItem().WeaponBuilder
        else if (idnum < 23) return getArmor(idnum); //new ItemBuilder().Takeable().ArmorBuilder
        else if (idnum < 25) return getOneShot(idnum); //new ItemBuilder().OneshotBuilder()
        else if (idnum < 26) return getInteractive(idnum); //new ItemBuilder().InteractiveItem().
        else return null;
    }

    private Item getOneShot(int idnum) {
        switch (idnum) {
            case 23:
                return new OneshotBuilder("Key", 23).build();
            case 24:
                return new OneshotBuilder("FarSight", 26).build();
            default:
                System.out.println("Something went wrong in " + this.toString());
                return null;
        }
    }

    private Item getArmor(int idnum) {
        switch (idnum) {
            case 8:
                return new ArmorBuilder(ArmorTypeEnum.HEAD, "HeartyHeadPiece", 8).build();

            case 9:
                return new ArmorBuilder(ArmorTypeEnum.CHEST, "HeartyChestPiece", 9).build();

            case 10:
                return new ArmorBuilder(ArmorTypeEnum.LEGS, "HeartyLegPiece", 10).build();

            case 11:
                return new ArmorBuilder(ArmorTypeEnum.GLOVES, "HeartyGloves", 11).build();

            case 12:
                return new ArmorBuilder(ArmorTypeEnum.BOOTS, "HeartyBoots", 12).build();

            case 13:
                return new ArmorBuilder(ArmorTypeEnum.TRINKET, "HeartyShield", 13).build();

            case 14:
                return new ArmorBuilder(ArmorTypeEnum.HEAD, "SneakyHeadPiece", 14).build();

            case 15:
                return new ArmorBuilder(ArmorTypeEnum.CHEST, "SneakyChestPiece", 15).build();

            case 16:
                return new ArmorBuilder(ArmorTypeEnum.LEGS, "SneakyLegPiece", 16).build();

            case 17:
                return new ArmorBuilder(ArmorTypeEnum.GLOVES, "SneakyGloves", 17).build();

            case 18:
                return new ArmorBuilder(ArmorTypeEnum.BOOTS, "SneakyBoots", 18).build();

            case 19:
                return new ArmorBuilder(ArmorTypeEnum.TRINKET, "MagicShield", 19).build();

            case 20:
                return new ArmorBuilder(ArmorTypeEnum.HEAD, "MagicHeadPiece", 20).build();

            case 21:
                return new ArmorBuilder(ArmorTypeEnum.CHEST, "MagicChestPiece", 21).build();

            case 22:
                return new ArmorBuilder(ArmorTypeEnum.CHEST, "MagicLegPiece", 22).build();

            case 23:
                return new ArmorBuilder(ArmorTypeEnum.GLOVES, "MagicGloves", 23).build();

            case 24:
                return new ArmorBuilder(ArmorTypeEnum.BOOTS, "MagicBoots", 24).build();

            case 25:
                return new ArmorBuilder(ArmorTypeEnum.TRINKET, "MagicShield", 25).build();
            default:
                System.out.println("Something went wrong in " + this.toString());
                return null;
        }
    }

    private Item getWeapon(int idnum) {
        switch (idnum) {
            case 1:
                return new WeaponBuilder(WeaponTypeEnum.ONEHANDSWORD, "Katana", idnum).build();

            case 2:
                return new WeaponBuilder(WeaponTypeEnum.TWOHANDSWORD, "LongSword", idnum).build();

            case 3:
                return new WeaponBuilder(WeaponTypeEnum.SPECIAL, "Mace", idnum).build();

            case 4:
                return new WeaponBuilder(WeaponTypeEnum.DAGGER, "Dagger", idnum).build();

            case 5:
                return new WeaponBuilder(WeaponTypeEnum.BOW, "Bow", idnum).build();

            case 6:
                return new WeaponBuilder(WeaponTypeEnum.SPECIAL, "Dagger", idnum).build();

            case 7:
                return new WeaponBuilder(WeaponTypeEnum.STAFF, "Staff", idnum).build();
            default:
                System.out.println("Something went wrong in " + this.toString());
                return null;
        }
    }

    private Item getInteractive(int idnum) {
        switch (idnum) {
            case 25:
                return new InteractiveBuilder("Key", 25).build();
            case 26:
                return new InteractiveBuilder("ExpandView", 26).build();
            default:
                System.out.println("Something went wrong in " + this.toString());
                return null;
        }
    }

    public void saveItemsOnMap(Map map, String fileName){
        ArrayList<String> data = new ArrayList<>();
        for (int x = 0; x < map.getHeight(); x++) {
            for (int y = 0; y < map.getWidth(); y++) {
                for (String str : map.getTile(x,y).toTileString()) {
                    data.add(str+"-"+x+","+y+"-1");
                }
            }
        }
        io.writeFile(data, "Items.txt");
    }
}
