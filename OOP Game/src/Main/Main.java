package Main;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        /*
        Entity en = new Avatar(new Smasher(), new MapLocationPoint(5, 5));
        Skills skills = new Bane(en);
        skills.increaseLevel();
        int j = 0;
        for (int i = 0; i < 100000; i++) {
            if (skills.successfulPerfoemance())
                j++;
        }
        System.out.println(j);
        */
    }
}
