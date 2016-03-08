package Main.View.Renderers;

import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Map.Map;
import Main.Model.Map.Tile;
import Main.Model.Terrain.TerrainTypeEnum;
import Main.View.Graphics.GraphicsAssets;
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

    /*
     * The map renderer class provides a render method that will render a portion of the map, given start and end points in
     * map coordinates.  It will center the rendered map on screen no matter how large the map or how large the rendering window.
     */
    public static class mapRenderer {
        public static void render(Graphics g, Map map, int mapStartX, int mapEndX, int mapStartY, int mapEndY) {

             /*
              * TODO: Given how many tiles we want to render and the size of the window, calculate an offset so that
              * the map is always centered in the window.
              */


            for(int y = mapStartY; y < mapEndY; y++){
                for(int x = mapStartX; x < mapEndX; x++){
                    // TODO: Fix this so that it uses the offset.  This will not work currently!
                    Point pxCenterPoint = new Point(view.getPxWidth()/2, view.getPxHeight()/2);
                        tileRenderer.render(g, map.getTile(x,y), pxCenterPoint);
                }
            }
        }
    }

    /*
     * The tile renderer is only in charge of rendering the type of terrain and any non-moving things that are on it.
     * Entities move, so they will not be rendered by the tileRenderer.
     *
     * The tileRenderer will render a tile and anything it is supposed to render given its pixel center point on screen.
     */
    public static class tileRenderer {
        public static void render(Graphics g, Tile tile, Point pxCenterPoint) {
            TerrainTypeEnum type = tile.getTerrainType();

            // Calculate location that the tile needs to be rendered using the pxCenterPoint


            // Render the correct image.
            if(type == TerrainTypeEnum.Grass) {
                //g.drawImage(graphicsAssets.grass, x, y, width, height);

            } else if(type == TerrainTypeEnum.Water) {
                //g.drawImage(graphicsAssets.water, x, y, width, height);

            } else if(type == TerrainTypeEnum.Mountain) {
                //g.drawImage(graphicsAssets.mountain, x, y, width, height);
            }

            // Render everything else (Items, area effects, etc.) except entities.

        }
    }

    public static class entityRenderer {
        public static void render(Graphics g, Entity entity, Point pxCenterPoint) {
            // Calculate the top left corner from the center point

            // Render the correct image
            EntityTypeEnum type = entity.getType();
            if(type == EntityTypeEnum.Avatar) {
                // Check occupation

                // render the correct image for the avatar's occupation.
            }
        }
    }
}
