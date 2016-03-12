package Main.Model.Entity;

/**
 * Created by walkhard on 3/12/16.
 */
public enum EntitySpeechEnum {
    PLAYER("Player's speech"),
    PET("ChuffChuffChuffChuff..."),
    SHOPKEEPER("Shopkeeper"),
    TRASH("Trash"),
    BOSS("Boss"),
    ;
    // enum constructor
    EntitySpeechEnum(String str){this.msg = str;}
    //
    private final String msg;
    // returns string value of each enum
    /*
        Inside of Avatar:

            EntitySpeechEnum spiel = EntitySpeechEnum<entity enum value>

            e.g.

                EntitySpeechEnum spiel = EntitySpeechEnum.PLAYER;
     */
    public String spiel(){return this.msg;}
}
