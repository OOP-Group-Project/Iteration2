package Main.View.Renderers.StateViewports;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import Main.Model.State.StartMenuState;
import Main.View.Viewport;

public class StartMenuStateViewport extends StateViewport{

	//SCREEN DIMENSION
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;
	
	private static final int BUTTON_WIDTH = 200;
	private static final int BUTTON_HEIGHT = 32;

	//title
	private static final String TITLE = "Title Here";
	private static final Font TITLE_FONT = new Font("Calibri (Body)", Font.BOLD, (int)(HEIGHT*0.2));
	
	private static final Font VIEW_FONT = new Font("Calibri (Body)", Font.PLAIN, (int)(HEIGHT*0.05));
	
	private Viewport viewport;
	private StartMenuState startMenuState;
	
	private String[] option; 
	
	
	
	public StartMenuStateViewport(Viewport view, StartMenuState startMenuState) {
		this.viewport = view;
		this.startMenuState = startMenuState;
		
		init();
	}
	
	public void init(){
		option = startMenuState.getOptionsToString();
	}
	
	@Override
	public void render(Graphics g) {
		BufferedImage overImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
	    Graphics g2 = overImage.getGraphics();
		
		renderBackground(g2);

		renderTitle(g2);

		renderButtons(g2);
		
		int w = viewport.getPxWidth();
		int h = viewport.getPxHeight();
		
		g.drawImage(overImage, 0, 0 , w ,h , null);
	}
	
	private void renderBackground(Graphics g){
		BufferedImage overImage = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
	    Graphics g2 = overImage.getGraphics();
	    
	    g2.setColor(new Color(125,59,191));
	    g2.fillRect(0, 0, WIDTH, HEIGHT);
	    
	    g.drawImage(overImage, 0, 0, WIDTH, HEIGHT, null);
	}	
	
	private void renderTitle(Graphics g){
		BufferedImage overImage = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
	    Graphics g2 = overImage.getGraphics();
	    

        g2.setFont(TITLE_FONT);
        FontMetrics fm = g2.getFontMetrics();

        Rectangle2D rectangle = fm.getStringBounds(TITLE,g2);


        int x = WIDTH / 2 - (int)rectangle.getWidth() / 2;
        int y = (int)rectangle.getHeight();
        
        g2.setColor(new Color(0,100,255));
        g2.drawString(TITLE, x, y);
	    
	    g.drawImage(overImage, 0, 0, WIDTH, HEIGHT, null);
	}
	
	private void renderButtons(Graphics g){
		BufferedImage overImage = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
	    Graphics g2 = overImage.getGraphics();
		
	    g2.setFont(VIEW_FONT);
        FontMetrics fm = g2.getFontMetrics();
        
        int x = WIDTH*6/10;
        int y = HEIGHT*4/10;
        
        Color defaultColor = Color.YELLOW;
        Color selectedColor = Color.RED;
        
        for(int i =0; i < option.length; i++){
        	
        	Rectangle2D rectangle = fm.getStringBounds(option[i],g2);
        	
        	if(option[i].equals(startMenuState.getStringSelected())){
        		  g2.setColor(selectedColor);
                  g2.drawString(option[i], x, y);
            } else {
                g2.setColor(defaultColor);
                g2.drawString(option[i], x, y);
            }

            y += fm.getHeight();
        }
        
	    g.drawImage(overImage, 0, 0, WIDTH, HEIGHT, null);
	}
}
