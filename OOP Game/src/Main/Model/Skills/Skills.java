package Main.Model.Skills;

import Main.Model.Entity.Entity;

/**
 * Created by walkhard on 2/18/16.
 */
public abstract class Skills {

    protected Entity entity;

    protected Skills() {}

    public Skills (Entity entity) {
        this.entity = entity;
    }

    private int skillLvl = 0;

    public void levelUpSkill () { skillLvl += 1; }

    public int getSkillLvl() { return skillLvl; }

    public void setSkillLvl(int lvl) { skillLvl = lvl; }
}
