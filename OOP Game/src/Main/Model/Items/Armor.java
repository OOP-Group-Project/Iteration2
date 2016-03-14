package Main.Model.Items;

import Main.Model.Skills.Skills;
import Main.Model.Stats.StatsModifier;
import Main.Model.Requirement;


/**
 * Created by Peter Camejo on 3/9/2016.
 * TODO: Update constructors w/ super() when Equippable is implmented.
 */
public class Armor extends Equippable{

        /*** Member Variables ***/
        private ArmorTypeEnum armorType;


        /*** Constructors ***/
        public Armor(ArmorTypeEnum armorType, String name, int id, StatsModifier statsModifiers[], Requirement requirements[]){


        super(ItemTypeEnum.Equippable, name, id, statsModifiers, requirements);
        //super(Equippable constructor stuff)
        this.armorType = armorType;
    }

    /*** Methods ***/
    public ArmorTypeEnum getArmorType(){
        return this.armorType;
    }
} //end Armor
