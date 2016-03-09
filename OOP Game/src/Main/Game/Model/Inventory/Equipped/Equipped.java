package Main.Game.Model.Inventory.Equipped;

/**
 * Created by Peter Camejo on 2/18/16.
 *
 * Association class between the Entity player and the Items s/he has equipped.
 *
 * TODO: render()
 *
 */
public class Equipped {
    private EquippedWeapon weapon;
    private EquippedArmor armor;

    public Equipped(){
        this.weapon = new EquippedWeapon();
        this.armor = new EquippedArmor();
    }

    public EquippedWeapon getWeapon(){
        return this.weapon;
    }

    public EquippedArmor getArmor(){
        return this.armor;
    }

    public void setWeapon(EquippedWeapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(EquippedArmor armor){
        this.armor = armor;
    }
}
