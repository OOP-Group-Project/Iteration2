package Main.Model.Equipment;

import Main.Model.Items.Armor;
import Main.Model.Items.ArmorTypeEnum;
/**
 * Created by Peter Camejo on 3/7/2016.
 */
public class EquippedArmor{
    /*** Member Variables ***/
    private Armor   head,
                    chest,
                    legs,
                    gloves,
                    boots,
                    trinket;

    /*** Constructors ***/
    public EquippedArmor(){
        head = null;
        chest = null;
        legs = null;
        gloves = null;
        boots = null;
        trinket = null;
    }

    /*** Methods ***/
    public void equipArmor(Armor newArmor) {
        Armor temp =newArmor; //new Armor(newArmor);
        switch (newArmor.getArmorType()) {
            case HEAD:
                head = newArmor;
                break;
            case CHEST:
                chest = newArmor;
                break;
            case LEGS:
                legs = newArmor;
                break;
            case GLOVES:
                gloves = newArmor;
                break;
            case BOOTS:
                boots = newArmor;
                break;
            case TRINKET:
                trinket = newArmor;
                break;
            default:
                break;
        }
    } //end equipArmor()

    public Armor unequipArmor(ArmorTypeEnum armorType){
        Armor temp = null; //Holds what was unequipped and will return it.

        switch(armorType) {
            case HEAD:
                if(head == null)break;
                temp = head;//new Armor(head);
                head = null;
                break;
            case CHEST:
                if(chest == null)break;
                temp = chest;// new Armor(chest);
                chest = null;
                break;
            case LEGS:
                if(legs == null)break;
                temp = legs;// new Armor(legs);
                legs = null;
                break;
            case GLOVES:
                if(gloves == null)break;
                temp = gloves;//new Armor(gloves);
                gloves = null;
                break;
            case BOOTS:
                if(boots == null)break;
                temp = boots;//new Armor(boots);
                boots = null;
                break;
            case TRINKET:
                if(trinket == null)break;
                temp = trinket;//new Armor(trinket);
                trinket = null;
                break;
            default:
                break;
        }

        return temp;

    } //end unEquipArmor()

    public boolean isEquipped(ArmorTypeEnum armorType){
        switch(armorType){
            case HEAD:
                if(head != null)return true;
                break;

            case CHEST:
                if(chest != null)return true;
                break;

            case LEGS:
                if(legs != null)return true;
                break;

            case GLOVES:
                if(gloves !=  null)return true;
                break;

            case BOOTS:
                if(boots != null)return true;
                break;

            case TRINKET:
                if(trinket != null) return true;
                break;
        }
        return false;
    } //end isEquipped();


    public Armor getHead(){
        return head;
    }
    public Armor getChest(){
        return chest;
    }
    public Armor getLegs(){
        return legs;
    }

    public Armor getGloves() {
        return gloves;
    }

    public Armor getBoots() {
        return boots;
    }

    public Armor getTrinket(){
        return trinket;
    }

}//end EquippedArmor