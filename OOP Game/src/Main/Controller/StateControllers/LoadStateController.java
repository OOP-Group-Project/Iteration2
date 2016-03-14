package Main.Controller.StateControllers;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.Manager.StateControllerManager;
import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.AreaEffectController;
import Main.Controller.ObjectControllers.EntityController.AvatarController;
import Main.Controller.ObjectControllers.EntityController.MountController;
import Main.Controller.ObjectControllers.EntityController.NpcController;
import Main.Controller.ObjectControllers.MapController;
import Main.Controller.ObjectControllers.ObjectController;
import Main.Model.AreaEffect.AreaEffect;
import Main.Model.AreaEffect.HealDamage;
import Main.Model.AreaEffect.Portal;
import Main.Model.AreaEffect.TakeDamage;
import Main.Model.DirectionEnum;
import Main.Model.Entity.*;
import Main.Model.Inventory.Inventory;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Model;
import Main.Model.State.LoadState;
import Main.Model.State.StateEnum;
import Main.Model.io.AreaEffectsIO;
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
        player.setSpiel(tempAvatar.getSpiel());
        player.setLocation(tempAvatar.getLocation());
        player.setOrientation(DirectionEnum.Down);
        player.setInventory(new Inventory());

        // Add player controller
        objectControllerManager.addObjectController(player, new AvatarController(objectControllerManager, world, player));
        world.addEntity(player, player.getLocation().x, player.getLocation().y);

        // Add all the NPCsw
        for(Entity e : gameEntities){
            if(e.getType() == EntityTypeEnum.NPC) {
                objectControllerManager.addObjectController(e, new NpcController(objectControllerManager, world, player, (Npc)e));
                world.addEntity(e,e.getLocation());
            }
            else if (e.getType() == EntityTypeEnum.Pet) {
                objectControllerManager.addObjectController(e, new NpcController(objectControllerManager, world, player, (Npc)e));
                world.addEntity(e, e.getLocation());
            } else if(e.getType() == EntityTypeEnum.Mount) {
                objectControllerManager.addObjectController(e, new MountController(world, (Mount)e));
                world.addEntity(e, e.getLocation());
            }
            e.setOrientation(DirectionEnum.Down);
        }

        for (AreaEffect ae : new AreaEffectsIO().getAreaEffectsList("AreaEffects.txt")) {
            world.getTile(ae.getLocation().x,ae.getLocation().y).addAreaEffect(ae);
            objectControllerManager.addObjectController(ae, new AreaEffectController(ae, ae.getCharge()));
        }
//        AreaEffect portal = new Portal(new MapLocationPoint(2, 2), new MapLocationPoint(10, 10));
//        world.getTile(2,2).addAreaEffect(portal);
//        objectControllerManager.addObjectController(portal, new AreaEffectController(portal, portal.getCharge()));
        
//        AreaEffect testAreaEffect = new TakeDamage(10, 1000, new MapLocationPoint(1,5));
//        world.getTile(1,5).addAreaEffect(testAreaEffect);
//        objectControllerManager.addObjectController(testAreaEffect, new AreaEffectController(testAreaEffect, testAreaEffect.getCharge()));

        stateManager.setState(StateEnum.PlayState);
    }
}
