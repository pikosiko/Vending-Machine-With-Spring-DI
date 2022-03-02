package dto;

import java.util.Objects;

public class Item {
    private String itemName;
    private String itemPrice;
    private String itemInventory;

    public Item(String itemName, String itemPrice, String itemInventory) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemInventory = itemInventory;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice='" + itemPrice + '\'' +
                ", itemInventory='" + itemInventory + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemName, item.itemName) && Objects.equals(itemPrice, item.itemPrice) && Objects.equals(itemInventory, item.itemInventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemPrice, itemInventory);
    }

    public String getItemName() {
        return itemName;
    }

    /*public void setItemName(String itemName) {
        this.itemName = itemName;
    }*/

    public String getItemPrice() {
        return itemPrice;
    }

    /*public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }*/

    public String getItemInventory() {
        return itemInventory;
    }

    public void setItemInventory(String itemInventory) {
        this.itemInventory = itemInventory;
    }
}
