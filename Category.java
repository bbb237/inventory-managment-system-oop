package finalProject;

import java.io.Serializable;
import java.util.*;

public class Category implements Serializable{
    private static int idNum = 0;
    private String name, notes;
    private int id, quantity;
    ArrayList<Item> itemList;


    public Category() {
        idNum++;
        name = "";
        quantity = 0;
        notes = "";
        id = idNum;
        itemList = new ArrayList<>();
    }

    public Category(String name1, String notes1) {
        idNum++;
        name = name1;
        quantity = 0;
        notes = notes1;
        id = idNum;
        itemList = new ArrayList<Item>();
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

    public String getNotes() {
        return notes;
    }

    public int getId() {
        return id;
    }
    
    public ArrayList<Item> getItemList() {
        return itemList;
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

    public void setItemList(ArrayList<Item> x) {
        itemList = x;
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
                + String.format("| %-29s", getName())
                + String.format("| %-29d", getQuantity())
                + String.format("| %-29s", getNotes());
    }

    public void addItem(Item x) {
        itemList.add(x);
        quantity = itemList.size();
    }

    public void deleteItem(Item x) {
        itemList.remove(x);
        quantity = itemList.size();
    }
}

