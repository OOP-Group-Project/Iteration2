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
    protected String skillName;
    protected int level;

    protected double manaCost;

    protected double coolDownPeriod;
    protected double timeWhenPerformed;
    protected double remainingCoolDownPeriod;
    protected boolean cooledDown;

    public Skills(Entity entity, double coolDownPeriod, double manaCost) {
        //maxLevel is 10
        level = 1;
        this.entity = entity;
        this.coolDownPeriod = coolDownPeriod;
        this.manaCost = manaCost;
        this.remainingCoolDownPeriod = 0;
        this.cooledDown = true;
    }

    public void increaseLevel() {
        if (level < 10 && entity.getStats().getSkillPoints() >= 1) {
            ++level;
            manaCost += 1;
            entity.getStats().changeSkillPoints(-1);
            System.out.println("Level up success, your current level of skill " + skillName + " is " + level);
        }
        else if (entity.getStats().getSkillPoints() < 1) {
            System.out.println("You don't have enough skill points");
        }
        else if (level == 10){
            System.out.println("You've reached your max level");
        }
    }

    protected void enforceManaCost() {
        StatsModifier sm = new StatsModifier();
        sm = sm.builder().manaModifier(-manaCost).build();
        entity.getStats().modifyStats(sm);
    }

    protected boolean enoughMana() {
        Stats stats = entity.getStats();
        return stats.curMana() >= manaCost;
    }


    public boolean successfulPerformance() {
        Random random = new Random();
        //it's a number increments from 0.5 to 1 with level
        double chanceOfSuccess = 0.5 + (double)level/10;
        System.out.println("chance of success: " + chanceOfSuccess);
        //generate a number (from 0 to 1) for comparison
        double numberForIf = random.nextDouble();

        return numberForIf <= chanceOfSuccess;
    }

    public int getLevel() { return level; }

    public double getCoolDownPeriod() { return coolDownPeriod; }


    public double getRemainingCoolDownPeriod() {
        remainingCoolDownPeriod = System.currentTimeMillis() - timeWhenPerformed;
        return remainingCoolDownPeriod;
    }

    public double getManaCost() { return manaCost; }

    public String getSkillName() {return skillName;}

    public double getTimeWhenPerformed() {return timeWhenPerformed;}

    public boolean validateCooledDown() {
        return (System.currentTimeMillis() - timeWhenPerformed)/1000 > coolDownPeriod;
    }

    public boolean allCheck() {
        cooledDown = validateCooledDown();
        if (!enoughMana()) {
            System.out.println("Not enough mana");
            return false;
        }
        else if (!cooledDown) {
            System.out.println("This spell is not cooled down");
            return false;
        }
        else if (!successfulPerformance()) {
            enforceManaCost();
            timeWhenPerformed = System.currentTimeMillis();
            System.out.println("performance of " + skillName +" failed");
            return false;
        }
        else {
            return true;
        }
    }
}
