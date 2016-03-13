package Main.Controller.StateControllers;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.AreaEffectController;
import Main.Controller.ObjectControllers.EntityController.AvatarController;
import Main.Controller.ObjectControllers.EntityController.NpcController;
import Main.Controller.ObjectControllers.MapController;
import Main.Controller.ObjectControllers.ObjectController;
import Main.Model.AreaEffect.AreaEffect;
import Main.Model.AreaEffect.HealDamage;
import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Map.Map;
import Main.Model.Model;
import Main.Model.State.LoadState;
import Main.Model.State.StateEnum;
import Main.Model.io.EntityIO;

import java.util.ArrayList;

/**
 * Created by mason on 3/9/16.
 */
public class LoadStateController extends StateController {

    private StateControllerManager stateManager;
    private ObjectControllerManager objectControllerManager;
    private LoadState loadState;
    private Map world;
    private ArrayList<Entity> gameEntities;
    private Avatar player;

    public LoadStateController(StateControllerManager stateManager, ObjectControllerManager objectControllerManager, LoadState loadState, Model model) {
        this.stateManager = stateManager;
        this.objectControllerManager = objectControllerManager;
        this.loadState = loadState;
        this.world = model.getWorld();
        this.player = model.getPlayer();
    }

    @Override
    public void handleAction(UserActionEnum action) {

    }

    @Override
    public void update() {

        objectControllerManager.addObjectController(world, new MapController(objectControllerManager, world));

        // Load all the game entities
        gameEntities = new EntityIO().loadEntities("Entities.txt");

        // load the avatar
        Avatar tempAvatar = (Avatar)gameEntities.get(0);
        player.setOccupation(tempAvatar.getOccupation());
        player.setType(tempAvatar.getType());
        player.setInventory(tempAvatar.getInventory());
        player.setSpiel(tempAvatar.getSpiel());
        player.setLocation(tempAvatar.getLocation());

        // Add player controller
        objectControllerManager.addObjectController(player, new AvatarController(world, player));
        world.addEntity(player, player.getLocation().x, player.getLocation().y);

        // Add all the NPCsw
        for(Entity e : gameEntities){
            if(e.getType() == EntityTypeEnum.NPC) {
                objectControllerManager.addObjectController(e, new NpcController(world, player, e));
                world.addEntity(e,e.getLocation().x,e.getLocation().y);
            }
        }
        
        AreaEffect testAreaEffect = new HealDamage(10, 1000);
        world.getTile(1,5).addAreaEffect(testAreaEffect);
        objectControllerManager.addObjectController(testAreaEffect, new AreaEffectController(testAreaEffect, testAreaEffect.getCharge()));

        stateManager.setState(StateEnum.PlayState);

    }
}
