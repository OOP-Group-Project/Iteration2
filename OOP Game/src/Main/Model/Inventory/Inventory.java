package Main.Model.Inventory;

import Main.Model.Items.TakeAble;

/**
 * Created by walkhard on 2/18/16.
 */
public class Inventory {
	

    private final int MAX_INVENTORY = 30;
    private ItemNode[] items;

    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= this.getSize();
    }

    public Inventory() {
        items = new ItemNode[MAX_INVENTORY];

        for (int i = 0; i < MAX_INVENTORY; i++) {
            items[i] = null;
        }
    }

    public int getSize() {
        return MAX_INVENTORY;
    }


    public boolean isThereAnItemAt(int index) {
        if (isOutOfBounds(index)) return false;
        return (items[index] != null);
    }

    public TakeAble getItemAt(int index) {
        if (!isThereAnItemAt(index))
            return null;
        return items[index].item;
    }

    public int getItemAmountAt(int index) {
        if (!isThereAnItemAt(index))
            return 0;
        return items[index].amount;
    }


    //return true if you can put the item in the Inventory
    public boolean addItem(TakeAble newItem) {
        int nextEmptySpace = MAX_INVENTORY;

        for (int i = 0; i < MAX_INVENTORY; i++) {
            
        	//set the next empty space
        	if (items[i] == null) { 
        		items[nextEmptySpace] = new ItemNode(newItem, 1);
        		return true;
            }

            //increment items if u have it
            if (items[i].item.equals(newItem)) {
                items[i].amount += 1;
                return true;
            }
        }
        return false;
    }


    //return true if you can remove item
    public boolean removeItemAt(int index, int amount) {
        if (!isThereAnItemAt(index))
            return false;

        if (items[index].amount > amount) {
            items[index].amount -= amount;
        } else {
            items[index] = null;
        }
        return true;
    }
       
    
    public boolean removeItemAt(int index) {
        return removeItemAt(index, 1);
    }

    public boolean removeAllItemsAt(int index) {
        return removeItemAt(index, Integer.MAX_VALUE);
    }
    
    public boolean moveItem(int from, int to){
    	
    	if(this.isThereAnItemAt(from)){
    		
    		if(isOutOfBounds(to))
    			return false;
    		
    		if(isThereAnItemAt(to)){
    			
    			ItemNode temp = items[to];
    			items[to] = items[from];
    			items[from] = temp;
    		}
    		else {
    			items[to] = items[from];
    			items[from] = null;
    		}
    	}
    	return false;
    }
/*
    public boolean removeItem(TakeAble newItem) {
    	
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (items[i].item.equals(newItem))
                    return removeItemAt(i);
            }
        }
        return false;
    }

    public ItemNode getItem(TakeAble findItem) {
        
    	//iterating through inventory items
        for (ItemNode item : items) {
            if (item != null && item.item.getID() == findItem.getID()) {
                return item;
            }
        }
        return null;
    }


    public ItemNode getItemNode(TakeAble findItem) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].item.equals(findItem))
                return items[i];
        }
        return null;
    }

    public int getItemCount(TakeAble findItem) {

        ItemNode item = getItem(findItem);
        int count = 0;

        if (item != null) {

            count = item.amount;

        }

        return count;
    }
/*----------------------------
    public boolean loadItem(TakeAble newItem, int count, int index) {
        if (index == MAX_INVENTORY) {
            return false;
        } else {
            items[index] = new ItemNode(newItem, count);
        }
        return true;
    }
    
    public int getCurrentSize() {
        int count = 0;
        for (ItemNode item : items) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }
  */
    
    public class ItemNode {
        public TakeAble item;
        public int amount;

        public ItemNode(TakeAble item, int amount) {
            setVariables(item, amount);
        }

        public void setVariables(TakeAble item, int amount) {
            this.item = item;
            this.amount = amount;
        }

        public int getCount() {
            return amount;
        }

    }
}
