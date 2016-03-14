package Main.Model.State;

import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;
import Main.Model.Inventory.Inventory;
import Main.Model.Map.Map;
import Main.Model.Stats.Stats;

import java.awt.*;

/**
 * Created by Michael on 3/14/16.
 */
public class TradeState extends State{
    private int ITEM_PER_ROW = 10;

    private Avatar player;
    private Inventory entityInventory;
    private Point itemSelected;
    private SectionToShow sectionSelected;

    public enum SectionToShow{
        Inventory(10),Gear(3);

        private int itemPerRow;
        private int itemperCol;

        private SectionToShow(int itemPerRow){
            this.itemPerRow = itemPerRow;
            this.itemperCol = 3;
        }

        public int getItemsPerRow(){ return itemPerRow;}
        public int getItemperCosl() { return itemperCol;}
    }



    public TradeState(Avatar player){
        this.player = player;
        this.entityInventory = null;
        init();
    }

    public void setTradeState(Inventory entityInventory){
        this.entityInventory = entityInventory;
    }
    public void reset(){
        this.entityInventory = null;
    }

    public void init(){
        itemSelected = new Point(0,0);
        sectionSelected = SectionToShow.Inventory;
    }

    public Point getSelected() { return itemSelected;}

    public void moveSelect(Point p){
        itemSelected.translate(p.x,p.y);

        if(itemSelected.x < 0){
            itemSelected.x = sectionSelected.itemPerRow - 1;
        }
        if(itemSelected.x >= sectionSelected.itemPerRow){
            itemSelected.x = 0;
        }

        if(itemSelected.y < 0){
            itemSelected.y = sectionSelected.itemperCol - 1;
        }
        if(itemSelected.y >= sectionSelected.itemperCol){
            itemSelected.y = 0;
        }
    }

    //SHOULDN'T BE HERE
    public Inventory getPlayerInventory(){


        return player.getInventory();
    }
    public Inventory getEntityInventory(){
        return entityInventory;
    }

}
