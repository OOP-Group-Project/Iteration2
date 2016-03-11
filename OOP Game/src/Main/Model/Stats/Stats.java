package Main.Model.Stats;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by walkhard on 2/18/16.
 */

public class Stats {
    //
    public Stats(Map<String, Double> occupation_modifier, int lvl) {
        level = lvl;
        OCCUPATION_STAT_MOD.putAll(occupation_modifier);
        calculatePrimaryStats();
        calculateSecondaryStats();
        setCurExperience();
        changeMaxExperience();
        setMaxMovement();
        setTemp();
        setCur();
    }

    /*

        Modifiers are used to calculate stats without having to remember how much of a stat is required at each level.

            Example: Stats(25) will automatically set each stat based on the character's level so the programmer doesn't
                have to remember what the base stats should be at each level.

    */

    // basic modifiers
    private Map<String, Double> OCCUPATION_STAT_MOD = new HashMap<>();
    private int BASE_STAT_MOD = 3;

    /*

        Stats are broken down into max(imum) stats and cur(rent) stats. Current stats are the current level of the stat.
        Maximum stats are the maximum level. This allows for possible buffing or debuffing of characters in the future.

            Example: character has 40/50 health [cur_hp/max_hp]
            Example: character normally has 40 agility but receives an agility debuff reducing their agility to 30
                     [max_agi/cur_agi]

    */

    // primary stats (maximum)
    private double max_str;    //strength
    private double max_agi;    //agility
    private double max_int;    //intellect
    private double max_har;    //hardiness
    private double max_mov;    //movement
    private int max_exp;       //experience required to reach next level
    private int max_lives;     //number of lives available

    // primary stats (current)
    private double cur_str;
    private double cur_agi;
    private double cur_int;
    private double cur_har;
    private double cur_mov;
    private int cur_exp;
    private int cur_lives;

    // temp primary data
    private double temp_str;
    private double temp_agi;
    private double temp_int;
    private double temp_har;
    private double temp_mov;

    /*

        Derived stats are calculated based on some combination of primary stats. There is not a formal calculation for
        calculating these stats, yet. I included the stats that are supposed to be used to calculate the derived stats
        only.

            Example: max_hp = max_har * level
                max_hp is calculated based on the characters hardiness and level

        The exact calculation can be adjusted at a later time.

    */

    // derived stats
    private int level;

    // derived stats (maximum)
    private double max_hp;  //hardiness and level
    private double max_mp;  //intellect and level
    private double max_off; //strength and level
    private double max_def; //agility and level
    private double max_arm; //hardiness and agility

    // derived stats (current)
    private double cur_hp;
    private double cur_mp;
    private double cur_off;
    private double cur_def;
    private double cur_arm;

    //
    private double temp_hp;
    private double temp_mp;
    private double temp_off;
    private double temp_def;
    private double temp_arm;

    // accessors (maximum)
    public double maxStrength() {return max_str;}
    public double maxAgility() {return max_agi;}
    public double maxIntellect() {return max_int;}
    public double maxHardiness() {return max_har;}
    public double maxMovement() {return max_mov;}
    public double maxLife() {return max_hp;}
    public double maxMana() {return max_mp;}
    public double maxOffense() {return max_off;}
    public double maxDefense() {return max_def;}
    public double maxArmor() {return max_arm;}
    public int maxExperience() {return max_exp;}
    public int maxLives() {return max_lives;}

    //
    public int level() {return level;}

    // accessors (current)
    public double curStrength() {return cur_str;}
    public double curAgility() {return cur_agi;}
    public double curIntellect() {return cur_int;}
    public double curHardiness() {return cur_har;}
    public double curMovement() {return cur_mov;}
    public double curLife() {return cur_hp;}
    public double curMana() {return cur_mp;}
    public double curOffense() {return cur_off;}
    public double curDefense() {return cur_def;}
    public double curArmor() {return cur_arm;}
    public int curExperience() {return cur_exp;}
    public int curLives() {return cur_lives;}

    // setters
    private void setCurExperience(){cur_exp = 0;}
    private void setMaxMovement(){
        double MOV_MOD = 0.025;
        max_mov = (MOV_MOD * level) + 1;
    }
    //
    private void setCur() {
        cur_str = max_str;
        cur_agi = max_agi;
        cur_int = max_int;
        cur_har = max_har;
        cur_hp = max_hp;
        cur_mp = max_mp;
        cur_off = max_off;
        cur_def = max_def;
        cur_mov = max_mov;
        cur_arm = max_arm;
    }
    //
    private void setTemp() {
        temp_str = max_str;
        temp_agi = max_agi;
        temp_int = max_int;
        temp_har = max_har;
        temp_hp = max_hp;
        temp_mp = max_mp;
        temp_off = max_off;
        temp_def = max_def;
        temp_mov = max_mov;
        temp_arm = max_arm;
    }
    /*

        Mutators are designed to take values as percents or actual values. This is a bit of future-
        proofing allowing for buffing and debuffing in the future in addition to current use in changing
        stats through levelling, area of effect, etc.

            Example: Percents [-0.99, 0.99] and values [-inf, -1.00] U [1.00, inf].

    */

