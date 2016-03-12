package Main.Model.Items;


import Main.Model.Actions.Attack;
import Main.Model.Stats.StatsModifier;
import Main.Model.Requirement;
import Main.Model.Skills.Skill;

/**
 * Created by Peter Camejo on 3/9/2016.
 * TODO: Update First Constructor when Equippable is implemented.
 */
public class Weapon extends Equippable {
    /*** Member Variables ***/
    private WeaponTypeEnum weaponType;
    private boolean twoHanded;
    private Attack attacks[];
    private Skill skills[];

    /*** Constructors ***/
    //Sets twoHanded based on weaponType
    public Weapon(WeaponTypeEnum weaponType, String name, StatsModifier statsModifiers[], Requirement requirements[], Attack attacks[], Skill skills[]) {
        super(ItemTypeEnum.Equippable, name, statsModifiers, requirements);
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
    public boolean isTwoHanded(){ return this.twoHanded;}
    public void setTwoHanded(boolean isTwoHanded){
        this.twoHanded = isTwoHanded;
    }
} //end Weapon
