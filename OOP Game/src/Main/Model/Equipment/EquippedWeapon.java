package Main.Model.Equipment;

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
<<<<<<< HEAD:OOP Game/src/Main/Model/Equipment/EquippedWeapon.java
        Weapon temp = newWeapon;//new Weapon(newWeapon);
        this.weapon = temp;
=======
        Weapon temp = new Weapon(newWeapon);
        if(temp.isTwoHanded() == true){
            mainHand = temp;
            offHand = temp;
        }else{
            mainHand = temp;
            offHand = null;
        }
>>>>>>> master:OOP Game/src/Main/Model/Inventory/Equipment/EquippedWeapon.java
    }

    public Weapon unequipWeapon() {
        if (this.mainHand == null) {
            return null;
        }

<<<<<<< HEAD:OOP Game/src/Main/Model/Equipment/EquippedWeapon.java
        Weapon temp = this.weapon;//new Weapon(this.weapon);
        this.weapon = null;
=======
        Weapon temp = new Weapon(this.mainHand);
        this.mainHand = null;
        this.offHand  = null;
>>>>>>> master:OOP Game/src/Main/Model/Inventory/Equipment/EquippedWeapon.java
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
