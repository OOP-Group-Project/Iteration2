package Main.Model.State;

import Main.Model.Entity.Avatar;
import Main.Model.Entity.Entity;

import java.awt.*;

/**
 * Created by Peter Camejo on 3/14/2016.
 */
public class TradeState extends State{
    private int ITEM_PER_ROW = 20;
    private int ITEM_PER_COLOUMN = 10;

    private Avatar player;
    private Entity shopkeeper;
    private Point ItemSelected;

    public TradeState(Avatar player, Entity shopkeeper){
        this.player = player;
        this.shopkeeper = shopkeeper;
    }

    public Point getSelected(){
        return ItemSelected;
    }

    public void moveSelect(Point p) {

        ItemSelected.translate(p.x, p.y);

        if (ItemSelected.x < 0) {
            ItemSelected.x = ITEM_PER_ROW - 1;
        }
        if (ItemSelected.x >= ITEM_PER_ROW) {
            ItemSelected.x = 0;
        }

        if (ItemSelected.y < 0) {
            ItemSelected.y = ITEM_PER_COLOUMN - 1;
        }
        if (ItemSelected.y >= ITEM_PER_COLOUMN) {
            ItemSelected.y = 0;
        }
    }


    public Avatar getPlayer(){return this.player;}
    public Entity getShopkeeper(){return this.shopkeeper;}
    public void setShopkeeper(Entity shopkeeper){
        this.shopkeeper = shopkeeper;
    }

    public void init(){
        ItemSelected = new Point(0,0);
    }
}



