package alan.equipment;

import alan.Constants;

public abstract class Item {
    private Constants.ITEM_TYPE itemType;
    private String name;

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

    
    

}
