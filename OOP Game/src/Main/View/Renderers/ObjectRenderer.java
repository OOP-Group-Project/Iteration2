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
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

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

        public static void render(Graphics g, Map map, Point mapCenterPoint, int mapStartX, int mapEndX, int mapStartY, int mapEndY ,float[][] value) {
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
                    tileRenderer.render(g, map.getTile(x,y), pxCenterPoint, value[x][y]);
                }
            }
        }
    }

    public static class entityRenderer {
        public static void render(Graphics g, Entity entity, Point mapCenterPoint, Point pxRenderOffset){
            render(g,entity,mapCenterPoint,pxRenderOffset,1f);
        }

        public static void render(Graphics g, Entity entity, Point mapCenterPoint, Point pxRenderOffset,float value) {

            if(value > 0.25f) {

                Point pxCenterPoint;
                if (entity.getLocation().x % 2 != 0) {
                    int pxX = (int) ((entity.getLocation().x - mapCenterPoint.x) * (0.75 * graphicsAssets.TILE_PX_WIDTH)) + view.getWidth() / 2;
                    int pxY = ((mapCenterPoint.x % 2 == 0) ? graphicsAssets.TILE_PX_HEIGHT / 2 : 0) + ((entity.getLocation().y - mapCenterPoint.y) * graphicsAssets.TILE_PX_HEIGHT) + view.getHeight() / 2;
                    pxCenterPoint = new Point(pxX, pxY);
                } else {
                    int pxX = (int) ((entity.getLocation().x - mapCenterPoint.x) * (0.75 * graphicsAssets.TILE_PX_WIDTH)) + view.getWidth() / 2;
                    int pxY = ((mapCenterPoint.x % 2 != 0) ? -1 * graphicsAssets.TILE_PX_HEIGHT / 2 : 0) + ((entity.getLocation().y - mapCenterPoint.y) * graphicsAssets.TILE_PX_HEIGHT) + view.getHeight() / 2;
                    pxCenterPoint = new Point(pxX, pxY);
                }

                pxCenterPoint.x += pxRenderOffset.x;
                pxCenterPoint.y += pxRenderOffset.y;

                // Calculate the top left corner from the center point
                // Render the correct image
                EntityTypeEnum type = entity.getType();
                if (type == EntityTypeEnum.Avatar) {
                    // Check occupation
                    g.setColor(new Color(0, 0, 0));
                    g.fillOval(pxCenterPoint.x - 25, pxCenterPoint.y - 25, 50, 50);
                    // render the correct image for the avatar's occupation.
                }

                // Calculate location that the tile needs to be rendered using the pxCenterPoint
                Point topLeft = new Point(pxCenterPoint.x - (graphicsAssets.TILE_PX_WIDTH / 2), pxCenterPoint.y - (graphicsAssets.TILE_PX_HEIGHT / 2));

                BufferedImage img;
                Graphics2D graphics;
                float[] scales = { 1f, 1f, 1f, value };
                float[] offsets = new float[4];
                RescaleOp rop = new RescaleOp(scales, offsets, null);

                if (type == EntityTypeEnum.NPC) {
                    img = new BufferedImage(GraphicsAssets.skeletonWalk.getWidth(), GraphicsAssets.skeletonWalk.getHeight(), BufferedImage.TRANSLUCENT);
                    graphics = img.createGraphics();

                    /* Draw the image, applying the filter */
                    graphics.drawImage(GraphicsAssets.skeletonWalk, rop, 0, 0);

                    g.drawImage(img, topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);
                } else if (type == EntityTypeEnum.Pet) {
                    img = new BufferedImage(GraphicsAssets.pet.getWidth(), GraphicsAssets.pet.getHeight(), BufferedImage.TRANSLUCENT);
                    graphics = img.createGraphics();

                    /* Draw the image, applying the filter */
                    graphics.drawImage(GraphicsAssets.pet, rop, 0, 0);

                    g.drawImage(img, topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);
                } else if (type == EntityTypeEnum.Mount) {
                    img = new BufferedImage(GraphicsAssets.pet.getWidth(), GraphicsAssets.pet.getHeight(), BufferedImage.TRANSLUCENT);
                    graphics = img.createGraphics();

                    /* Draw the image, applying the filter */
                    graphics.drawImage(GraphicsAssets.pet, rop, 0, 0);

                    g.drawImage(img, topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);
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
        public static void render(Graphics g, Tile tile, Point pxCenterPoint){
            render( g, tile,  pxCenterPoint,1);
        }

        public static void render(Graphics g, Tile tile, Point pxCenterPoint,float value) {
            TerrainTypeEnum type = tile.getTerrainType();


                // Calculate location that the tile needs to be rendered using the pxCenterPoint
                Point topLeft = new Point(pxCenterPoint.x - (graphicsAssets.TILE_PX_WIDTH / 2), pxCenterPoint.y - (graphicsAssets.TILE_PX_HEIGHT / 2));
            if(value >= 0) {


                // Render the correct image.
                if (type == TerrainTypeEnum.Grass) {

                    BufferedImage img = new BufferedImage(graphicsAssets.grass.getWidth(), graphicsAssets.grass.getHeight(), BufferedImage.TRANSLUCENT);
                    Graphics2D graphics = img.createGraphics();

                    float[] scales = { 1f, 1f, 1f, value };
                    float[] offsets = new float[4];
                    RescaleOp rop = new RescaleOp(scales, offsets, null);

                    /* Draw the image, applying the filter */
                    graphics.drawImage(graphicsAssets.grass, rop, 0, 0);
                    //graphics.dispose();
                    g.drawImage(img,topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);

                    //g.drawImage(graphicsAssets.grass, topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);
                } else if (type == TerrainTypeEnum.Water) {
                    BufferedImage img = new BufferedImage(graphicsAssets.water.getWidth(), graphicsAssets.water.getHeight(), BufferedImage.TRANSLUCENT);
                    Graphics2D graphics = img.createGraphics();

                    float[] scales = { 1f, 1f, 1f, value };
                    float[] offsets = new float[4];
                    RescaleOp rop = new RescaleOp(scales, offsets, null);

                    /* Draw the image, applying the filter */
                    graphics.drawImage(graphicsAssets.water, rop, 0, 0);
                    //graphics.dispose();
                    g.drawImage(img,topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);



                    //  g.drawImage(graphicsAssets.water, topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);

                } else if (type == TerrainTypeEnum.Mountain) {
                    BufferedImage img = new BufferedImage(graphicsAssets.mountain.getWidth(), graphicsAssets.mountain.getHeight(), BufferedImage.TRANSLUCENT);
                    Graphics2D graphics = img.createGraphics();

                    float[] scales = { 1f, 1f, 1f, value };
                    float[] offsets = new float[4];
                    RescaleOp rop = new RescaleOp(scales, offsets, null);

                    /* Draw the image, applying the filter */
                    graphics.drawImage(graphicsAssets.mountain, rop, 0, 0);
                    //graphics.dispose();
                    g.drawImage(img,topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);



                    //g.drawImage(graphicsAssets.mountain, topLeft.x, topLeft.y, graphicsAssets.TILE_PX_WIDTH, graphicsAssets.TILE_PX_HEIGHT, null);
                }
            }
            if(value > 0.25f) {
                // Render everything else (Items, area effects, etc.) except entities.
                if (tile.hasAreaEffect()) {
                    // Render HealDamage AreaEffect
                    areaEffectRenderer.render(g, tile.getAreaEffect(), topLeft,value);
                }

                if (tile.hasItems()) {
                    for (Item item : tile.getItems()) {
                        itemRenderer.render(g, item, topLeft,value);
                    }
                }
            }
        }
    }

    public static class itemRenderer {
        public static void render(Graphics g, Item item, Point pxTopLeft){
            render(g,item,pxTopLeft,1f);
        }

        public static void render(Graphics g, Item item, Point pxTopLeft, float value) {
            int itemId = item.getId();


            BufferedImage img = new BufferedImage(graphicsAssets.itemImages.get(itemId).getWidth(), graphicsAssets.itemImages.get(itemId).getHeight(), BufferedImage.TRANSLUCENT);
            Graphics2D graphics = img.createGraphics();

            float[] scales = { 1f, 1f, 1f, value };
            float[] offsets = new float[4];
            RescaleOp rop = new RescaleOp(scales, offsets, null);

                    /* Draw the image, applying the filter */
            graphics.drawImage(graphicsAssets.itemImages.get(itemId), rop, 0, 0);

            g.drawImage(img, pxTopLeft.x+5, pxTopLeft.y, graphicsAssets.TILE_PX_WIDTH-20,graphicsAssets.TILE_PX_HEIGHT-10, null);
        }
    }

    public static class areaEffectRenderer{
        public static void render(Graphics g, AreaEffect areaEffect, Point pxTopLeftPoint){
            render(g,areaEffect,pxTopLeftPoint,1f);
        }

        public static void render(Graphics g, AreaEffect areaEffect, Point pxTopLeftPoint,float value){
            AreaEffectEnum type = areaEffect.getType();
//            System.out.println("type: " + areaEffect.getType());
            BufferedImage img;
            Graphics2D graphics;
            float[] scales = { 1f, 1f, 1f, value };
            float[] offsets = new float[4];
            RescaleOp rop = new RescaleOp(scales, offsets, null);

            switch(type){
                case HEAL:

                    img = new BufferedImage(graphicsAssets.greenPlus.getWidth(), graphicsAssets.greenPlus.getHeight(), BufferedImage.TRANSLUCENT);
                    graphics = img.createGraphics();
                    /* Draw the image, applying the filter */
                    graphics.drawImage(graphicsAssets.greenPlus, rop, 0, 0);

                      g.drawImage(img,pxTopLeftPoint.x,pxTopLeftPoint.y,null);
                      break;
                case DAMAGE:
                    img = new BufferedImage(graphicsAssets.redCross.getWidth(), graphicsAssets.redCross.getHeight(), BufferedImage.TRANSLUCENT);
                    graphics = img.createGraphics();

                    /* Draw the image, applying the filter */
                    graphics.drawImage(graphicsAssets.redCross, rop, 0, 0);

                    g.drawImage(img,pxTopLeftPoint.x,pxTopLeftPoint.y,null);
                    break;
                case LEVELUP:
                    img = new BufferedImage(graphicsAssets.goldStar.getWidth(), graphicsAssets.goldStar.getHeight(), BufferedImage.TRANSLUCENT);
                    graphics = img.createGraphics();

                    /* Draw the image, applying the filter */
                    graphics.drawImage(graphicsAssets.goldStar, rop, 0, 0);

                    g.drawImage(img,pxTopLeftPoint.x,pxTopLeftPoint.y,null);
                    break;
                case DEATH:
                    img = new BufferedImage(graphicsAssets.skullCrossBones.getWidth(), graphicsAssets.skullCrossBones.getHeight(), BufferedImage.TRANSLUCENT);
                    graphics = img.createGraphics();

                    /* Draw the image, applying the filter */
                    graphics.drawImage(graphicsAssets.skullCrossBones, rop, 0, 0);

                    g.drawImage(img,pxTopLeftPoint.x,pxTopLeftPoint.y,null);
                    break;
                case PORTAL:
                    img = new BufferedImage(graphicsAssets.portal.getWidth(), graphicsAssets.portal.getHeight(), BufferedImage.TRANSLUCENT);
                    graphics = img.createGraphics();

                    /* Draw the image, applying the filter */
                    graphics.drawImage(graphicsAssets.portal, rop, 0, 0);

                    g.drawImage(img, pxTopLeftPoint.x,pxTopLeftPoint.y,null);
            }
        }
    }

}
