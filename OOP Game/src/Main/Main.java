package Main;

import Main.Model.Map.MapLocationPoint;
import Main.Model.Skills.RadialEffects;
import sun.misc.Queue;

public class Main {
    public static void main(String[] args) {
        //Game game = new Game();
        //game.start();

        RadialEffects er = new RadialEffects();
        Queue<MapLocationPoint> q = er.getAffectedArea(0, 0, 3);
        Queue<Integer> i = new Queue<>();
        while (!q.isEmpty()) {
            try {
                System.out.println(q.dequeue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
