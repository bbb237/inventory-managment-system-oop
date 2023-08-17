package finalProject;

import java.util.*;

public class CategoriesMenu implements Fillable{
    private Scanner in;
    private Inventory inventory = Inventory.getInstance();

    public CategoriesMenu(Scanner scan) {
        in = scan;
    }

    public void displayCategories() {
        System.out.print("\nCATEGORIES:\n"
                + "------------------------------------------------------------------------------------------------\n"
                + "ID | Name                         | Quantity of Items            | Notes                        \n"
                + "------------------------------------------------------------------------------------------------\n");

        for (Category i : inventory.getCategories()) {
            System.out.println(i.toString());
        }
        System.out.print(
                "------------------------------------------------------------------------------------------------\n");
    }

    public int displayOptions() {
        int option = -1;
        do {
            try { 
                System.out.print("\nCATEGORY Window:\n===========\n"
                    + "Choose one of the following options:\n"
                    + "(1) Add New Category\n"
                    + "(2) Edit Category\n"
                    + "(3) Delete Category\n"
                    + "(4) View Items List for a Category\n"
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
            return option;
        } while (option != 5);

        return option;
    }
   
    public void displayViewItems() {
        if (inventory.getCategories().isEmpty()) {
            System.out.println("\nThere are no Categories in the System.\n");
        }
        else {
            String name;
            int categoryIndex;
            ArrayList<Item> itemList;

            System.out.print("Choose a Category: ");
            name = in.nextLine();
            if ((categoryIndex = inventory.isExisitingCategory(name)) < 0) {
                name = "";
                System.out.println("A Category with that Name doesn't Exist in the System.\n");
                return;
            }

            System.out.print("\nAll Items in Category [" + name + "]:\n"
                    + "------------------------------------------------------------------------------------------------\n"
                    + "ID | Name                  | Quantity              | Category              | Notes\n"
                    + "------------------------------------------------------------------------------------------------\n");
            itemList = inventory.getCategoryItemList(categoryIndex);
            for (Item i : itemList) {
                System.out.println(i.toString());
            }
            System.out.print(
                    "------------------------------------------------------------------------------------------------\n");
        }
    }

    public void deleteCategory() {
        if (inventory.getCategories().isEmpty()) {
            System.out.println("\nThere are no Categories in the System.\n");
        }
        else {
            String name;
            int categoryIndex;

            System.out.print("Choose a Category to Delete: ");
            name = in.nextLine();
            if ((categoryIndex = inventory.isExisitingCategory(name)) < 0) {
                name = "";
                System.out.println("A Category with that Name doesn't Exist in the System.\n");
                return;
            }
            inventory.deleteCategory(categoryIndex);
            System.out.println("Category was Deleted from the System\n");
        }
    }


    @Override public void add() {
        String name = "";
        String notes = "";

        System.out.print("\nMain Window --> Add new Category Window:(Enter the following information)\n"
                + "=============================================================================\n");

        //Name field
        while (true) {
            System.out.print("Name: ");
            name = in.nextLine();
            if (inventory.isExisitingCategory(name) >= 0) {
                System.out.println("A Category with that Name already Exists.\n");
            }
            else {break;}
        }

        //Notes field
        System.out.print("Notes: ");
        notes = in.nextLine();

        inventory.addNewCategory(name, notes);

        System.out.println("--------------------------------------------------------------------------\n"
                + "New Category Was Added to the System\n");
    }

    @Override
    public void edit() {
        if (inventory.getCategories().isEmpty()) {
            System.out.println("\nThere are no Categories in the System.\n");
        }
        else {
            String name;
            String category = "";
            String notes="";
            int categoryIndex = -1;

            while (categoryIndex < 0) {
                System.out.print("Enter Name of Category you Wish to Edit:  ");
                category = in.nextLine();
                
                if ((categoryIndex = inventory.isExisitingCategory(category)) < 0) {
                    System.out.println("A Category with that Name doesn't Exist in the System.\n");
                }
            };

            //Name field
            System.out.print("\nMain Window --> Edit Category Window:(Press Enter to Skip)\n"
                    + "=============================================================================\n");

            while (true) {
                System.out.print("Name: ");
                name = in.nextLine();
                if (name.equals("")) {
                    name = "";
                    break;
                }
                else if (inventory.isExisitingCategory(name) >= 0) {
                    System.out.println("A Category with that Name already Exists.\n");
                }
                else {
                    break;
                }
            }
            
            //Notes field
            System.out.print("Notes: ");
            notes = in.nextLine();

            inventory.editCategory(name, notes, categoryIndex);

            System.out.println("--------------------------------------------------------------------------\n"
                    + "All Changes to the Category were Saved.\n");
        }
    }    
}