    // mutators (maximum)
    private void changeMaxLives(int amt) {
        if(amt > 0)
            max_lives += amt;
        else if(amt < 0)
            max_lives -= amt;
    }
    private void changeMaxStrength(double amt) {
        // change stat
        if(amt > 0.99)
            max_str += amt;
        else if(amt < -0.99)
            max_str -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            max_str += max_str * amt;
        else if(amt > -1.00 && amt <= 0.00)
            max_str -= max_str * amt;
    }
    private void changeMaxAgility(double amt) {
        // change stat
        if(amt > 0.99)
            max_agi += amt;
        else if(amt < -0.99)
            max_agi -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            max_agi += max_agi * amt;
        else if(amt > -1.00 && amt <= 0.00)
            max_agi -= max_agi * amt;
    }
    private void changeMaxIntellect(double amt) {
        // change stat
        if(amt > 0.99)
            max_int += amt;
        else if(amt < -0.99)
            max_int -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            max_int += max_int * amt;
        else if(amt > -1.00 && amt <= 0.00)
            max_int -= max_int * amt;
    }
    private void changeMaxHardiness(double amt) {
        // change stat
        if(amt > 0.99)
            max_har += amt;
        else if(amt < -0.99)
            max_har -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            max_har += max_har * amt;
        else if(amt > -1.00 && amt <= 0.00)
            max_har -= max_har * amt;
    }
    private void changeMaxMovement(double amt) {
        // change stat
        if(amt > 0.99)
            max_mov += amt;
        else if(amt < -0.99)
            max_mov -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            max_mov += max_mov * amt;
        else if(amt > -1.00 && amt <= 0.00)
            max_mov -= max_mov * amt;
    }
    private void changeMaxLife(double amt) {
        // change stat
        if(amt > 0.99)
            max_hp += amt;
        else if(amt < -0.99)
            max_hp -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            max_hp += max_hp * amt;
        else if(amt > -1.00 && amt <= 0.00)
            max_hp -= max_hp * amt;
    }
    private void changeMaxMana(double amt) {
        // change stat
        if(amt > 0.99)
            max_mp += amt;
        else if(amt < -0.99)
            max_mp -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            max_mp += max_mp * amt;
        else if(amt > -1.00 && amt <= 0.00)
            max_mp -= max_mp * amt;
    }
    private void changeMaxOffense(double amt) {
        // change stat
        if(amt > 0.99)
            max_off += amt;
        else if(amt < -0.99)
            max_off -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            max_off += max_off * amt;
        else if(amt > -1.00 && amt <= 0.00)
            max_off -= max_off * amt;
    }
    private void changeMaxDefense(double amt) {
        // change stat
        if(amt > 0.99)
            max_def += amt;
        else if(amt < -0.99)
            max_def -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            max_def += max_def * amt;
        else if(amt > -1.00 && amt <= 0.00)
            max_def -= max_def * amt;
    }
    private void changeMaxArmor(double amt) {
        // change stat
        if(amt > 0.99)
            max_arm += amt;
        else if(amt < -0.99)
            max_arm -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            max_arm += max_arm * amt;
        else if(amt > -1.00 && amt <= 0.00)
            max_arm -= max_arm * amt;
    }
    private void changeMaxExperience() {
        int EXP_MOD = 100;
        double EXP_PCT = 0.75;
        max_exp = (int)(EXP_PCT * (level * EXP_MOD));
    }

