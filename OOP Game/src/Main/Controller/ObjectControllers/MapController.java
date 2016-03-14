package Main.Controller.ObjectControllers;

import Main.Controller.Manager.ObjectControllerManager;
import Main.Controller.ObjectControllers.EntityController.EntityController;
import Main.Model.AreaEffect.AreaEffect;
import Main.Model.AreaEffect.AreaEffectEnum;
import Main.Model.AreaEffect.AttackEffect;
import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Map.Map;
import Main.Model.Map.Tile;

import java.util.ArrayList;

/**
 * Created by mason on 3/12/16.
 */
public class MapController extends ObjectController {
    private ObjectControllerManager objectControllerManager;
    private Map map;

    public MapController(ObjectControllerManager objectControllerManager, Map map) {
        this.objectControllerManager = objectControllerManager;
        this.map = map;
    }

    public void update() {
        for(int j = 0; j < map.getHeight(); j++) {
            for(int i = 0; i < map.getWidth(); i++) {
                Tile currentTile = map.getTile(i,j);

                // Update effects
                if(currentTile.hasAreaEffect()) {
                    AreaEffect areaEffect = currentTile.getAreaEffect();

                    // Update
                    AreaEffectController aec = (AreaEffectController) objectControllerManager.getObjectController(areaEffect);
                    aec.update();


                    // Apply to entity
                    if(currentTile.hasEntity()) {
                        if(areaEffect.getType() == AreaEffectEnum.PORTAL) {
                            aec.activate(currentTile.getEntity(), map);
                            currentTile.removeEntity();
                        }
                        else {
                            aec.activate(currentTile.getEntity());
                        }
                    }
                }

                if(currentTile.hasAttackEffects()) {
                    ArrayList<AttackEffect> attackEffects = currentTile.getAttackEffects();
                    for(int k = 0; k < attackEffects.size(); ++k) {
                        AttackEffect attackEffect = attackEffects.get(k);
                        AttackEffectController attackEffectController = (AttackEffectController) objectControllerManager.getObjectController(attackEffect);

                        attackEffectController.update();

                        if(currentTile.hasEntity()) {
                            Entity entity = currentTile.getEntity();
                            if(attackEffectController.canActivate()) {
                                attackEffectController.activate(entity);
                                attackEffects.remove(k);
                                objectControllerManager.removeObjectController(attackEffect, attackEffectController);
                            }
                        }
                    }
                }

                // update characters
                if(currentTile.hasEntity()) {
                    Entity tileEntity = currentTile.getEntity();
                    EntityController ec = (EntityController)objectControllerManager.getObjectController(tileEntity);
                    ec.update();
                    if(!tileEntity.hasHealth() && tileEntity.getLives() == 0 ) {
                        if(tileEntity.getType() == EntityTypeEnum.Avatar && !tileEntity.isDead()) {
                            map.addEntity(tileEntity, 0,0);
                            currentTile.removeEntity();
                            tileEntity.revertDeath();
                        } else if(tileEntity.getType() == EntityTypeEnum.NPC && !tileEntity.isDead()) {
                            currentTile.removeEntity();
                        }

                    }
                }
            }
        }
    }
}
