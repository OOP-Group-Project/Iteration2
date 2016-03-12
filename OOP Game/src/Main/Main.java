package Main;

import Main.Model.DirectionEnum;
import Main.Model.Map.MapLocationPoint;
import Main.Model.Skills.LinearEffect;
import sun.misc.Queue;

public class Main {
    /*
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
    */
    public static void main(String[] args) {
        LinearEffect le = new LinearEffect();
        Queue<MapLocationPoint> q = le.getAffectedArea(5, 5, 3, DirectionEnum.DownLeft);
        while(!q.isEmpty())
            try {
                System.out.println(q.dequeue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
