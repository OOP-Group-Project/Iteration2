package Map;

import java.awt.image.BufferedImage;

public class Tile {
	
	private BufferedImage image;
	private int type;
	
	//TYPE OF TYLES
	public static final int GRASS =0;
	public static final int MOUNTAIN = 1;
	public static final int WATER = 2;
	
	public Tile(BufferedImage image, int type){
		this.image = image;
		this.type = type;
	}
	
	public BufferedImage getImage(){return image;}
	public int getType(){return type;}
}
