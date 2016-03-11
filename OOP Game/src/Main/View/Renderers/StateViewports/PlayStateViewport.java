package Main.View.Renderers.StateViewports;

import Main.Model.Entity.Entity;
import Main.Model.Map.Map;
import Main.Model.State.PlayState;
import Main.View.Graphics.GraphicsAssets;
import Main.View.Renderers.ObjectRenderer;
import Main.View.Viewport;
import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

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
    private PlayState playState;

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
    private HashMap<Entity, Point> inViewEntityPxOffset;
    private ArrayList<Entity> inViewEntities;
    private ArrayList<Entity> previousInViewEntities;


    public PlayStateViewport(Viewport viewport, GraphicsAssets graphicsAssets, PlayState playState) {
        this.viewport = viewport;
        this.graphicsAssets = graphicsAssets;
        this.playState = playState;

        // Start the map in the top left corner.
        mapStartX = 0;
        mapStartY = 0;

        // The end of what we expect to render of the map should either be limited by the size of the map or the size of the viewport (i.e. the window)
        mapEndX = Math.min(playState.getWorld().getWidth(), (int)Math.ceil(viewport.getPxWidth()/graphicsAssets.TILE_PX_WIDTH));
        mapEndY = Math.min(playState.getWorld().getHeight(), (int)Math.ceil(viewport.getPxHeight()/graphicsAssets.TILE_PX_HEIGHT));

        pxOffsetX = 0;
        pxOffsetY = 0;

        mapCameraCenter = new Point((mapStartX + mapEndX)/2, (mapStartY + mapEndY)/2);
        pxCameraCenter = new Point(viewport.getPxWidth()/2, viewport.getPxHeight()/2);
        inViewEntityPxOffset = new HashMap<>();
    }

    public void render(Graphics graphics) {
        // First update the position and offset of the map and all entities that are on screen.
        update();

        // Then render them
        ObjectRenderer.mapRenderer.render(graphics, playState.getWorld(), mapCameraCenter, mapStartX, mapEndX, mapStartY, mapEndY);

        for(Entity inViewEntity : inViewEntities) {
            // Get the offset amount
            Point pxRenderOffset = inViewEntityPxOffset.get(inViewEntity);

            // Render it
            ObjectRenderer.entityRenderer.render(graphics, inViewEntity, mapCameraCenter, pxRenderOffset);
        }
    }

    public void update() {
        // Update the camera center
        mapCameraCenter = playState.getCenterPoint();
        pxCameraCenter = new Point(viewport.getPxWidth()/2, viewport.getPxHeight()/2);

        // update the map start and end
        mapStartX = (int)Math.max(0, (mapCameraCenter.x - (pxCameraCenter.x/(0.75*GraphicsAssets.TILE_PX_WIDTH))) - 1);
        mapStartY = Math.max(0, (mapCameraCenter.y - (pxCameraCenter.y/GraphicsAssets.TILE_PX_HEIGHT)) - 1);
        mapEndX = (int)Math.min(playState.getWorld().getWidth(), (mapCameraCenter.x + (pxCameraCenter.x/(0.75*GraphicsAssets.TILE_PX_WIDTH))) + 1);
        mapEndY = Math.min(playState.getWorld().getHeight(), (mapCameraCenter.y + (pxCameraCenter.y/GraphicsAssets.TILE_PX_HEIGHT)) + 1);

        // Update the entities that are currently in view
        if(inViewEntities != null) {
            previousInViewEntities = inViewEntities;
        }

        inViewEntities = new ArrayList<>();

        for(int i = mapStartX; i < mapEndX; ++i) {
            for(int j = mapStartY; j < mapEndY; j++) {

                // Get the entity from the tile
                Entity e = playState.getWorld().getTile(i,j).getEntity();

                // If there's an entity
                if(e != null) {
                    // Check if it was in view before
                    if(previousInViewEntities != null && previousInViewEntities.contains(e)) {
                        // If it was already in view, then keep it in view.
                        inViewEntities.add(e);
                        // remove the ones that are in view from the previous set, so that we have a list of entities that are no longer in view.
                        previousInViewEntities.remove(e);
                    } else {
                        // If it wasn't in view, then add it.
                        inViewEntities.add(e);
                        inViewEntityPxOffset.put(e, new Point(e.getLocation().x, e.getLocation().y));
                    }
                }
            }
        }

        if(previousInViewEntities != null && !previousInViewEntities.isEmpty()) {
            // Any entities that are no longer in view, remove them from the pxOffset structure
            for(Entity e : previousInViewEntities) {
                inViewEntityPxOffset.remove(e);
            }
        }


        // update the pixel offset for the camera

        // update the pixel offsets for the entities
    }


}