    // mutators (current)
    private void changeCurLives(int amt) {
        // change stat
        if(amt > 0)
            cur_lives += amt;
        else if(amt < 0)
            cur_lives -= amt;
        // make sure the change makes sense
        if (cur_lives > max_lives)
            cur_lives = max_lives;
        else if(cur_lives < 0)
            cur_lives = 0;
    }
    private void changeCurStrength(double amt) {
        // change stat
        if(amt > 0.99)
            cur_str += amt;
        else if(amt < -0.99)
            cur_str -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            cur_str += cur_str * amt;
        else if(amt > -1.00 && amt <= 0.00)
            cur_str -= cur_str * amt;
        // make sure the change makes sense
        if (cur_str > max_str)
            cur_str = max_str;
        else if(cur_str < 0)
            cur_str = 0;
    }
    private void changeCurAgility(double amt) {
        // change stat
        if(amt > 0.99)
            cur_agi += amt;
        else if(amt < -0.99)
            cur_agi -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            cur_agi += cur_agi * amt;
        else if(amt > -1.00 && amt <= 0.00)
            cur_agi -= cur_agi * amt;
        // make sure the change makes sense
        if (cur_agi > max_agi)
            cur_agi = max_agi;
        else if(cur_agi < 0)
            cur_agi = 0;
    }
    private void changeCurIntellect(double amt) {
        // change stat
        if(amt > 0.99)
            cur_int += amt;
        else if(amt < -0.99)
            cur_int -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            cur_int += cur_int * amt;
        else if(amt > -1.00 && amt <= 0.00)
            cur_int -= cur_int * amt;
        // make sure the change makes sense
        if (cur_int > max_int)
            cur_int = max_int;
        else if(cur_int < 0)
            cur_int = 0;
    }
    private void changeCurHardiness(double amt) {
        // change stat
        if(amt > 0.99)
            cur_har += amt;
        else if(amt < -0.99)
            cur_har -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            cur_har += cur_har * amt;
        else if(amt > -1.00 && amt <= 0.00)
            cur_har -= cur_har * amt;
        // make sure the change makes sense
        if (cur_har > max_har)
            cur_har = max_har;
        else if(cur_har < 0)
            cur_har = 0;
    }
    private void changeCurMovement(double amt) {
        // change stat
        if(amt > 0.99)
            cur_mov += amt;
        else if(amt < -0.99)
            cur_mov -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            cur_mov += cur_mov * amt;
        else if(amt > -1.00 && amt <= 0.00)
            cur_mov -= cur_mov * amt;
        // make sure the change makes sense
        if (cur_mov > max_mov)
            cur_mov = max_mov;
        else if(cur_mov < 0)
            cur_mov = 0;
    }
    private void changeCurLife(double amt) {
        // change stat
        if(amt > 0.99)
            cur_hp += amt;
        else if(amt < -0.99)
            cur_hp -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            cur_hp += cur_hp * amt;
        else if(amt > -1.00 && amt <= 0.00)
            cur_hp -= cur_hp * amt;
        // make sure the change makes sense
        if (cur_hp > max_hp)
            cur_hp = max_hp;
        else if(cur_hp < 0)
            cur_hp = 0;
    }
    private void changeCurMana(double amt) {
        // change stat
        if(amt > 0.99)
            cur_mp += amt;
        else if(amt < -0.99)
            cur_mp -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            cur_mp += cur_mp * amt;
        else if(amt > -1.00 && amt <= 0.00)
            cur_mp -= cur_mp * amt;
        // make sure the change makes sense
        if (cur_mp > max_mp)
            cur_mp = max_mp;
        else if(cur_mp < 0)
            cur_mp = 0;
    }
    private void changeCurOffense(double amt) {
        // change stat
        if(amt > 0.99)
            cur_off += amt;
        else if(amt < -0.99)
            cur_off -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            cur_off += cur_off * amt;
        else if(amt > -1.00 && amt <= 0.00)
            cur_off -= cur_off * amt;
        // make sure the change makes sense
        if (cur_off > max_arm)
            cur_arm = max_arm;
        else if(cur_arm < 0)
            cur_arm = 0;
    }
    private void changeCurDefense(double amt) {
        // change stat
        if(amt > 0.99)
            cur_def += amt;
        else if(amt < -0.99)
            cur_def -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            cur_def += cur_def * amt;
        else if(amt > -1.00 && amt <= 0.00)
            cur_def -= cur_def * amt;
        // make sure the change makes sense
        if (cur_def > max_def)
            cur_def = max_def;
        else if(cur_def < 0)
            cur_def = 0;
    }
    private void changeCurArmor(double amt) {
        // change stat
        if(amt > 0.99)
            cur_arm += amt;
        else if(amt < -0.99)
            cur_arm -= amt;
        else if(amt >= 0.0 && amt < 1.00)
            cur_arm += cur_arm * amt;
        else if(amt > -1.00 && amt <= 0.00)
            cur_arm -= cur_arm * amt;
        // make sure the change makes sense
        if (cur_arm > max_arm)
            cur_arm = max_arm;
        else if(cur_arm < 0)
            cur_arm = 0;
    }
    private void changeCurExperience(int amt){cur_exp += amt;}
    //
    private void changeLevel(int amt) {
        if (amt > 0)
            level += amt;
        else if (amt < 0)
            level -= amt;
    }

