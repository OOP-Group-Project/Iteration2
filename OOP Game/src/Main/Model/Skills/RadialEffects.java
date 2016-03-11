package Main.Model.Skills;

import java.awt.*;

/**
 * Created by AndyZhu on 7/3/2016.
 *
 * Hey visitor, for radial effects, I store the coordinates of affected tiles to an array of Point.
 * Note that: if you call Point.getX(); what you get is actually Y coordinate instead of X. same to Point.getY();
 */
public class RadialEffects implements InfluenceArea{

    public Point[] getAffectedTilesRadius1 (int y, int x) {
        if (x % 2 == 1) {
            Point[] affectedTiles = {
                    new Point(y - 1, x),
                    new Point(y, x - 1),
                    new Point(y, x + 1),
                    new Point(y + 1, x - 1),
                    new Point(y + 1, x),
                    new Point(y + 1, x + 1)
            };
            return affectedTiles;
        }
        else {
            Point[] affectedTiles = {
                    new Point(y - 1, x),
                    new Point(y - 1, x - 1),
                    new Point(y - 1, x + 1),
                    new Point(y, x - 1),
                    new Point(y, x + 1),
                    new Point(y + 1, x)
            };
            return affectedTiles;
        }
    }

    public Point[] getAffectedTilesRadius2 (int y, int x) {
        if (x % 2 == 1) {
            Point[] affectedTiles = {
                    new Point(y - 2, x),
                    new Point(y - 1, x - 2),
                    new Point(y - 1, x - 1),
                    new Point(y - 1, x + 1),
                    new Point(y - 1, x + 2),
                    new Point(y, x - 2),
                    new Point(y, x + 2),
                    new Point(y + 1, x - 2),
                    new Point(y + 1, x + 2),
                    new Point(y + 2, x - 1),
                    new Point(y + 2, x),
                    new Point(y + 2, x + 1)
            };
            return affectedTiles;
        }
        else {
            Point[] affectedTiles = {
                    new Point(y - 2, x),
                    new Point(y + 2, x),
                    new Point(y - 1, x - 2),
                    new Point(y, x - 2),
                    new Point(y + 1, x - 2),
                    new Point(y - 2, x - 1),
                    new Point(y + 1, x - 1),
                    new Point(y - 2, x + 1),
                    new Point(y + 1, x + 1),
                    new Point(y - 1, x + 2),
                    new Point(y, x + 2),
                    new Point(y + 1, x + 2),
            };
            return affectedTiles;
        }
    }

    public Point[] getAffectedTilesRadius3 (int y, int x) {
        if (x % 2 == 1) {
            Point[] affectedTiles = {
                    new Point(y - 3, x),
                    new Point(y - 2, x - 2),
                    new Point(y - 2, x - 1),
                    new Point(y - 2, x + 1),
                    new Point(y - 2, x + 2),
                    new Point(y - 1, x - 3),
                    new Point(y - 1, x + 3),
                    new Point(y, x - 3),
                    new Point(y, x + 3),
                    new Point(y + 1, x - 3),
                    new Point(y + 1, x + 3),
                    new Point(y + 2, x - 3),
                    new Point(y + 2, x - 2),
                    new Point(y + 2, x + 2),
                    new Point(y + 2, x + 3),
                    new Point(y + 3, x - 1),
                    new Point(y + 3, x),
                    new Point(y + 3, x + 1)
            };
            return affectedTiles;
        }
        else {
            Point[] affectedTiles = {
                    new Point(y - 3, x),
                    new Point(y - 2, x - 2),
                    new Point(y - 3, x - 1),
                    new Point(y - 3, x + 1),
                    new Point(y - 2, x + 2),
                    new Point(y - 2, x - 3),
                    new Point(y - 2, x + 3),
                    new Point(y - 1, x - 3),
                    new Point(y - 1, x + 3),
                    new Point(y, x - 3),
                    new Point(y, x + 3),
                    new Point(y + 1, x - 3),
                    new Point(y + 2, x - 2),
                    new Point(y + 2, x + 2),
                    new Point(y + 1, x + 3),
                    new Point(y + 2, x - 1),
                    new Point(y + 3, x),
                    new Point(y + 2, x + 1)
            };
            return affectedTiles;
        }
    }
}
