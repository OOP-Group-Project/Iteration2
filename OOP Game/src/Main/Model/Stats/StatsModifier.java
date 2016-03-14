package Main.Model.Stats;


/**
 * Created by AndyZhu on 11/3/2016.
 */
public class StatsModifier {

    protected double lifeModifier = 0;
    private double manaModifier = 0;

    private double strengthModifier = 0;
    private double agilityModifier = 0;
    private double intellectModifier = 0;
    private double hardinessModifier = 0;
    private double movementModifier = 0;

    private double offensiveModifier = 0;
    private double defenseModifier = 0;
    private double armorModifier = 0;

    private int experienceModifier = 0;
    private int livesLeftModifier = 0;
    private double partialImmunityModifer = 0;

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
    public double getPartialImmunityModifer() { return partialImmunityModifer;}

    public StatsModifierBuilder builder() {
        return new StatsModifierBuilder();
    }

    public class StatsModifierBuilder {
        private double lifeModifier = 0;
        private double manaModifier = 0;
        private double strengthModifier = 0;
        private double agilityModifier = 0;
        private double intellectModifier = 0;
        private double hardinessModifier = 0;
        private double movementModifier = 0;
        private double offensiveModifier = 0;
        private double defenseModifier = 0;
        private double armorModifier = 0;
        private int experienceModifier = 0;
        private int livesLeftModifier = 0;
        private double partialImmunityModifer = 0;

        public StatsModifier build() {

            StatsModifier sm = new StatsModifier();
            // if a value wasn't provided for a property, use the default
            sm.lifeModifier = lifeModifier == 0 ? 0 : lifeModifier;
            sm.manaModifier = manaModifier == 0 ? 0 : manaModifier;
            sm.strengthModifier = strengthModifier == 0 ? 0 : strengthModifier;
            sm.agilityModifier = agilityModifier == 0 ? 0 : agilityModifier;
            sm.intellectModifier = intellectModifier == 0 ? 0 : intellectModifier;
            sm.hardinessModifier = hardinessModifier == 0 ? 0 : hardinessModifier;
            sm.movementModifier = movementModifier == 0 ? 0 : movementModifier;
            sm.offensiveModifier = offensiveModifier == 0 ? 0 : offensiveModifier;
            sm.defenseModifier = defenseModifier == 0 ? 0 : defenseModifier;
            sm.armorModifier = armorModifier == 0 ? 0 : armorModifier;
            sm.experienceModifier = experienceModifier == 0 ? 0 : experienceModifier;
            sm.livesLeftModifier = livesLeftModifier == 0 ? 0 : livesLeftModifier;
            sm.partialImmunityModifer = partialImmunityModifer == 0 ? 0 : partialImmunityModifer;
            return sm;
        }


        public StatsModifierBuilder lifeModifier(double lifeModifier) {
            this.lifeModifier = lifeModifier;
            return this;
        }
        public StatsModifierBuilder manaModifier(double manaModifier) {
            this.manaModifier = manaModifier;
            return this;
        }
        public StatsModifierBuilder strengthModifier(double strengthModifier) {
            this.strengthModifier = strengthModifier;
            return this;
        }
        public StatsModifierBuilder agilityModifier(double agilityModifier) {
            this.agilityModifier = agilityModifier;
            return this;
        }
        public StatsModifierBuilder intellectModifier(double intellectModifier) {
            this.intellectModifier = intellectModifier;
            return this;
        }
        public StatsModifierBuilder movementModifier(double movementModifier) {
            this.movementModifier = movementModifier;
            return this;
        }
        public StatsModifierBuilder offensiveModifier(double offensiveModifier) {
            this.offensiveModifier = offensiveModifier;
            return this;
        }
        public StatsModifierBuilder defenseModifier(double defenseModifier) {
            this.defenseModifier = defenseModifier;
            return this;
        }
        public StatsModifierBuilder armorModifier(double armorModifier) {
            this.armorModifier = armorModifier;
            return this;
        }
        public StatsModifierBuilder experienceModifier(int experienceModifier) {
            this.experienceModifier = experienceModifier;
            return this;
        }
        public StatsModifierBuilder livesLeftModifier(int livesLeftModifier) {
            this.livesLeftModifier = livesLeftModifier;
            return this;
        }
        public StatsModifierBuilder particalImmunityModifier (double partialImmunityModifer) {
            this.partialImmunityModifer = partialImmunityModifer;
            return this;
        }
    }

}