    //
    private void calculatePrimaryStats() {
        max_str = OCCUPATION_STAT_MOD.get("str") * BASE_STAT_MOD * level;
        max_agi = OCCUPATION_STAT_MOD.get("agi") * BASE_STAT_MOD * level;
        max_int = OCCUPATION_STAT_MOD.get("int") * BASE_STAT_MOD * level;
        max_har = OCCUPATION_STAT_MOD.get("har") * BASE_STAT_MOD * level;
    }

    //
    private void calculateSecondaryStats() {
        int SCALE_MOD = 10;
        max_hp = (max_har * SCALE_MOD) / BASE_STAT_MOD;  //hardiness and level
        max_mp = (max_int * SCALE_MOD) / BASE_STAT_MOD;  //intellect and level
        max_off = (max_str * SCALE_MOD) / BASE_STAT_MOD; //strength and level
        max_def = (max_agi * SCALE_MOD) / BASE_STAT_MOD; //agility and level
        max_arm = (((max_har + max_agi) / 2) * SCALE_MOD) / BASE_STAT_MOD; //hardiness and agility
    }

    // mutators
    public void modify(String stat_to_modify, Double amt) {
        switch(stat_to_modify) {
            case "str": changeCurStrength(amt);
                        break;
            case "agi": changeCurAgility(amt);
                        break;
            case "int": changeCurIntellect(amt);
                        break;
            case "har": changeCurHardiness(amt);
                        break;
            case "hp":  changeCurLife(amt);
                        break;
            case "mp":  changeCurMana(amt);
                        break;
            case "off": changeCurOffense(amt);
                        break;
            case "def": changeCurDefense(amt);
                        break;
            case "arm": changeCurArmor(amt);
                        break;
            case "mov": changeCurMovement(amt);
                        break;
        }
        calculateSecondaryStats();
    }
    //
    public void modifyLives(int amt){changeCurLives(amt);}
    //
    public void modifyExperience(int amt) {changeCurExperience(amt);}
    //
    public void levelUp() {
        changeLevel(1);
        calculatePrimaryStats();
        calculateSecondaryStats();
        setTemp();
        setCur();
    }
    //
    public void buff(String stat_to_buff, Double amt) {
        switch(stat_to_buff) {
            case "str": changeMaxStrength(amt);
                        changeCurStrength(amt);
                        break;
            case "agi": changeMaxAgility(amt);
                        changeCurAgility(amt);
                        break;
            case "int": changeMaxIntellect(amt);
                        changeCurIntellect(amt);
                        break;
            case "har": changeMaxHardiness(amt);
                        changeCurHardiness(amt);
                        break;
            case "hp":  changeMaxLife(amt);
                        changeCurLife(amt);
                        break;
            case "mp":  changeMaxMana(amt);
                        changeCurMana(amt);
                        break;
            case "off": changeMaxOffense(amt);
                        changeCurOffense(amt);
                        break;
            case "def": changeMaxDefense(amt);
                        changeCurDefense(amt);
                        break;
            case "arm": changeMaxArmor(amt);
                        changeCurArmor(amt);
                        break;
            case "mov": changeMaxMovement(amt);
                        changeCurMovement(amt);
                        break;
        }
        calculateSecondaryStats();
    }
    //
    public void revert() {
        cur_hp = temp_hp * cur_hp / max_hp ;
        cur_mp = temp_mp * cur_mp / max_mp;
        max_str = temp_str;
        max_agi = temp_agi;
        max_int = temp_int;
        max_har = temp_har;
        max_hp = temp_hp;
        max_mp = temp_mp;
        max_off = temp_off;
        max_def = temp_def;
        max_mov = temp_mov;
        max_arm = temp_arm;
    }

    // print
    public void printStats() {
        // primary stats
        System.out.println("Primary Stats:");
        System.out.println("Level: " + level());
        System.out.println("Lives: " + curLives() + "/" + maxLives());
        System.out.println("Experience: " + curExperience() + "/" + maxExperience());
        System.out.println("Strength: " + curStrength() + "/" + maxStrength());
        System.out.println("Agility: " + curAgility() + "/" + maxAgility());
        System.out.println("Intellect: " + curIntellect() + "/" + maxIntellect());
        System.out.println("Hardiness: " + curHardiness() + "/" + maxHardiness());
        System.out.println("Movement: " + curMovement() + "/" + maxMovement());
        // secondary stats
        System.out.println("Secondary Stats:");
        System.out.println("Life: " + curLife() + "/" + maxLife());
        System.out.println("Mana: " + curMana() + "/" + maxMana());
        System.out.println("Offense: " + curOffense() + "/" + maxOffense());
        System.out.println("Defense: " + curDefense() + "/" + maxDefense());
        System.out.println("Armor: " + curArmor() + "/" + maxArmor());
    }
}