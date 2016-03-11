package Main.View.Renderers.StateViewports;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import Main.Model.Inventory.Inventory;
import Main.Model.State.InventoryState;
import Main.View.Viewport;

public class InventoryStateViewport extends StateViewport{
    private final String FONT_USE = "Calibri (Body)";
    
    //SCREEN DIMENSION
    private final int WIDTH = 700;
    private final int HEIGHT = 700;
    
    //INVENTORY TITLE
    private final int TITLE_START_X = (int) (WIDTH * 0.1);
    private final int TITLE_START_Y = (int) (HEIGHT * 0.05);
    private final int TITLE_WIDTH = (int) (WIDTH * 0.8);
    private final int TITLE_HEIGHT = (int) (HEIGHT * 0.15);


    //INVETORY DIMENSION
    private final int INVENTORY_VIEW_X_START = (int) (WIDTH * 0.1);
    private final int INVENTORY_VIEW_Y_START = TITLE_START_Y + TITLE_HEIGHT;
    private final int INVENTORY_VIEW_WIDTH = (int) (WIDTH * 0.8);
    private final int INVENTORY_VIEW_HEIGHT = (int) (HEIGHT * 0.52);

    //ITEM VIEW DIMENSION
    private final int ITEM_VIEW_X_START = INVENTORY_VIEW_X_START;
    private final int ITEM_VIEW_Y_START = INVENTORY_VIEW_Y_START;
    private final int ITEM_VIEW_WIDTH = INVENTORY_VIEW_WIDTH;
    private final int ITEM_VIEW_HEIGHT = (int) (INVENTORY_VIEW_HEIGHT * 0.7);

    private final int ITEM_MARGIN = 15;
    private int ITEM_WIDTH = (ITEM_VIEW_WIDTH - (InventoryState.SectionToShow.Inventory.getItemsPerRow() + 1) * ITEM_MARGIN) / InventoryState.SectionToShow.Inventory.getItemsPerRow();
    private int ITEM_HEIGHT = ITEM_WIDTH;

    //INFO VIEW DIMENSION
    private final int INFO_VIEW_X_START = INVENTORY_VIEW_X_START;
    private final int INFO_VIEW_Y_START = ITEM_VIEW_Y_START + ITEM_VIEW_HEIGHT;
    private final int INFO_VIEW_WIDTH = INVENTORY_VIEW_WIDTH;
    private final int INFO_VIEW_HEIGHT = INVENTORY_VIEW_HEIGHT - ITEM_VIEW_HEIGHT;

    private final int INFO_X_MARGIN = 40;
    private final int INFO_Y_MARGIN = (int) (INFO_VIEW_HEIGHT * 0.2);
    private final int INFO_ELEMENT_HEIGHT = (int) (INFO_VIEW_HEIGHT - INFO_Y_MARGIN * 2);
    private final int INFO_DESCRIPTION_WIDTH = (int) (INFO_VIEW_WIDTH - 2 * INFO_ELEMENT_HEIGHT - 4 * INFO_X_MARGIN);

    private Font font;
    private Font smallFont;
    private Font largeFont;
    private final Font titleFont = new Font("Calibri (Body)", Font.BOLD, (int)(TITLE_WIDTH*0.1));
	
	
	
	private Viewport viewport;
    private PlayStateViewport playStateViewport;
    private InventoryState inventoryState;

    public InventoryStateViewport(Viewport view, PlayStateViewport playStateViewport, InventoryState invenotryState) {
        this.viewport = view;
        this.playStateViewport = playStateViewport;
        this.inventoryState = invenotryState;
    }

	
	@Override
	public void render(Graphics g) {
		//draw game in background
		playStateViewport.render(g);
		
		 BufferedImage overImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
	     Graphics g2 = overImage.getGraphics();
		
		renderTitle(g2);
		
		renderInventory(g2);
		
		int w = viewport.getPxWidth();
		int h = viewport.getPxHeight();
		
		g.drawImage(overImage, (int)(w*0.1), (int)(h*0.1) , (int)(w*0.8) ,(int)(h*0.75) , null);
	}

