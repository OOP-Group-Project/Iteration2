package Main.Game.Model.Map;

import java.awt.*;

/**
 * Created by Michael on 3/7/16.
 */
public class Hex {

    private int x;
    private int y;
    private Point centerPoint;
    private Point[] vertices = new Point[6];

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setCenter(int x, int y){
        centerPoint = null;
    }

    public void calculateVertices(){

    }

    public void render(Graphics g){

    }


}
