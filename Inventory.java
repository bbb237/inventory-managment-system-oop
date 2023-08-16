package finalProject;

import java.io.*;
import java.util.*;


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

    public ArrayList<Item> getCategoryItemList(int index) {
        return categories.get(index).getItemList();
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
            categories.get(categoryIndex).addItem(item);
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
            categories.get(categoryIndex).addItem(selectedItem);
        }

        if (!note.isEmpty()) {
            selectedItem.setNotes(note);
        }
        return 0;
    }

    public void deleteItem(int itemIndex) {
        Item selectedItem = items.get(itemIndex);
        
        for (Category i : categories) {
            if (i.getName().equalsIgnoreCase(selectedItem.getName())) {
                i.deleteItem(selectedItem);
            }
        }
        items.remove(selectedItem);
    }

    public int addNewCategory(String name, String note) {
        Category category = new Category(name, note);
        categories.add(category);
        return 0;
    }

    public int editCategory(String name, String note, int categoryIndex) {
        Category selectedCategory = categories.get(categoryIndex);
        if (!name.isEmpty()) {
            selectedCategory.setName(name);

            for (Item i : selectedCategory.getItemList()) {
                i.setCategory(name);
            }
        }

        if (!note.isEmpty()) {
            selectedCategory.setNotes(note);
        }
        return 0;
    }

    public void deleteCategory(int categoryIndex) {
        Category selectedCategory = categories.get(categoryIndex);
        
        for (Item i : items) {
            if (i.getCategory().equalsIgnoreCase(selectedCategory.getName())) {
                i.setCategory("");
            }
        }
        categories.remove(selectedCategory);
    }
}