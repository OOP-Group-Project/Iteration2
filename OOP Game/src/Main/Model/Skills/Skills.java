package Main.Model.Skills;

/**
 * Created by walkhard on 2/18/16.
 */
public abstract class Skills {

    protected int level;
    protected double coolDownPeriod;
    public abstract int activate();

    public Skills(double coolDownPeriod) {
        level = 0;
        this.coolDownPeriod = coolDownPeriod;
    }

    public void increaseLevel() {
        ++level;
    }

    public int getLevel() {
        return level;
    }

    public double getCoolDownPeriod() {
        return coolDownPeriod;
    }


}
