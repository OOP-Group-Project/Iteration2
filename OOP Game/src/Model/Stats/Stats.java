package Model.Stats;

/**
 * Created by walkhard on 2/18/16.
 */
public class Stats {
    // constructor takes level to determine stats
    public Stats(int lvl) {
        lives = 5;  //number of lives left
        str = 3*lvl;    //strength
        agi = 3*lvl;    //agility
        intl = 3*lvl;   //intellect
        har = 3*lvl;    //hardiness
        exp = 0;    //experience
        mov = 1;    //movement
        level = lvl;
    }

    // primary stats
    private int lives;
    private int str;
    private int agi;
    private int intl;
    private int har;
    private int exp;
    private int mov;

    // derived stats
    private int level;
    private int hp = har*level;
    private int mp = intl*level;
    private int dmg = str*level;
    private int def = agi*level;
    private int arm = har;

    // accessors
    public int lives() {return lives;}
    public int strength() {return str;}
    public int agility() {return agi;}
    public int intellect() {return intl;}
    public int hardiness() {return har;}
    public int experience() {return exp;}
    public int movement() {return mov;}
    public int life() {return hp;}
    public int mana() {return mp;}
    public int offenseRating() {return dmg;}
    public int defenseRating() {return def;}
    public int armorRating() {return arm;}
    public int level() {return level;}

    // mutators
    public void livesUp() {return lives;}
    public void strengthUp() {return str;}
    public void agilityUp() {return agi;}
    public void intellectUp() {return intl;}
    public void hardinessUp() {return har;}
    public void experienceUp() {return exp;}
    public void movementUp() {return mov;}
    public void lifeUp() {return hp;}
    public void manaUp() {return mp;}
    public void offenseRatingUp() {return dmg;}
    public void defenseRatingUp() {return def;}
    public void armorRatingUp() {return arm;}
    public void levelUp() {return level;}

}
