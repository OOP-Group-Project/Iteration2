package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;

import java.util.Random;

/**
 * Created by Matthew on 3/12/16.
 */
public abstract class Skill {

    protected Entity entity;
    protected int level;
    protected double coolDownPeriod;
    protected double manaCost;

    public Skill(Entity entity, double coolDownPeriod, double manaCost) {
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

    public boolean successfulPerfoemance() {
        Random random = new Random();
        //it's a number increments from 0.5 to 1 with level
        double changeOfSuccess = 0.5 + (double)level/10;
        //generate a number (from 0 to 1) for comparison
        double numberForIf = random.nextDouble();

        return numberForIf <= changeOfSuccess;
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
