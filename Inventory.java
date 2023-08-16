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

    public int isExisitingItem(String name) {
        for (Item i : items) {
            if (i.getName().equalsIgnoreCase(name)) {
                return items.indexOf(i);
            }
        }
        return -1;
    }

    public int isExisitingCategory(String name) {
        for (Category i : categories) {
            if (i.getName().equalsIgnoreCase(name)) {
                return categories.indexOf(i);
            }
        }
        return -1;
    }

    public int addNewItem(String name, int quants, String category, String note, int categoryIndex) {
        Item item = new Item(name, quants, category, note);
        items.add(item);
        if (!category.isEmpty()) {
            categories.get(categoryIndex).addItem(item.getId());
        }
        return 0;
    }

    public int editItem(String name, int quants, String category, String note, int itemIndex, int categoryIndex) {
        Item selectedItem = items.get(itemIndex);
        if (!name.isEmpty()) {
            selectedItem.setName(name);
        }

        if (quants >= 0) {
            selectedItem.setQuantity(quants);
        }

        if (!category.isEmpty()) {
            selectedItem.setCategory(category);
            categories.get(categoryIndex).addItem(selectedItem.getId());
        }

        if (!note.isEmpty()) {
            selectedItem.setNotes(note);
        }
        return 0;
    }
}