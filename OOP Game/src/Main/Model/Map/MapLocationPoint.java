package Main.Model.Map;

import Main.Model.DirectionEnum;

import java.awt.*;

/**
 * Created by mason on 3/10/16.
 */

public class MapLocationPoint extends Point {

    public MapLocationPoint(int x, int y) {
        super(x, y);
    }

    public void move(DirectionEnum direction) {
        MapLocationPoint adjacent = getAdjacent(direction);
        super.x = adjacent.x;
        super.y = adjacent.y;
    }

    public MapLocationPoint getAdjacent(DirectionEnum direction) {
        MapLocationPoint temp = (MapLocationPoint)this.clone();
        if(super.x % 2 == 0) {
            switch(direction) {
                case Down:
                    temp.y++;
                    break;
                case Up:
                    temp.y--;
                    break;
                case UpLeft:
                    temp.x--;
                    temp.y--;
                    break;
                case UpRight:
                    temp.x++;
                    temp.y--;
                    break;
                case DownLeft:
                    temp.x--;
                    break;
                case DownRight:
                    temp.x++;
                    break;
            }
        } else {
            switch(direction) {
                case Down:
                    temp.y++;
                    break;
                case Up:
                    temp.y--;
                    break;
                case DownLeft:
                    temp.x--;
                    temp.y++;
                    break;
                case DownRight:
                    temp.x++;
                    temp.y++;
                    break;
                case UpLeft:
                    temp.x--;
                    break;
                case UpRight:
                    temp.x++;
                    break;
            }
        }
        return temp;
    }

    /**
     * calculate the distance from this location to another
     * sometimes gives bad results
     * TODO: fix it
     * */

    public int getTileDistance(MapLocationPoint mlp)
    {
        int x1 = (int) this.getX();
        int x2 = (int) mlp.getX();
        int y1 = (int) this.getY();
        int y2 = (int) mlp.getY();
        int dx = x2 - x1;     // signed deltas
        int dy = y2 - y1;
        int x = Math.abs(dx);  // absolute deltas
        int y = Math.abs(dy);
        // special case if we start on an odd row or if we move into negative x direction
        if ((dx < 0)^((y1&1)==1))
            x = Math.max(0, x - (y + 1) / 2);
        else
            x = Math.max(0, x - (y) / 2);
        return x + y;
    }


}
