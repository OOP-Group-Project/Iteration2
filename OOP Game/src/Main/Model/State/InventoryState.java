package Main.Model.State;

import java.awt.Font;
import java.awt.Point;

import Main.Controller.Manager.UserActionEnum;
import Main.Model.Entity.Avatar;
import Main.Model.Inventory.Inventory;
import Main.Model.Items.Item;
import Main.Model.Stats.Stats;



public class InventoryState extends State{
	
	private Avatar avatar;
	
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

	
	public InventoryState(Avatar avatar){
		this.avatar = avatar;
		init();
	}
	
	public void init(){
		ItemSelected = new Point(0,0);
		sectionSelected = SectionToShow.Inventory;
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
		return avatar.getInventory();
	}
	public Stats getStats(){
		return avatar.getStats();
	}
	public Item getItem(int pos){
		return avatar.getInventory().getItemAt(pos );
	}
	public int getItemAmount(int pos){
		return avatar.getInventory().getItemAmountAt(pos );
	}
}
