package finalProject;

import java.io.Serializable;
import java.util.*;

public class Category implements Serializable{
    private static int serialNum = 0;
    private String name, notes;
    private int id, quantity;
    ArrayList<Integer> itemList;


    public Category() {
        serialNum++;
        name = "";
        quantity = 0;
        notes = "";
        id = serialNum;
        itemList = new ArrayList<>();
    }

    public Category(String name1, String notes1, int itemID) {
        serialNum++;
        name = name1;
        quantity++;
        notes = notes1;
        id = serialNum;
        itemList = new ArrayList<>();
        itemList.add(itemID);
    }

    public Category(String name1, String notes1) {
        serialNum++;
        name = name1;
        quantity++;
        notes = notes1;
        id = serialNum;
        itemList = new ArrayList<>();
    }

    public static int getSerialNum() {
        return serialNum;
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
    
    public ArrayList<Integer> getItemList() {
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

    public void setItemList(ArrayList<Integer> x) {
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

    public static void setSerialNum(int x) {
        serialNum = x;
    }

    public static void resetSerialNum() {
        serialNum = 0;
    }

    public String toString() {
        return String.format("%-3d", getId())
                + String.format("| %-19s", getName())
                + String.format("| %-19d", getQuantity())
                // + String.format("| %-19s", getNohp())
                + String.format("| %-19s", getNotes());
    }

    public boolean addItem(int x) {
        if (itemList.contains(x)) {
            System.out.println("This item is already in this category.");
            return false;
        }
        itemList.add(x);
        return true;
    }
}

