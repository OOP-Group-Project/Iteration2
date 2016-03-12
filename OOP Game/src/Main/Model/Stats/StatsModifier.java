package Main.Model.Stats;

/**
 * Created by AndyZhu on 11/3/2016.
 */
public class StatsModifier {

    public StatsModifier(
            double lifeModifier,
            double manaModifier,
            double strengthModifier,
            double agilityModifier,
            double intellectModifier,
            double hardinessModifier,
            double movementModifier,
            double offensiveModifier,
            double defenseModifier,
            double armorModifier,
            int experienceModifier,
            int livesLeftModifier) {
        this.lifeModifier = lifeModifier;
        this.manaModifier = manaModifier;
        this.strengthModifier = strengthModifier;
        this.agilityModifier = agilityModifier;
        this.intellectModifier = intellectModifier;
        this.hardinessModifier = hardinessModifier;
        this.movementModifier = movementModifier;
        this.offensiveModifier = offensiveModifier;
        this.defenseModifier = defenseModifier;
        this.armorModifier = armorModifier;
        this.experienceModifier = experienceModifier;
        this.livesLeftModifier = livesLeftModifier;
    }

    private double lifeModifier;
    private double manaModifier;

    private double strengthModifier;
    private double agilityModifier;
    private double intellectModifier;
    private double hardinessModifier;
    private double movementModifier;

    private double offensiveModifier;
    private double defenseModifier;
    private double armorModifier;

    private int experienceModifier;
    private int livesLeftModifier;

    public double getLifeModifier() { return lifeModifier; }
    public double getManaModifier() { return manaModifier; }
    public double getStrengthModifier(){ return strengthModifier; }
    public double getAgilityModifier(){ return agilityModifier; }
    public double getIntellectModifier(){ return intellectModifier; }
    public double getHardinessModifier(){ return hardinessModifier; }
    public double getMovementModifier(){ return movementModifier; }
    public double getOffensiveModifier() { return offensiveModifier; }
    public double getDefenseModifier() { return defenseModifier; }
    public double getArmorModifier() {return armorModifier; }
    public int getExperienceModifier() {return experienceModifier; }
    public int getLivesLeftModifier(){ return livesLeftModifier; }



}