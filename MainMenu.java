package finalProject;

import java.util.*;

public class MainMenu {
    private Scanner in;
    private Inventory inventory = Inventory.getInstance();
    private ItemsMenu itemsMenu;
    private CategoriesMenu categoriesMenu;

    public MainMenu() {
        in = new Scanner(System.in);
        itemsMenu = new ItemsMenu();
        categoriesMenu = new CategoriesMenu();
    }

    public void displayOptions() {
        int optionMain = -1;
        int optionItem = -1;
        int optionCategory = -1;
        do {
            try {
                System.out.print("\nMain Window:\n===========\n"
                    + "Choose one of the following options:\n"
                    + "(1) ITEMS\n"
                    + "(2) CATEGORIES\n"
                    + "(3) EXIT\n"
                    + "Enter Your Choice: ");
                optionMain = Integer.parseInt(in.nextLine());

                if (optionMain != 1 || optionMain != 2 || optionMain != 3) {
                    System.out.println("That is not an Option.\n");
                }

            } catch (NumberFormatException e) {
                System.out.println("That is not an Option.\n");
                continue;
            }

            if (optionMain == 1) {
                while (optionItem != 5) {
                    itemsMenu.displayItems();
                    optionItem = itemsMenu.displayOptions();
                    switch(optionItem) {
                        case 1:
                            itemsMenu.add();
                            break;
                        case 2:
                            itemsMenu.edit();
                            break;
                        case 3:
                            itemsMenu.deleteItem();
                            break;
                        case 4:
                            itemsMenu.displayItems();
                            break;
                        case 5:
                            itemsMenu.exit();
                            break;
                    }
                }
            }

            if (optionMain == 2) {
                while (optionCategory != 5) {
                    categoriesMenu.displayCategories();
                    optionCategory = categoriesMenu.displayOptions();
                    switch(optionCategory) {
                        case 1:
                            categoriesMenu.add();
                            break;
                        case 2:
                            categoriesMenu.edit();
                            break;
                        case 3:
                            categoriesMenu.deleteCategory();
                            break;
                        case 4:
                            categoriesMenu.displayViewItems();
                            break;
                        case 5:
                            categoriesMenu.exit();
                            break;
                    }
                }
            }

        } while (optionMain != 3);
        in.close();
        return;
        
    }

}
