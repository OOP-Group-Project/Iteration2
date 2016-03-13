package Main.Model.Inventory.Equipment;

import Main.Model.Items.Weapon;

/**
 * Created by Peter Camejo on 3/7/2016.
 *
 */
public class EquippedWeapon{
    /*** Member Variables ***/
    private Weapon mainHand;
    private Weapon offHand;

    /*** Constructors ***/
    //Instantiate with no starting weapon)
    public EquippedWeapon(){
        mainHand = null;
        offHand = null;
    }

    /*** Methods ***/
    public void equipWeapon(Weapon newWeapon){
        if(newWeapon.isTwoHanded() == true){
            mainHand = newWeapon;
            offHand = newWeapon;
        }else{
            mainHand = newWeapon;
            offHand = null;
        }
    }

    public Weapon unequipWeapon() {
        if (this.mainHand == null) {
            return null;
        }

        Weapon temp = this.mainHand;
        this.mainHand = null;
        this.offHand  = null;
        return temp;
    }

    public boolean isEquipped(){
        if(this.mainHand == null) {
            return false;
        }
        return true;
    }

    public Weapon getWeapon(){
        return this.mainHand;
    }

} //end EquippedWeapon
