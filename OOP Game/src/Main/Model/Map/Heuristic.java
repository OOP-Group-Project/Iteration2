package Main.Model.Map;

/**
 * Created by Michael on 3/12/16.
 */
public class Heuristic {
    public float getCost(Map map, int x, int y, int tx, int ty) {
        float dx = tx - x;
        float dy = ty - y;

        float result = (float) (Math.sqrt((dx*dx)+(dy*dy)));

        return result;
    }
}
