package Main.Model.Skills;

import Main.Model.Entity.Entity;

/**
 * Created by walkhard on 2/18/16.
 */
public abstract class Skill {

    protected Entity entity;

    protected Skill() {}

    public Skill (Entity entity) {
        this.entity = entity;
    }

    private int skillLvl = 0;

    public void levelUpSkill () { skillLvl += 1; }

    public int getSkillLvl() { return skillLvl; }

    public void setSkillLvl(int lvl) { skillLvl = lvl; }

    public abstract void apply();
}
