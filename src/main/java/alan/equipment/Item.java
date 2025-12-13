package alan.equipment;

import alan.Constants;

public abstract class Item {
    private Constants.ITEM_TYPE itemType;
    private String name;
    private double cost;

    public Item() {

    }

    public Constants.ITEM_TYPE getItemType() {
        return itemType;
    }

    public void setItemType(Constants.ITEM_TYPE itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    
    
    

}
