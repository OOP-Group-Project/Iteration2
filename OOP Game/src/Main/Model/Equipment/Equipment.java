package Main.Model.Equipment;

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

    public Takable unEquip(WeaponTypeEnum equippedWeapon){
        return weapon.unequipWeapon();
    }

    public Takable unEquip(ArmorTypeEnum armorType){
        return armor.unequipArmor(armorType);
    }



}
