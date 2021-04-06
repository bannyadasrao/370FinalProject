package edu.qc.seclass.glm;

public class ItemsModal {

    Integer id;
    String itemName;
    String amountOfQuantity;

    public ItemsModal(Integer id, String itemName, String amountOfQuantity) {
        this.id = id;
        this.itemName = itemName;
        this.amountOfQuantity = amountOfQuantity;
    }

    public ItemsModal(String itemName, String amountOfQuantity) {
        this.itemName = itemName;
        this.amountOfQuantity = amountOfQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAmountOfQuantity() {
        return amountOfQuantity;
    }

    public void setAmountOfQuantity(String amountOfQuantity) {
        this.amountOfQuantity = amountOfQuantity;
    }

}
