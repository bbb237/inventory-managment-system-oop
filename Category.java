package finalProject;

import java.io.Serializable;
import java.util.*;

public class Category implements Serializable{
    private static int serialNum = 0;
    private String name, notes;
    private int id, quantity;
    ArrayList<Integer> itemIDs;


    public Category() {
        serialNum++;
        name = "";
        quantity = 0;
        notes = "";
        id = serialNum;
        itemIDs = new ArrayList<>();
    }

    public Category(String name1, String notes1, int itemID) {
        serialNum++;
        name = name1;
        quantity++;
        notes = notes1;
        id = serialNum;
        itemIDs = new ArrayList<>();
        itemIDs.add(itemID);
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
                + String.format("| %-19s", getNohp())
                + String.format("| %-19s", getNotes());
    }
}

