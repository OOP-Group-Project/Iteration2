package Main.Model.Entity;


import Main.Model.Inventory.Inventory;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Occupation;
import Main.Model.Occupation.Smasher;
import Main.Model.Stats.StatsModifier;

/**
 * Created by walkhard on 2/18/16.
 */
public class Npc extends Entity {

    public Npc(EntityTypeEnum entityType, EntitySpeechEnum entitySpiel, Occupation occupation, MapLocationPoint location, Inventory inv){
        super(entityType, entitySpiel, occupation, location, 1, inv);
    }

    public Npc(EntityTypeEnum entityType, EntitySpeechEnum entitySpiel, Occupation occupation, MapLocationPoint location, int level, Inventory inv){
        super(entityType, entitySpiel, occupation, location, level, inv);
    }

    public Npc(MapLocationPoint location, Inventory inv) {
        super(EntityTypeEnum.NPC, EntitySpeechEnum.TRASH, new Smasher(), location, 1, inv);
    }

    public Npc(MapLocationPoint location, int level, Inventory inv) {
        super(EntityTypeEnum.NPC, EntitySpeechEnum.TRASH, new Smasher(), location, level, inv);
    }

    public Npc(Occupation o, MapLocationPoint location, int level, Inventory inv) {
        super(EntityTypeEnum.NPC, EntitySpeechEnum.TRASH, o, location, level, inv);
    }

    public void respawn(MapLocationPoint location) {
//        this.location.x = location.x;
//        this.location.y = location.y;
//        StatsModifier sm = new StatsModifier();
//        sm = sm.builder().lifeModifier(15).build();
//        this.stats.modifyStats(sm);
//        // TODO: Reset avatar's stats when respawn
        //this.stats.reset();
    }

}
