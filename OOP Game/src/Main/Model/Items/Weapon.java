package Main.Model.Items;


/**
 * Created by Peter Camejo on 3/9/2016.
 * TODO: Update First Constructor when Equippable is implemented.
 */
public class Weapon extends Equippable {
    /*** Member Variables ***/
    private WeaponTypeEnum weaponType;

    /*** Constructors ***/
    public Weapon(WeaponTypeEnum weaponType){
        this.weaponType = weaponType;
    }

    //Make Weapon Constructor
    public Weapon(Weapon newWeapon){
        //super(newWeapon)
        this.weaponType = newWeapon.getWeaponType();
    }

    /*** Methods ***/
    public WeaponTypeEnum getWeaponType(){
        return this.weaponType;
    }
} //end Weapon
