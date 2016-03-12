package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;

/**
 * Created by Matthew on 3/12/16.
 */
public abstract class Skills {

    protected Entity entity;
    protected int level;
    protected double coolDownPeriod;
    protected double manaCost;

    public Skills(Entity entity, double coolDownPeriod, double manaCost) {
        level = 0;
        this.entity = entity;
        this.coolDownPeriod = coolDownPeriod;
        this.manaCost = manaCost;
    }

    public void increaseLevel() {
        ++level;
    }

    protected void enforceManaCost() {
        entity.modifyStats("mp", -manaCost);
    }

    protected boolean enoughMana() {
        Stats stats = entity.getStats();
        if(stats.curMana() >= manaCost) {
            return true;
        }
        return false;
    }

    public int getLevel() {
        return level;
    }

    public double getCoolDownPeriod() {
        return coolDownPeriod;
    }

    public double getManaCost() {
        return manaCost;
    }


}
