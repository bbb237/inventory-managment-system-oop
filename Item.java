package finalProject;

import java.io.Serializable;

public class Item implements Serializable{
    private static int itemNum = 0;
    private String name, nohp, notes;
    private int id, quantity;
    private Category category;

    public Item() {
        itemNum++;
        name = "";
        quantity = 0;
        notes = "";
        id = itemNum;
        category = null;
    }

    public Item(String name1, int quant, String notes1, String categ) {
        itemNum++;
        name = name1;
        quantity = quant;
        notes = notes1;
        id = itemNum;
        if (categ.isEmpty()) {
            category = null;
        }
        else {
            category = new Category(categ, "", this.id);
        }
        
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

    public String getNohp() {
        return nohp;
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

    public void setQuantity(int x) {
        quantity = x;
    }

    public void setNohp(String x) {
        nohp = x;
    }

    public void setNotes(String x) {
        notes = x;
    }

    public void setId(int x) {
        id = x;
    }

    public static void setItemNum(int x) {
        itemNum = x;
    }

    public static void resetItemNum() {
        itemNum = 0;
    }

    public String toString() {
        return String.format("%-3d", getId())
                + String.format("| %-19s", getName())
                + String.format("| %-19d", getQuantity())
                + String.format("| %-19s", getNohp())
                + String.format("| %-19s", getNotes());
    }
}

