package finalProject;

import java.io.Serializable;

public class Item implements Serializable{
    private static int serialNum = 0;
    private String name, email, nohp, notes;
    private int id;

    public Item() {
        serialNum++;
        name = "";
        email = "";
        nohp = "";
        notes = "";
        id = serialNum;
    }

    public Item(String name1, String email1, String nohp1, String notes1) {
        serialNum++;
        name = name1;
        email = email1;
        nohp = nohp1;
        notes = notes1;
        id = serialNum;
    }

    public static int getSerialNum() {
        return serialNum;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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

    public void setEmail(String x) {
        email = x;
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
                + String.format("| %-19s", getEmail())
                + String.format("| %-19s", getNohp())
                + String.format("| %-19s", getNotes());
    }
}

