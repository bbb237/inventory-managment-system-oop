package finalProject;

import java.io.Serializable;

public class Item implements Serializable{
    private static int idNum = 0;
    private String name, notes, category;
    private int id, quantity;

    public Item() {
        idNum++;
        name = "";
        quantity = 0;
        notes = "";
        id = idNum;
        category = "";
    }

    public Item(String name1, int quant, String categ, String notes1) {
        idNum++;
        name = name1;
        quantity = quant;
        notes = notes1;
        id = idNum;
        category = categ;
        
    }

    public static int getidNum() {
        return idNum;
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

    public static void setidNum(int x) {
        idNum = x;
    }

    public static void resetidNum() {
        idNum = 0;
    }

    public String toString() {
        return String.format("%-3d", getId())
                + String.format("| %-23s", getName())
                + String.format("| %-23d", getQuantity())
                + String.format("| %-23s", getCategory())
                + String.format("| %-23s", getNotes());
    }
}

