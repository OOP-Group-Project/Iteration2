package Main.Model.Skills;

import Main.Model.Entity.Entity;
import Main.Model.Stats.Stats;
import Main.Model.Stats.StatsModifier;

import java.util.Random;

/**
 * Created by walkhard on 2/18/16.
 */
public abstract class Skills {

    protected Entity entity;
    protected int level;
    protected double coolDownPeriod;
    protected double manaCost;

    public Skills(Entity entity, double coolDownPeriod, double manaCost) {
        //maxLevel is 10
        level = 1;
        this.entity = entity;
        this.coolDownPeriod = coolDownPeriod;
        this.manaCost = manaCost;
    }

    public void increaseLevel() { ++level; }

    protected void enforceManaCost() {
        StatsModifier sm = new StatsModifier();
        sm = sm.builder().manaModifier(-manaCost).build();
        entity.getStats().modifyStats(sm);
    }

    protected boolean enoughMana() {
        Stats stats = entity.getStats();
        return stats.curMana() >= manaCost;
    }

    public boolean successfulPerfoemance() {
        Random random = new Random();
        //it's a number increments from 0.5 to 1 with level
        double changeOfSuccess = 0.5 + (double)level/10;
        //generate a number (from 0 to 1) for comparison
        double numberForIf = random.nextDouble();

        return numberForIf <= changeOfSuccess;
    }

    public int getLevel() { return level; }

    public double getCoolDownPeriod() { return coolDownPeriod; }

    public double getManaCost() { return manaCost; }



}
