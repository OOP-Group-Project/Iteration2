package Main.Model.Inventory.Equipment;

import Main.Model.Items.*;

import java.awt.*;

/**
 * Created by Peter Camejo on 3/10/16.
 */
public class Equipment {
    /*** Member Variables ***/
    private EquippedWeapon weapon;
    private EquippedArmor armor;

    /*** Constructors ***/
    public Equipment(){
        weapon = new EquippedWeapon();
        armor = new EquippedArmor();
    }

    public Equipment(EquippedWeapon weapon, EquippedArmor armor){
        this.weapon = weapon;
        this.armor = armor;
    }

    /*** Member Variables ***/

    // Call when you want to unequip weapon
    public TakeAble unEquip(){
        return weapon.unequipWeapon();
    }

    //Pass an armor type to unequip armor;
    public TakeAble unEquip(ArmorTypeEnum armorType){
        return armor.unequipArmor(armorType);
    }



}
