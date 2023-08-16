package finalProject;

import java.io.*;
import java.util.*;

import HW2.Contact;

public class Inventory {
    private static Inventory instance=null;
    private ArrayList<Item> items;
    private ArrayList<Category> categories;

    private Inventory() {
        items = new ArrayList<>();
        categories = new ArrayList<>();
    }

    public static Inventory getInstance(){
        if (instance==null){
            instance = new Inventory();
        }
        return instance;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void clearItems() {
        items.clear();
    }

    public void clearCategories() {
        categories.clear();
    }

    public boolean isExisitingItem(String name) {
        for (Item i : items) {
            if (i.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExisitingCategory(String name) {
        for (Category i : categories) {
            if (i.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }


    public int addNewItem(String name, int quants, String category, String note) {
        if (categories.getItemList().contains(id)) {
            System.out.println("This item is already in this category.");
        }
        else {

        }
    }

    public int addItemToCategory(int id) {
        if (categories.getItemList().contains(id)) {
            System.out.println("This item is already in this category.");
        }
        else {

        }
    }
}