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
                    if((temp.y - 1) >= 0) {
                        temp.y--;
                    }
                    break;
                case UpLeft:
                    if((temp.x - 1) >= 0 && (temp.y - 1) >= 0){
                        temp.x--;
                        temp.y--;
                    }
                    break;
                case UpRight:
                    if((temp.y - 1) >= 0) {
                        temp.x++;
                        temp.y--;
                    }
                    break;
                case DownLeft:
                    if((temp.x - 1) >= 0) {
                        temp.x--;
                    }
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
                    if ((temp.y - 1) >= 0) {
                        temp.y--;
                    }
                    break;
                case DownLeft:
                    if ((temp.x - 1) >= 0) {
                        temp.x--;
                        temp.y++;
                    }
                    break;
                case DownRight:
                    temp.x++;
                    temp.y++;
                    break;
                case UpLeft:
                    if ((temp.x - 1) >= 0) {
                        temp.x--;
                    }
                    break;
                case UpRight:
                    temp.x++;
                    break;
            }
        }
        return temp;
    }


}
