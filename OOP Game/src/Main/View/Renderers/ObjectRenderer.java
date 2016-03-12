package Main.View.Renderers;

import Main.Model.AreaEffect.AreaEffect;
import Main.Model.AreaEffect.AreaEffectEnum;
import Main.Model.AreaEffect.HealDamage;
import Main.Model.AreaEffect.TakeDamage;
import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Items.Item;
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
     * The map.txt renderer class provides a render method that will render a portion of the map.txt, given start and end points in
     * map.txt coordinates.  It will center the rendered map.txt on screen no matter how large the map.txt or how large the rendering window.
     */
    public static class mapRenderer {
        public static void render(Graphics g, Map map, Point mapCenterPoint, int mapStartX, int mapEndX, int mapStartY, int mapEndY) {
            for(int y = mapStartY; y < mapEndY; y++){
                for(int x = mapStartX; x < mapEndX; x++){
                    Point pxCenterPoint;
                    if(x % 2 != 0) {
                        int pxX = (int)((x - mapCenterPoint.x)*(0.75*graphicsAssets.TILE_PX_WIDTH)) + view.getWidth()/2;
                        int pxY = ((mapCenterPoint.x % 2 == 0)? graphicsAssets.TILE_PX_HEIGHT/2 : 0) + ((y - mapCenterPoint.y)*graphicsAssets.TILE_PX_HEIGHT) + view.getHeight()/2;
                        pxCenterPoint = new Point(pxX, pxY);
                    } else {
                        int pxX = (int)((x - mapCenterPoint.x)*(0.75*graphicsAssets.TILE_PX_WIDTH)) + view.getWidth()/2;
                        int pxY = ((mapCenterPoint.x % 2 != 0)? -1 * graphicsAssets.TILE_PX_HEIGHT/2 : 0) + ((y - mapCenterPoint.y)*graphicsAssets.TILE_PX_HEIGHT) + view.getHeight()/2;
                        pxCenterPoint = new Point(pxX, pxY);
                    }
                    tileRenderer.render(g, map.getTile(x,y), pxCenterPoint);
                }
            }
        }
    }

    public static class entityRenderer {
        public static void render(Graphics g, Entity entity, Point mapCenterPoint, Point pxRenderOffset) {
            Point pxCenterPoint;
            if(entity.getLocation().x % 2 != 0) {
                int pxX = (int)((entity.getLocation().x - mapCenterPoint.x)*(0.75*graphicsAssets.TILE_PX_WIDTH)) + view.getWidth()/2;
                int pxY = ((mapCenterPoint.x % 2 == 0)? graphicsAssets.TILE_PX_HEIGHT/2 : 0) + ((entity.getLocation().y - mapCenterPoint.y)*graphicsAssets.TILE_PX_HEIGHT) + view.getHeight()/2;
                pxCenterPoint = new Point(pxX, pxY);
            } else {
                int pxX = (int)((entity.getLocation().x - mapCenterPoint.x)*(0.75*graphicsAssets.TILE_PX_WIDTH)) + view.getWidth()/2;
                int pxY = ((mapCenterPoint.x % 2 != 0)? -1*graphicsAssets.TILE_PX_HEIGHT/2 : 0) + ((entity.getLocation().y - mapCenterPoint.y)*graphicsAssets.TILE_PX_HEIGHT) + view.getHeight()/2;
                pxCenterPoint = new Point(pxX, pxY);
            }

            pxCenterPoint.x += pxRenderOffset.x;
            pxCenterPoint.y += pxRenderOffset.y;

            // Calculate the top left corner from the center point
            // Render the correct image
            EntityTypeEnum type = entity.getType();
            if(type == EntityTypeEnum.Avatar) {
                // Check occupation
                g.setColor(new Color(0,0,0));
                g.fillOval(pxCenterPoint.x - 25, pxCenterPoint.y - 25, 50, 50);
                // render the correct image for the avatar's occupation.
            }

            // Calculate location that the tile needs to be rendered using the pxCenterPoint
            Point topLeft = new Point(pxCenterPoint.x - (graphicsAssets.TILE_PX_WIDTH/2), pxCenterPoint.y - (graphicsAssets.TILE_PX_HEIGHT/2));

            if (type == EntityTypeEnum.NPC){
                g.drawImage(GraphicsAssets.skeletonWalk,topLeft.x,topLeft.y ,graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT,null);
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
            Point topLeft = new Point(pxCenterPoint.x - (graphicsAssets.TILE_PX_WIDTH/2), pxCenterPoint.y - (graphicsAssets.TILE_PX_HEIGHT/2));

            // Render the correct image.
            if(type == TerrainTypeEnum.Grass) {
                g.drawImage(graphicsAssets.grass, topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);
            } else if(type == TerrainTypeEnum.Water) {
                g.drawImage(graphicsAssets.water, topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);

            } else if(type == TerrainTypeEnum.Mountain) {
                g.drawImage(graphicsAssets.mountain, topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);
            }

            // Render everything else (Items, area effects, etc.) except entities.
            if(tile.hasAreaEffect()) {
                // Render HealDamage AreaEffect
                areaEffectRenderer.render(g, tile.getAreaEffect(), topLeft);
            }
        }
    }

    public static class itemRenderer {
        public static void render(Graphics g, Item item, Point pxCenterPoint) {
//            ItemTypeEnum type = item.getType();
//
//            switch(type) {

            //}
        }
    }

    public static class areaEffectRenderer{
        public static void render(Graphics g, AreaEffect areaEffect, Point pxTopLeftPoint){
            AreaEffectEnum type = areaEffect.getType();
//            System.out.println("type: " + areaEffect.getType());

            switch(type){
                case Heal:
                      g.drawImage(graphicsAssets.greenPlus,pxTopLeftPoint.x,pxTopLeftPoint.y,null);
                      break;
                case Damage:
                    g.drawImage(graphicsAssets.redCross,pxTopLeftPoint.x,pxTopLeftPoint.y,null);
                    break;
                case LevelUp:
                    g.drawImage(graphicsAssets.goldStar,pxTopLeftPoint.x,pxTopLeftPoint.y,null);
                    break;
                case Death:
                    g.drawImage(graphicsAssets.skullCrossBones,pxTopLeftPoint.x,pxTopLeftPoint.y,null);
                    break;
                case Portal:
                    g.drawImage(graphicsAssets.portal, pxTopLeftPoint.x,pxTopLeftPoint.y,null);
            }
        }
    }

}
