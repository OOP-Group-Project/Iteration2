package Model.Stats;

/**
 * Created by walkhard on 2/18/16.
 */
public class Stats {
    // constructor takes level to determine stats
    public Stats(int lvl) {
        max_lives = 3;  //number of lives left
        max_str = STAT_MOD * lvl;    //strength
        max_agi = STAT_MOD * lvl;    //agility
        max_int = STAT_MOD * lvl;   //intellect
        max_har = STAT_MOD * lvl;    //hardiness
        cur_exp = 0;    //experience
        max_mov = 1;    //movement
        level = lvl;
    }

    // basic modifiers
    private int STAT_MOD = 3;
    private int EXP_MOD = 100;
    private double EXP_PCT = 0.75;

    // primary stats (maximum)
    private int max_lives;
    private int max_str;
    private int max_agi;
    private int max_int;
    private int max_har;
    private int max_mov;

    // primary stats (current)
    private int cur_lives = max_lives;
    private int cur_str = max_str;
    private int cur_agi = max_agi;
    private int cur_int = max_int;
    private int cur_har = max_har;
    private int cur_mov = max_mov;
    private int cur_exp;

    // derived stats
    private int level;

    // derived stats (maximum)
    private int max_hp = max_har * level;
    private int max_mp = max_int * level;
    private int max_dmg = max_str * level;
    private int max_def = max_agi * level;
    private int max_arm = max_har;
    private int max_exp = (int)(EXP_PCT * (level * EXP_MOD));

    // derived stats (current)
    private int cur_hp;
    private int cur_mp;
    private int cur_dmg;
    private int cur_def;
    private int cur_arm;

    // accessors (maximum)
    public int maxLives() {return max_lives;}
    public int maxStrength() {return max_str;}
    public int maxAgility() {return max_agi;}
    public int maxIntellect() {return max_int;}
    public int maxHardiness() {return max_har;}
    public int maxExperience() {return max_exp;}
    public int maxMovement() {return max_mov;}
    public int maxLife() {return max_hp;}
    public int maxMana() {return max_mp;}
    public int maxOffense() {return max_dmg;}
    public int maxDefense() {return max_def;}
    public int maxArmor() {return max_arm;}
    //
    public int level() {return level;}

    // accessors (current)
    public int curLives() {return cur_lives;}
    public int curStrength() {return cur_str;}
    public int curAgility() {return cur_agi;}
    public int curIntellect() {return cur_int;}
    public int curHardiness() {return cur_har;}
    public int curExperience() {return cur_exp;}
    public int curMovement() {return cur_mov;}
    public int curLife() {return cur_hp;}
    public int curMana() {return cur_mp;}
    public int curOffense() {return cur_dmg;}
    public int curDefense() {return cur_def;}
    public int curArmor() {return cur_arm;}

    // mutators (maximum)
    public void maxLivesUp(int amt) {max_lives += amt;}
    public void maxStrengthUp(int amt) {max_str += amt;}
    public void maxAgilityUp(int amt) {max_agi += amt;}
    public void maxIntellectUp(int amt) {max_int += amt;}
    public void maxHardinessUp(int amt) {max_har += amt;}
    public void maxExperienceUp() {max_exp = (int)(EXP_PCT * (level * EXP_MOD));}
    public void maxMovementUp(int amt) {max_mov += amt;}
    public void maxLifeUp(int amt) {max_hp += amt;}
    public void maxManaUp(int amt) {max_mp += amt;}
    public void maxOffenseUp(int amt) {max_dmg += amt;}
    public void maxDefenseUp(int amt) {max_def += amt;}
    public void maxArmorUp(int amt) {max_arm += amt;}

    // mutators (current)
    public void curLivesUp(int amt) {cur_lives += amt;}
    public void curStrengthUp(int amt) {cur_str += amt;}
    public void curAgilityUp(int amt) {cur_agi += amt;}
    public void curIntellectUp(int amt) {cur_int += amt;}
    public void curHardinessUp(int amt) {cur_har += amt;}
    public void curExperienceUp(int amt) {cur_exp += amt;}
    public void curMovementUp(int amt) {cur_mov += amt;}
    public void curLifeUp(int amt) {cur_hp += amt;}
    public void curManaUp(int amt) {cur_mp += amt;}
    public void curOffenseUp(int amt) {cur_dmg += amt;}
    public void curDefenseUp(int amt) {cur_def += amt;}
    public void curArmorUp(int amt) {cur_arm += amt;}




    public void levelUp(int amt) {level += amt;}

    public void curLivesDown(int amt) {cur_lives -= amt;}
    public void curStrengthDown(int amt) {cur_str -= amt;}
    public void curAgilityDown(int amt) {cur_agi -= amt;}
    public void curIntellectDown(int amt) {cur_int -= amt;}
    public void cuHardinessDown(int amt) {cur_har -= amt;}
    public void curExperienceDown(int amt) {cur_exp -= amt;}
    public void curMovementDown(int amt) {cur_mov -= amt;}
    public void curLifeDown(int amt) {cur_hp -= amt;}
    public void curManaDown(int amt) {cur_mp -= amt;}
    public void curOffenseDown(int amt) {cur_dmg -= amt;}
    public void curDefenseDown(int amt) {cur_def -= amt;}
    public void curArmorRatingDown(int amt) {cur_arm -= amt;}
    public void levelDown(int amt) {level -= amt;}
}