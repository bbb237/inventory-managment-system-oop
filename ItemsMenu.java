package finalProject;

import java.util.*;

public class ItemsMenu implements Fillable {
    private Scanner in;
    private Inventory inventory = Inventory.getInstance();

    public ItemsMenu(Scanner scan) {
        in = scan;
    }

    public void displayItems() {
        System.out.print("\nITEMS:\n"
                + "------------------------------------------------------------------------------------------------\n"
                + "ID | Name                  | Quantity              | Category              | Notes                \n"
                + "------------------------------------------------------------------------------------------------\n");

        for (Item i : inventory.getItems()) {
            System.out.println(i.toString());
        }
        System.out.print(
                "------------------------------------------------------------------------------------------------\n");
    }

    public int displayOptions() {
        int option = -1;
        do {
            try { 
                System.out.print("\nITEM Window:\n===========\n"
                    + "Choose one of the following options:\n"
                    + "(1) Add New Item\n"
                    + "(2) Edit Item\n"
                    + "(3) Delete Item\n"
                    + "(4) Search for Item by Name\n"
                    + "(5) BACK TO MAIN MENU\n"
                    + "Enter Your Choice: ");
                    option = Integer.parseInt(in.nextLine());

                if (!(option == 1 || option == 2 || option == 3
                    || option == 4 || option == 5)) {
                    System.out.println("That is not an Option.\n");
                }
                else {return option;}

            } catch (NumberFormatException e) {
                System.out.println("That is not an Option.\n");
                continue;
            }
            
        } while (option != 5);

        return option;
    }
    
    public void displaySearch() {
        String name;

        System.out.print("Item Name: ");
        name = in.nextLine();

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

    public void deleteItem() {
        if (inventory.getItems().isEmpty()) {
            System.out.println("\nThere are no Items in the System.\n");
        }
        else {
            String name;
            int itemIndex;

            System.out.print("Choose an Item to Delete: ");
            name = in.nextLine();
            if ((itemIndex = inventory.isExisitingItem(name)) < 0) {
                name = "";
                System.out.println("An Item with that Name doesn't Exist in the System.\n");
                return;
            }
            inventory.deleteItem(itemIndex);
            System.out.println("Item was Deleted from the System\n");
        }
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

        //Category field
        if (!inventory.getCategories().isEmpty()) {
            System.out.println("\nSelect One of the Following Categories (Default is Blank): ");
            for (Category i : inventory.getCategories()) {
                System.out.println("-> " + i.getName());
            }
            System.out.println();
        }
        System.out.print("Category: ");
        category = in.nextLine();
        if ((categoryIndex = inventory.isExisitingCategory(category)) < 0 || category.isEmpty()) {
            category = "";
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
            System.out.println("\nThere are no Items in the System.\n");
        }
        else {
            String item = null;
            String name;
            String category = "";
            String notes="";
            int quant;
            int itemIndex = -1, categoryIndex;

            while (itemIndex < 0) {
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
                    name = "";
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
                    quant = Integer.parseInt(skip);

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
                System.out.println("\nSelect One of the Following Categories (Default is Blank): ");
                for (Category i : inventory.getCategories()) {
                    System.out.println("-> " + i.getName());
                }
                System.out.println();
            }
            
            System.out.print("Category: ");
            category = in.nextLine();
            if ((categoryIndex = inventory.isExisitingCategory(category)) < 0) {
                category = "";
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
