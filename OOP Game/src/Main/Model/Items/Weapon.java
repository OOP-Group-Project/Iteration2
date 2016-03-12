package Main.Model.Items;

import Main.Model.Actions.Attack;
/**
 * Created by Peter Camejo on 3/9/2016.
 * TODO: Update First Constructor when Equippable is implemented.
 */
public class Weapon extends Equippable {
    /*** Member Variables ***/
    private WeaponTypeEnum weaponType;
    private boolean twoHanded;
    private float attackSpeed;
    private Attack attack;

    /*** Constructors ***/
    //Sets twoHanded based on weaponType
    public Weapon(/* EQuipable Parameters */ WeaponTypeEnum weaponType, float attackSpeed, Attack attack) {

        //super( Equipable parameters);
        this.attackSpeed = attackSpeed;
        this.weaponType = weaponType;
        this.attack = attack;

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
    public Attack getAttack(){return attack;}
    public void setAttack(Attack attack){this.attack = attack;}
    public float getAttackSpeed(){ return this.attackSpeed;}
    public void setAttackSpeed(float attackSpeed){this.attackSpeed = attackSpeed;}
    public boolean isTwoHanded(){ return this.twoHanded;}
    public void setTwoHanded(boolean isTwoHanded){
        this.twoHanded = isTwoHanded;
    }

} //end Weapon
