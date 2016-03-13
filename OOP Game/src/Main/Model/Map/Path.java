package Main.Model.Map;

import java.util.ArrayList;

/**
 * Created by Michael on 3/12/16.
 */
public class Path {
    private ArrayList<MapLocationPoint> points = new ArrayList<>();

    public Path() {

    }
    public int getLength() {
        return points.size();
    }

    public MapLocationPoint getPoint(int index) {
        return points.get(index);
    }

    public int getX(int index) {
        return points.get(index).x;
    }

    public int getY(int index) {
        return points.get(index).y;
    }

    public void appendStep(int x, int y) {
        points.add(new MapLocationPoint(x,y));
    }

    public void prependStep(int x, int y) {
        points.add(0, new MapLocationPoint(x, y));
    }

    public boolean contains(int x, int y) {
        return points.contains(new MapLocationPoint(x,y));
    }

}

