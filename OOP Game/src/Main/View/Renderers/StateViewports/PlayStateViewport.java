package Main.View.Renderers.StateViewports;

import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.View.Graphics.GraphicsAssets;
import Main.View.Renderers.ObjectRenderer;
import Main.View.Viewport;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by mason on 3/6/16.
 */


/*
 * This class handles rendering the map, items, entities, etc.  If it is necessary to draw any of these elements
 * beneath another viewport (i.e., the pause state or inventory state having the playStateViewport below the menu,
 * then this class will be extended and the render method should be overridden.
 */
public class PlayStateViewport extends StateViewport {
    private GraphicsAssets graphicsAssets;
    private Viewport viewport;
    private Entity player;
    private Map world;

    /*
     * In order to render the map and animate moving along tiles, we will render select portions of the map that fit into
     * the rendering space, that is, the window.
     *
     * The tiles that are part of this section are the mapXStart, mapXEnd,
     * mapYStart, and mapYEnd values.  They are updated by the update method in this class, and will always contain
     * the bounds of what is being rendered in the map, plus a little more to make sure we are always rendering all of the screen.
     *
     * The variable mapCameraCenter contains the center point of what's being rendered in the map
     * in map units, and pxCameraCenter contains the center point in pixel units.
     *
     * The variables pxOffsetX and pxOffsetY are an offset that will allow us to animate the transition between one center
     * point to another.
     */

    // Use these values to know what tiles in the map are being drawn at any one point.
    private int mapStartX;
    private int mapEndX;
    private int mapStartY;
    private int mapEndY;

    private Point mapCameraCenter;
    private Point pxCameraCenter;

    // The camera has a pixel offset that allows it to decouple its location from the portion of the map that's being rendered
    private int pxOffsetX;
    private int pxOffsetY;

    private boolean decoupledFromEntity;

    /*
     * In order to be able to animate/tween entities from one location to another independently (i.e., multiple entities
     * on screen moving around), each entity will have a location that they know about themselves.  When the move,
     * that location will be updated to the new map location.  However, the render will not re-render the entity in that new
     * location, since that would cause a sudden jump (not animated/smooth).  Instead, a pixel offset will be stored below
     * that will cause the entity to remain rendered in their old position until the pixel offset is reduced to 0 from their
     * new location.
     *
     * The two variables below represent the pixel offset of any entity that is in view, and another object
     * to store all the entities in view.
    */
    private java.util.Map<Entity, Point> inViewEntityPxOffset;
    private ArrayList<Entity> inViewEntities;


    public PlayStateViewport(GraphicsAssets graphicsAssets, Viewport viewport, Entity player, Map world) {
        super(viewport);
        this.player = player;
        this.world = world;
        this.graphicsAssets = graphicsAssets;

        // Start the map in the top left corner.
        mapStartX = 0;
        mapStartY = 0;

        // The end of what we expect to render of the map should either be limited by the size of the map or the size of the viewport (i.e. the window)
        mapEndX = Math.min(world.getWidth(), (int)Math.ceil(viewport.getPxWidth()/graphicsAssets.TILE_PX_WIDTH));
        mapEndY = Math.min(world.getHeight(), (int)Math.ceil(viewport.getPxHeight()/graphicsAssets.TILE_PX_HEIGHT));

        pxOffsetX = 0;
        pxOffsetY = 0;

        mapCameraCenter = new Point((mapStartX + mapEndX)/2, (mapStartY + mapEndY)/2);
        pxCameraCenter = new Point(this.viewport.getPxWidth()/2, this.viewport.getPxHeight()/2);

        recoupleToEntity();
    }

    public void render(Graphics graphics) {
        // First update the position and offset of the map and all entities that are on screen.
        update();

        // Then render them
        ObjectRenderer.mapRenderer.render(graphics, world, mapStartX, mapEndX, mapStartY, mapEndY);
        for(Entity inViewEntity : inViewEntities) {
            // Get the offset amount
            Point offset = inViewEntityPxOffset.get(inViewEntity);

            // Create the new position for the entity
            Point renderPosition = new Point((int)(inViewEntity.getLocation().getX() + offset.getX()), (int)(inViewEntity.getLocation().getY() + offset.getY()));

            // Render it
            ObjectRenderer.entityRenderer.render(graphics, inViewEntity, renderPosition);
        }
    }

    public void update() {
        // If we're not decoupled from the entity
        if(!decoupledFromEntity) {
            // Update the portion of the map that's in view to center on the player
            mapCameraCenter = player.getLocation();
        }

        // update the map start and end
        mapStartX = (int)Math.max(0, (mapCameraCenter.getX() - (pxCameraCenter.getX()/GraphicsAssets.TILE_PX_WIDTH)));
        mapStartY = (int)Math.max(0, (mapCameraCenter.getY() - (pxCameraCenter.getY()/GraphicsAssets.TILE_PX_HEIGHT)));
        mapEndX = (int)Math.min(world.getWidth(), (mapCameraCenter.getX() + (pxCameraCenter.getX()/GraphicsAssets.TILE_PX_WIDTH)));
        mapEndY = (int)Math.min(world.getHeight(), (mapCameraCenter.getY() + (pxCameraCenter.getY()/GraphicsAssets.TILE_PX_HEIGHT)));

        // update the pixel offset for the camera

        // update the pixel offsets for the entities
    }

    public void decoupleFromEntity() {
        decoupledFromEntity = true;
    }

    public void recoupleToEntity() {
        decoupledFromEntity = false;
    }

}