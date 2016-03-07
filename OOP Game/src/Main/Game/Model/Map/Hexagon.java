package Main.Game.Model.Map;

import java.awt.*;

/**
 * Created by Michael on 3/7/16.
 */
public class Hexagon {
    public static boolean XYVertex = true;	//true: x,y are the co-ords of the first vertex.
    //false: x,y are the co-ords of the top left rect. co-ord.

    private static int BORDERS = 20;	//default number of pixels for the border.
    private static int[] xPoints = new int[6];
    private static int[] yPoints = new int[6];

    private static int s = 0;	// length of one side
    private static int t = 0;	// short side of 30o triangle outside of each hex
    private static int r = 0;	// radius of inscribed circle (centre to middle of each side). r= h/2
    private static int h = 0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.


    // Remember the current position
    private static int currentX;
    private static int currentY;

    public void setXYasVertex(boolean b) {
        XYVertex = b;
    }
    public void setBorders(int b){
        BORDERS = b;
    }

    /** This functions takes the Side length in pixels and uses that as the basic dimension of the hex.
     It calculates all other needed constants from this dimension.
     */
    public static void setSide(int side) {
        s = side;
        t = (s / 2);			//t = s sin(30) = (int) CalculateH(s);
        r =  (int) (s * 0.8660254037844);	//r = s cos(30) = (int) CalculateR(s);
        h = 2 * r;
    }

    /*********************************************************
     Name: hex()
     Parameters: (x0,y0) This point is normally the top left corner
     of the rectangle enclosing the hexagon.
     However, if XYVertex is true then (x0,y0) is the vertex of the
     top left corner of the hexagon.
     Returns: a polygon containing the six points.
     Called from: drawHex(), fillhex()
     Purpose: This function takes two points that describe a hexagon
     and calculates all six of the points in the hexagon.
     *********************************************************/
    public static Polygon hex (int x, int y) {
        for(int i =0; i < 6; i++) {
            xPoints[i] = (int)(x + r * Math.cos(i * 2 * Math.PI / 6));
            yPoints[i] = (int)(y + r * Math.sin(i * 2 * Math.PI / 6));
        }
//        int y = y0 + BORDERS;
//        int x = x0 + BORDERS; // + (XYVertex ? t : 0); //Fix added for XYVertex = true.
//        // NO! Done below in cx= section
//        if (s == 0  || h == 0) {
//            System.out.println("ERROR: size of hex has not been set");
//            return new Polygon();
//        }
//
//        int[] cx,cy;
//
////I think that this XYvertex stuff is taken care of in the int x line above. Why is it here twice?
//        if (XYVertex)
//            cx = new int[] {x,x+s,x+s+t,x+s,x,x-t};  //this is for the top left vertex being at x,y. Which means that some of the hex is cutoff.
//        else
//            cx = new int[] {x+t,x+s+t,x+s+t+t,x+s+t,x+t,x};	//this is for the whole hexagon to be below and to the right of this point
//
//        cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r};

        return new Polygon(xPoints,yPoints,6);
    }

    /********************************************************************
     Name: drawHex()
     Parameters: (i,j) : the x,y coordinates of the inital point of the hexagon
     g2: the Graphics2D object to draw on.
     Returns: void
     Calls: hex()
     Purpose: This function draws a hexagon based on the initial point (x,y).
     The hexagon is drawn in the colour specified in hexgame.COLOURELL.
     *********************************************************************/
    public static void render(int i, int j, Graphics g) {
        String position = "x: " + i + "\t" + "y: " + j;
        int x = i * (s+t);
        int y = j * h + (i%2) * h/2;

        currentX = x;
        currentY = y;
        Polygon poly = hex(x,y);
        g.setColor(Color.BLACK);
//        g.drawString(position ,x,y);
        g.setColor(Color.red);
        g.fillPolygon(poly);
        g.setColor(Color.pink);
        g.drawPolygon(poly);
    }
}
