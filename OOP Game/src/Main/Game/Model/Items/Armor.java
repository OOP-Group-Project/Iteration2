package Main.Game.Model.Items;

/**
 * Created by Peter Camejo on 3/9/2016.
 * TODO: Update constructors w/ super() when Equippable is implmented.
 */
public class Armor extends Equippable{
    /*** Member Variables ***/
    private ArmorTypeEnum armorType;

    /*** Constructors ***/
    public Armor(/* Equippable parameters */ ArmorTypeEnum armorType){
        //super(Equippable constructor stuff)
        this.armorType = armorType;
    }

    //Make Armor constructor
    public Armor(Armor newArmor){
        //super(newArmor);
        this.armorType = newArmor.getArmorType();
    }

    /*** Methods ***/
    public ArmorTypeEnum getArmorType(){
        return this.armorType;
    }
} //end Armor
