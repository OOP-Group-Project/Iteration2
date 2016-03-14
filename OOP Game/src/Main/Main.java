package Main;

import Main.Controller.Manager.UserActionEnum;
import Main.Controller.ObjectControllers.EntityController.ActionControllers.SkillsControllers.SkillsController;
import Main.Model.DirectionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;
import Main.Model.Entity.Npc;
import Main.Model.Map.Map;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Occupation.Smasher;
import Main.Model.Occupation.Sneak;
import Main.Model.Occupation.Summoner;
import Main.Model.Skills.*;
import sun.misc.Queue;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Game game = new Game();
        //game.start();
        Map map = new Map(20, 20);
        Entity en = new Avatar(new Smasher(), new MapLocationPoint(5,5));

        Entity target = new Npc(new MapLocationPoint(5,5), 10);

        ArrayList<Skills> skills = en.getSkills();

        en.setOrientation(DirectionEnum.Down);

        SkillsController sc = new SkillsController(en, map);

        Observation ob = (Observation) en.getSkills().get(2);

        ArrayList<String> arrString = ob.activate(target, 3);
        System.out.println("----Real----");
        System.out.println(target.getStats().getLevel());
        System.out.println(target.getStats().curLife());
        System.out.println(target.getStats().curOffense());
        System.out.println(target.getStats().curDefense());
        System.out.println("----Observed----");
        for (String str : arrString)
            System.out.println(str);
        System.out.println("----Observed----");
        arrString = ob.activate(target, 3);
        for (String str : arrString)
            System.out.println(str);
        System.out.println("----Observed----");
        arrString = ob.activate(target, 3);
        for (String str : arrString)
            System.out.println(str);



    }
}
