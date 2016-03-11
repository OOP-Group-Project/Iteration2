package Main.Game.Model.Items;


/**
 * Created by Peter Camejo on 3/9/2016.
 * TODO: Update First Constructor when Equippable is implemented.
 */
public class Weapon extends Equippable {
    /*** Member Variables ***/
    private WeaponTypeEnum weaponType;
    private boolean twoHanded;

    /*** Constructors ***/
    //Sets twoHanded based on weaponType
    public Weapon(/* EQuipable Parameters */ WeaponTypeEnum weaponType) {

        //super( Equipable parameters);
        if (weaponType == WeaponTypeEnum.ONEHANDSWORD ||
                weaponType == WeaponTypeEnum.SHIELD ||
                weaponType == WeaponTypeEnum.DAGGER) {
            twoHanded = false;
        }
        else{
            twoHanded = true;
        }
    }

    //Make Weapon Constructor
    public Weapon(Weapon newWeapon){
        //super(newWeapon)
        this.weaponType = newWeapon.getWeaponType();
        this.twoHanded = newWeapon.isTwoHanded();
    }

    /*** Methods ***/
    public WeaponTypeEnum getWeaponType(){
        return this.weaponType;
    }
    public boolean isTwoHanded(){ return this.twoHanded;}
    public void setTwoHanded(boolean isTwoHanded){
        this.twoHanded = isTwoHanded;
    }
} //end Weapon
