package Main.Model.Equipment;

import Main.Model.Items.Weapon;

/**
 * Created by Peter Camejo on 3/7/2016.
 *
 */
public class EquippedWeapon{
    /*** Member Variables ***/
    private Weapon weapon;

    /*** Constructors ***/
    //Instantiate with no starting weapon)
    public EquippedWeapon(){
        weapon = null;
    }

    /*** Methods ***/
    public void equipWeapon(Weapon newWeapon){
        Weapon temp = newWeapon;//new Weapon(newWeapon);
        this.weapon = temp;
    }

    public Weapon unequipWeapon() {
        if (this.weapon == null) {
            return null;
        }

        Weapon temp = this.weapon;//new Weapon(this.weapon);
        this.weapon = null;
        return temp;
    }

    public boolean isEquipped(){
        if(this.weapon == null) {
            return false;
        }
        return true;
    }

    public Weapon getWeapon(){
        return this.weapon;
    }

} //end EquippedWeapon
