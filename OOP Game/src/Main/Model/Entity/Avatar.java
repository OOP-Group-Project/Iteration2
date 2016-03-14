package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Inventory.Inventory;
import Main.Model.Occupation.Occupation;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Skills.RadialEffect;
import sun.misc.Queue;

import java.util.ArrayList;
import Main.Model.Stats.StatsModifier;

/**
 * Created by walkhard on 2/18/16. Modified by John Kaufmann 3/9/16
 * TODO: Go over this class with mason to make sure nothing was wrongfully altered.
 * TODO: Implement methods.
 */
public class Avatar extends Entity{

    private float[][] areaSeen;
    private int radius = 5;

    public Avatar(Occupation o, MapLocationPoint location, int level, Inventory inv) {
        super(EntityTypeEnum.Avatar, EntitySpeechEnum.PLAYER, o, location, level, inv);
    }

    public Avatar(Occupation o, MapLocationPoint location) {
        super(EntityTypeEnum.Avatar, EntitySpeechEnum.PLAYER, o, location, 1, new Inventory());
    }

    public void initAreaSeen(int row, int col){
        areaSeen = new float[row][col];
        for (int i =0; i < row; i ++){
            for(int j = 0; j < col; j++){
                areaSeen[i][j] = -1;
            }
        }
    }

    private void setAreaSeen(){
        for (int i =0; i < areaSeen.length; i ++){
            for(int j = 0; j <areaSeen[0].length; j++){
               if(areaSeen[i][j] > -1) {
                   areaSeen[i][j] = 0.25f;
               }
            }
        }
    }

    public void seeAround(){
        setAreaSeen();
        areaSeen[location.x][location.y] = 1f;
        RadialEffect re = new RadialEffect();
        Queue<ArrayList<MapLocationPoint>> q = re.getAffectedArea(this.location.x,this.location.y,radius);

        ArrayList<MapLocationPoint> current;

        int r = radius;

        while (!q.isEmpty()) {

            try {
                    current = q.dequeue();
                    for (int i = 0; i < current.size(); i++) {
                    areaSeen[current.get(i).x][current.get(i).y] = r/(float)radius;
                    if(areaSeen[current.get(i).x][current.get(i).y] < 0.25f)
                        areaSeen[current.get(i).x][current.get(i).y] = 0.25f;
                }
                r--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public float[][] getAreaSeen(){
        return areaSeen;
    }

    public float areaBeenSeen(int x, int y){
        return areaSeen[x][y];
    }

    public void move(DirectionEnum dir) {
        super.move(dir);
        seeAround();
    }

    public void setLocation(MapLocationPoint location) {
        super.setLocation(location);
        seeAround();
    }
    public void respawn(MapLocationPoint location) {
        this.location.x = location.x;
        this.location.y = location.y;
        StatsModifier sm = new StatsModifier();
        sm = sm.builder().lifeModifier(15).build();
        this.stats.modifyStats(sm);
        // TODO: Reset avatar's stats when respawn
        //this.stats.reset();
    }

}
