package Main.Model.io;

import Main.Model.AreaEffect.*;
import Main.Model.AreaEffect.Traps.Trap;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Map.Tile;

import java.util.ArrayList;

/**
 * Created by johnkaufmann on 3/12/16.
 * TODO: implement this class
 */
public class AreaEffectsIO {
    io io = new io();
    ArrayList<AreaEffect> AEList;
    public AreaEffectsIO() {
    }

    public Map loadAreaEffectsToMap(Map map, String fileName) {
        ArrayList<String> data = io.readFile(fileName);
        for (String str : data) {
            String[] datapoints = str.split("-");
            String[] location = datapoints[1].split(",");
            String[] constructor = datapoints[0].split(",");
            int x = Integer.valueOf(location[0]);
            int y = Integer.valueOf(location[1]);
            MapLocationPoint point = new MapLocationPoint(x,y);
            Tile tile = map.getTile(x,y);
            AreaEffect ae;
            double x1 = Double.valueOf(constructor[1]);
            int x2 = Integer.valueOf(datapoints[2]);
            switch (constructor[0]) {
                case "0":
                    ae = new HealDamage(x1,x2,point);
                    tile.addAreaEffect(ae);
                    break;
                case "1":
                    ae =new InstantDeath(point);
                    tile.addAreaEffect(ae);
                    break;
                case "2":
                    ae =new LevelUp(point);
                    tile.addAreaEffect(ae);
                    break;
                case "3":
                    ae =new TakeDamage(x1,x2,point);
                    tile.addAreaEffect(ae);
                    break;
                case "4":
                    // TODO: 3/14/16 add for portals
                    break;
                case "5":
                    ae =new Trap(point);
                    tile.addAreaEffect(ae);
                    break;
                case "6":
                    ae =new SpeedUp(x1,x2,point);
                    tile.addAreaEffect(ae);
                    break;
            }
        }
        return map;
    }

    public ArrayList<AreaEffect> getAreaEffectsList(String fileName) {
        ArrayList<String> data = io.readFile(fileName);
        AEList = new ArrayList<>();
        for (String str : data) {
            String[] datapoints = str.split("-");
            String[] location = datapoints[1].split(",");
            String[] constructor = datapoints[0].split(",");
            int x = Integer.valueOf(location[0]);
            int y = Integer.valueOf(location[1]);
            MapLocationPoint point = new MapLocationPoint(x,y);
            double x1 = Double.valueOf(constructor[1]);
            int x2 = Integer.valueOf(datapoints[2]);
            switch (constructor[0]) {
                case "0":
                    AEList.add(new HealDamage(x1,x2,point));
                    break;
                case "1":
                    AEList.add(new InstantDeath(point));
                    break;
                case "2":
                    AEList.add(new LevelUp(point));
                    break;
                case "3":
                    AEList.add(new TakeDamage(x1,x2,point));
                    break;
                case "4":
                    // TODO: 3/14/16 add for portals
                    break;
                case "5":
                    AEList.add(new Trap(point));
                    break;
                case "6":
                    AEList.add(new SpeedUp(x1,x2,point));
                    break;
            }
        }
        return AEList;
    }

    public void saveAreaEffectsFromMap(Map map, String fileName) {
        ArrayList<String> data = new ArrayList<>();
        for (int x = 0; x < map.getHeight(); x++) {
            for (int y = 0; y < map.getWidth(); y++) {
                if (map.getTile(x,y).hasAreaEffect()) {
                    AreaEffect areaEffect = map.getTile(x, y).getAreaEffect();
                    AreaEffectEnum ae = areaEffect.getType();
                    switch (ae) {
                        case HEAL:
                            data.add(ae.ordinal() + "-" + x + "," + y + areaEffect.getCharge());
                            break;
                        case DEATH:
                            data.add(ae.ordinal() + "-" + x + "," + y + areaEffect.getCharge());
                            break;
                        case LEVELUP:
                            data.add(ae.ordinal() + "-" + x + "," + y + areaEffect.getCharge());
                            break;
                        case DAMAGE:
                            data.add(ae.ordinal() + "-" + x + "," + y + areaEffect.getCharge());
                            break;
                        case PORTAL:
                            data.add(ae.ordinal() + "-" + x + "," + y + areaEffect.getCharge());
                            break;
                        case TRAP:
                            data.add(ae.ordinal() + "-" + x + "," + y + areaEffect.getCharge());
                            break;
                        case SPEEDUP:
                            data.add(ae.ordinal() + "-" + x + "," + y + areaEffect.getCharge());
                            break;
                    }
                }
            }
        }
        io.writeFile(data, "AreaEffects.txt");
    }
}
