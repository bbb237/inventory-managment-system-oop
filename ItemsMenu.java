package finalProject;

import java.util.*;

public class ItemsMenu implements Fillable {
    private Scanner in;
    private Inventory inventory = Inventory.getInstance();

    public ItemsMenu() {
        in = new Scanner(System.in);
    }

    public void displayItems() {
        System.out.print(
                  "------------------------------------------------------------------------------------------------\n"
                + "ID | Name                  | Quantity              | Category              | Notes\n"
                + "------------------------------------------------------------------------------------------------\n");

        for (Item i : inventory.getItems()) {
            System.out.println(i.toString());
        }
        System.out.print(
                "------------------------------------------------------------------------------------------------\n");
    }

    public void displaySearch(String name) {
        System.out.print("\nSearch Results for Items with Name [" + name + "]:\n"
                + "------------------------------------------------------------------------------------------------\n"
                + "ID | Name                  | Quantity              | Category              | Notes\n"
                + "------------------------------------------------------------------------------------------------\n");

        for (Item i : inventory.getItems()) {
            if (i.getName().contains(name)) {
                System.out.println(i.toString());
            }
        }
        System.out.print(
                "------------------------------------------------------------------------------------------------\n");
    }

    public void displayOptions() {
        String option = "";
        do {
            System.out.print("\nMain Window:\n===========\n"
                    + "Choose one of the following options:\n"
                    + "(1) Add New Item \n"
                    + "(2) Edit Item\n"
                    + "(3) Delete Item\n"
                    + "(4) Search for Item by Name\n"
                    + "(5) BACK TO MAIN MENU\n"
                    + "Enter Your Choice: ");
            option = in.nextLine();

        } while (!(option.equals("1")
                || option.equals("2")
                || option.equals("3")));

    }
    public void exit(){
        in.close();
    }

    public void deleteItem() {

    }

    @Override public void add() {
        // Item item = new Item();
        int quant = -1;
        String category="";
        String name = "";
        String notes = "";
        int categoryIndex;

        System.out.print("\nMain Window --> Add new Item Window:(Enter the following information)\n"
                + "=============================================================================\n");

        //Name field
        while (true) {
            System.out.print("Name: ");
            name = in.nextLine();
            if (inventory.isExisitingItem(name) >= 0) {
                System.out.println("An Item with that Name already Exists.\n");
            }
            else {break;}
        }
        // item.setName(name);

        //Quantity field
        do {
            try {
                System.out.print("Quantity: ");
                quant = Integer.parseInt(in.nextLine());
                
                if (quant < 0) {
                    System.out.println("Quantity cannot be less than 0.\n");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.\n");
                continue;
            }
        } while (quant < 0);
        // item.setQuantity(quant);

        //Category field
        if (!inventory.getCategories().isEmpty()) {
            System.out.println("Select One of the Following Categories (Default is Blank): ");
            for (Category i : inventory.getCategories()) {
                System.out.println("-> " + i.getName());
            }
            System.out.println();
        }
        System.out.print("Category: ");
        if ((categoryIndex = inventory.isExisitingCategory(category)) < 0 || category.isEmpty()) {
            // item.setCategory("");
            category = "";
        }
        else {
            // item.setCategory(category);
            category = in.nextLine();
        }

        //Notes field
        System.out.print("Notes: ");
        notes = in.nextLine();
        // item.setNotes(notes);

        inventory.addNewItem(name, quant, category, notes, categoryIndex);

        System.out.println("--------------------------------------------------------------------------\n"
                + "New Item Was Added to the System\n");
    }

    @Override
    public void edit() {
        if (inventory.getItems().isEmpty()) {
            System.out.println("There are no Items in the System.\n");
        }
        else {
            String item = null;
            String name = null;
            String category = "";
            String notes="";
            int quant;
            int itemIndex = 0, categoryIndex;

            while (itemIndex >= 0) {
                System.out.print("Enter Name of Item you Wish to Edit:  ");
                item = in.nextLine();
                
                if ((itemIndex = inventory.isExisitingItem(item)) < 0) {
                    System.out.println("An Item with that Name doesn't Exist in the System.\n");
                }
            }

            //Name field
            System.out.print("\nMain Window --> Edit Item Window:(Press Enter to Skip)\n"
                    + "=============================================================================\n");

            while (true) {
                System.out.print("Name: ");
                name = in.nextLine();
                if (name.equals("")) {
                    break;
                }
                else if (inventory.isExisitingItem(name) >= 0) {
                    System.out.println("An Item with that Name already Exists.\n");
                }
                else {
                    break;
                }
            }
            
            //Quantity field
            while (true) {
                try {
                    System.out.print("Quantity: ");
                    String skip = in.nextLine();
                    
                    if (skip.isEmpty()) {
                        quant = -1;
                        break;
                    }
                    quant = Integer.parseInt(in.nextLine());

                    if (quant < 0) {
                        System.out.println("Quantity cannot be less than 0.\n");
                    }
                    else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a whole number.\n");
                    continue;
                }
            }

            //Category field
            if (!inventory.getCategories().isEmpty()) {
                System.out.println("Select One of the Following Categories (Default is Blank): ");
                for (Category i : inventory.getCategories()) {
                    System.out.println("-> " + i.getName());
                }
                System.out.println();
            }
            
            System.out.print("Category: ");
            if ((categoryIndex = inventory.isExisitingCategory(category)) < 0) {
                category = "";
            }
            else {
                category = in.nextLine();
            }
            
            //Notes field
            System.out.print("Notes: ");
            notes = in.nextLine();

            inventory.editItem(name, quant, category, notes, itemIndex, categoryIndex);

            System.out.println("--------------------------------------------------------------------------\n"
                    + "All Changes to the Item were Saved.\n");
        }
    }    
}
