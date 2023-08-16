package finalProject;

import java.io.Serializable;

public class Item implements Serializable{
    private static int itemNum = 0;
    private String name, notes, category;
    private int id, quantity;

    public Item() {
        itemNum++;
        name = "";
        quantity = 0;
        notes = "";
        id = itemNum;
        category = "";
    }

    public Item(String name1, int quant, String categ, String notes1) {
        itemNum++;
        name = name1;
        quantity = quant;
        notes = notes1;
        id = itemNum;
        category = categ;
        
    }

    public static int getItemNum() {
        return itemNum;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getNotes() {
        return notes;
    }

    public int getId() {
        return id;
    }

    public void setName(String x) {
        name = x;
    }

    public boolean setQuantity(int x) {
        if (x < 0) 
            return false;

        quantity = x;
        return true;
    }

    public void setCategory(String x) { //needs external validation
        category = x;
    }

    public void setNotes(String x) {
        notes = x;
    }

    public boolean setId(int x) {
        if (x < 0) 
            return false;

        id = x;
        return true;
    }

    public static void setItemNum(int x) {
        itemNum = x;
    }

    public static void resetItemNum() {
        itemNum = 0;
    }

    public String toString() {
        return String.format("%-3d", getId())
                + String.format("| %-23s", getName())
                + String.format("| %-23d", getQuantity())
                + String.format("| %-23s", getCategory())
                + String.format("| %-23s", getNotes());
    }
}