    private void renderTitle(Graphics g) {
        int titleMargin = 5;
        int instMargin = 15;

        // Draw the background
        g.setColor(new Color(25, 25, 25));
        g.fillRect(TITLE_START_X, TITLE_START_Y, TITLE_WIDTH, TITLE_HEIGHT);

        // Get ready to draw the title
        g.setFont(titleFont);
        String title = "Inventory";
        FontMetrics fm = g.getFontMetrics(titleFont);
        Rectangle2D titleRect = fm.getStringBounds(title, g);

        // Get the location of the title
        int titleX = TITLE_START_X + TITLE_WIDTH / 2 - (int) titleRect.getWidth() / 2;
        int titleY = TITLE_START_Y + (int) titleRect.getHeight() + titleMargin;

        // Draw the title
        g.setColor(Color.lightGray);
        g.drawString(title, titleX, titleY);

    }
	
	private void renderInventory(Graphics g){
		 BufferedImage overImage = new BufferedImage(ITEM_VIEW_WIDTH, ITEM_VIEW_HEIGHT, BufferedImage.TYPE_INT_RGB);
	     Graphics g2 = overImage.getGraphics();
	     
	     //paint background
	     g2.setColor(new Color(32, 32, 32));
	     g2.fillRect(0, 0, ITEM_VIEW_WIDTH, ITEM_VIEW_HEIGHT);
	     
	     Inventory in = inventoryState.getInventory();
	     int size = in.getSize();
	     Point selected = inventoryState.getSelected();
	     int itemPerRow = InventoryState.SectionToShow.Inventory.getItemsPerRow();
	     
	     int xPosStart = ITEM_MARGIN;
	     int xPosInc = ITEM_MARGIN + ITEM_WIDTH;
	     int yPosInc = ITEM_MARGIN + ITEM_HEIGHT;
	     int xpos = xPosStart;
	     int ypos = ITEM_MARGIN;
	     
	     for (int i = 0; i < size; i++) {
	    	   //selected
	            if (selected.equals(new Point(i%itemPerRow,i/itemPerRow))){
	                g2.setColor(Color.RED);
	                //change
	                g2.drawRect(xpos - 3, ypos - 3, this.ITEM_WIDTH + 6, this.ITEM_HEIGHT + 6);
	            }
	            
	            paintIcon(g2, xpos, ypos, i);
	            
	            //increment for next paint
	            if ((i+1)  % itemPerRow == 0) {
	                xpos = xPosStart;
	                ypos += yPosInc;
	            } else {
	                xpos += xPosInc;
	            }
	     }
	     
	     g.drawImage(overImage, this.ITEM_VIEW_X_START, this.ITEM_VIEW_Y_START, this.ITEM_VIEW_WIDTH, this.ITEM_VIEW_HEIGHT, null);
	}
	
	private void paintIcon(Graphics g, int xpos, int ypos, int pos) {

	        if (true) {
	            //draw empty slot
	            g.setColor(Color.LIGHT_GRAY);
	            g.fillRect(xpos, ypos, ITEM_WIDTH, ITEM_HEIGHT);

	            int xMid = (2 * xpos + ITEM_WIDTH) / 2;

//				g.setFont(new Font(this.FONT_USE, Font.PLAIN, (int)(this.ITEM_HEIGHT*0.6)));
	            g.setFont(largeFont);
	            g.setColor(Color.BLACK);
	            FontMetrics fm = g.getFontMetrics();
	            //g.drawString("?", xMid - fm.stringWidth("?")/2, ypos + fm.getHeight());
	        } else {

	            //draw pic
	            g.setColor(Color.LIGHT_GRAY);
	            g.fillRect(xpos, ypos, ITEM_WIDTH, ITEM_HEIGHT);
	         //   ImageIcon im = Utilities.getImageIcon(ITEM_IMAGE_LOCATION + itemNode.item.getPathToPicture());
	           // g.drawImage(im.getImage(), xpos, ypos, this.ITEM_WIDTH, this.ITEM_HEIGHT, null);


	            //draw amount
	            g.setFont(smallFont);
	            FontMetrics fm = g.getFontMetrics();
	          //  int width = fm.stringWidth(itemNode.amount + "");
	            int height = fm.getHeight();
	            g.setColor(Color.BLACK);
	           // g.drawString("x" + itemNode.amount + "", xpos, ypos + (int) (fm.getHeight() * 0.8));
	        }

	    }
}
