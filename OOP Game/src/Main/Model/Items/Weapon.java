package Main.Model.Items;


/**
 * Created by Peter Camejo on 3/9/2016.
 * TODO: Update First Constructor when Equippable is implemented.
 */
public class Weapon extends Equippable {
    /*** Member Variables ***/
    private WeaponTypeEnum weaponType;
    private boolean twoHanded;
    private float attackSpeed;

    /*** Constructors ***/
    //Sets twoHanded based on weaponType
    public Weapon(/* EQuipable Parameters */ WeaponTypeEnum weaponType, float attackSpeed) {

        //super( Equipable parameters);
        this.attackSpeed = attackSpeed;
        this.weaponType = weaponType;

        if (weaponType == WeaponTypeEnum.ONEHANDSWORD ||
                weaponType == WeaponTypeEnum.SHIELD ||
                weaponType == WeaponTypeEnum.DAGGER) {
            twoHanded = false;
        }
        else{
            twoHanded = true;
        }
    }


    /*** Methods ***/
    public WeaponTypeEnum getWeaponType(){
        return this.weaponType;
    }
    public float getAttackSpeed(){ return this.attackSpeed;}
    public void setAttackSpeed(float attackSpeed){this.attackSpeed = attackSpeed;}
    public boolean isTwoHanded(){ return this.twoHanded;}
    public void setTwoHanded(boolean isTwoHanded){
        this.twoHanded = isTwoHanded;
    }

} //end Weapon
