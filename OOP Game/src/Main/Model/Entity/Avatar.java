package Main.Model.Entity;

import Main.Model.DirectionEnum;
import Main.Model.Occupation.Occupation;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Smasher;
import Main.Model.Stats.StatsModifier;
import Main.View.Graphics.GraphicsAssets;

import java.awt.*;

/**
 * Created by walkhard on 2/18/16. Modified by John Kaufmann 3/9/16
 * TODO: Go over this class with mason to make sure nothing was wrongfully altered.
 * TODO: Implement methods.
 */
public class Avatar extends Entity{

    private boolean[][] areaSeen;
    private int radius = 5;


    public Avatar(MapLocationPoint location) {
        super(EntityTypeEnum.Avatar, EntitySpeechEnum.PLAYER, new Smasher(), location);
    }

    public Avatar(Occupation o, MapLocationPoint location) {
        super(EntityTypeEnum.Avatar, EntitySpeechEnum.PLAYER, o, location);
    }



    public void initAreaSeen(int row, int col){
        areaSeen = new boolean[row][col];
        for (int i =0; i < row; i ++){
            for(int j = 0; j < col; j++){
                areaSeen[i][j] = false;
            }
        }
    }

    public void seeAround(){
        
    }

    public boolean areaBeenSeen(int x, int y){
        return areaSeen[x][y];
    }

    public void setLocation(MapLocationPoint location) {
        super.setLocation(location);
        seeAround();
    }
}
