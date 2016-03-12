package Main;

import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;
import Main.Model.Entity.EntityTypeEnum;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Smasher;
import Main.Model.Skills.Bane;
import Main.Model.Skills.Skills;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Game game = new Game();
        //game.start();
        Entity en = new Avatar(new Smasher(), new MapLocationPoint(5, 5));
        Skills skills = new Bane(en);
        skills.increaseLevel();
        int j = 0;
        for (int i = 0; i < 100000; i++) {
            if (skills.successfulPerfoemance())
                j++;
        }
        System.out.println(j);
    }
}
