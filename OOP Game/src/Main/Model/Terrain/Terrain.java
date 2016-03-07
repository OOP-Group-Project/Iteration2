package Main.Model.Terrain;

import Main.View.Graphics.ImageLoader;

import java.awt.image.BufferedImage;

/**
 * Created by walkhard on 2/18/16.
 */
public abstract class Terrain {

    protected BufferedImage terrainType;

    public Terrain(BufferedImage terrainType){
        this.terrainType = terrainType;
    }

    public abstract boolean isWalkable();
    public abstract boolean isHidden();

    public BufferedImage getTerrainType(){
        return terrainType;
    }
}
