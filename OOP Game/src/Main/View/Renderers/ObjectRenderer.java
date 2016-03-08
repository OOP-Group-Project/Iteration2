package Main.View.Renderers;

import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.Map.Tile;
import Main.Model.Terrain.TerrainTypeEnum;
import Main.View.Camera;
import Main.View.Graphics.GraphicsAssets;
import Main.View.Renderers.StateViewports.StateViewport;
import Main.View.Viewport;

import java.awt.*;

/**
 * Created by mason on 3/6/16.
 */

// Note: this is named this way because there is already a "Renderer" class defined and it was causing issues.
public class ObjectRenderer {

    protected static Viewport view;
    protected static GraphicsAssets graphicsAssets;

    public ObjectRenderer(Viewport view, GraphicsAssets graphicsAssets) {
        this.view = view;
        this.graphicsAssets = graphicsAssets;
    }

    public static class mapRenderer {
        public static void render(Graphics g, Camera camera, Map map, int xStart, int xEnd, int yStart, int yEnd) {
            for(int y = yStart; y < yEnd; y++){
                for(int x = xStart; x < xEnd; x++){
                        tileRenderer.render(g, map.getTile(x,y));
                }
            }
        }
    }

    public static class tileRenderer {
        public static void render(Graphics g, Tile tile) {
            TerrainTypeEnum type = tile.getTerrainType();

            // Calculate location that the tile needs to be rendered.


            // Render the correct image.
            if(type == TerrainTypeEnum.Grass) {
                //g.drawImage(graphicsAssets.grass, x, y, width, height);

            } else if(type == TerrainTypeEnum.Water) {
                //g.drawImage(graphicsAssets.water, x, y, width, height);

            } else if(type == TerrainTypeEnum.Mountain) {
                //g.drawImage(graphicsAssets.mountain, x, y, width, height);
            }

            // Render everything else (Items, Entities, etc.)

        }
    }

    public static class entityRenderer {
        public static void render(Graphics g, Entity entity, int currentXPos, int currentYPos, int previousXPos, int previousYPos) {

        }
    }
}
