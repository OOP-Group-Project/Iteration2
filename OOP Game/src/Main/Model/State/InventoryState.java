package Main.Model.State;

import java.awt.Font;
import java.awt.Point;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Inventory.Inventory;
import Main.Model.Stats.Stats;



public class InventoryState extends State{
	private int ITEM_PER_ROW = 10;
	
	
	private Inventory inventory;
	private Stats stats;
	
	private Point ItemSelected;
	
	private SectionToShow sectionSelected;
	
	public enum SectionToShow{
		Inventory(10),Gear(3);
		
		private int itemPerRow;
		private int itemPerCol;
		
		private SectionToShow(int itemPerRow){
			this.itemPerRow = itemPerRow;
			this.itemPerCol = 3;
		}
		public int getItemsPerRow() {return itemPerRow;}
		public int getItemPerCol() {return itemPerCol;}
	}
	
	//JUST FOR TEST 
	public InventoryState(){
		this.inventory = new Inventory(); 
		init();
	}
	
	public InventoryState(Inventory inventory, Stats stats){
		this.inventory = inventory;
		this.stats = stats;
		
		init();
	}
	
	public void init(){
		ItemSelected = new Point(0,0);
		sectionSelected = SectionToShow.Inventory;
	}

	public void init(Inventory inventory) {
		init();
		this.inventory = inventory;
	}
	
	public Point getSelected(){
		return ItemSelected;
	}
	
	public void moveSelect(Point p){
		
		ItemSelected.translate(p.x,p.y);
		
		if(ItemSelected.x < 0){
			ItemSelected.x = sectionSelected.itemPerRow -1;
		}
		if(ItemSelected.x >= sectionSelected.itemPerRow){
			ItemSelected.x = 0;
		}
		
		if(ItemSelected.y < 0){
			ItemSelected.y = sectionSelected.itemPerCol -1;
		}
		if(ItemSelected.y >= sectionSelected.itemPerCol){
			ItemSelected.y = 0;
		}
		
	}
	
	
	//SHOULDN'T BE HERE
	public Inventory getInventory(){
		return inventory;
	}
	public Stats getStats(){
		return stats;
	}
}
