package Main.Model.Entity;


import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Occupation;
import Main.Model.Occupation.Smasher;
import Main.Model.Stats.StatsModifier;

/**
 * Created by walkhard on 2/18/16.
 */
public class Npc extends Entity {

    public Npc(EntityTypeEnum entityType, EntitySpeechEnum entitySpiel, Occupation occupation, MapLocationPoint location){
        super(entityType, entitySpiel, occupation, location, 1);
    }

    public Npc(EntityTypeEnum entityType, EntitySpeechEnum entitySpiel, Occupation occupation, MapLocationPoint location, int level){
        super(entityType, entitySpiel, occupation, location, level);
    }

    public Npc(MapLocationPoint location) {
        super(EntityTypeEnum.NPC, EntitySpeechEnum.TRASH, new Smasher(), location, 1);
    }

    public Npc(MapLocationPoint location, int level) {
        super(EntityTypeEnum.NPC, EntitySpeechEnum.TRASH, new Smasher(), location, level);
    }

    public Npc(Occupation o, MapLocationPoint location) {
        super(EntityTypeEnum.NPC, EntitySpeechEnum.TRASH, o, location, 1);
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
