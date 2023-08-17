package finalProject;

import java.util.*;

public class MainMenu {
    private Scanner in;
    private ItemsMenu itemsMenu;
    private CategoriesMenu categoriesMenu;

    public MainMenu(Scanner scan) {
        in = scan;
        itemsMenu = new ItemsMenu(in);
        categoriesMenu = new CategoriesMenu(in);
    }

    public void displayOptions() {
        int optionMain = -1;
        int optionItem = -1;
        int optionCategory = -1;
        boolean jump = false;
        do {
            try {
                jump = false;
                System.out.print("\nMain Window:\n===========\n"
                    + "Choose one of the following options:\n"
                    + "(1) ITEMS\n"
                    + "(2) CATEGORIES\n"
                    + "(3) EXIT\n"
                    + "Enter Your Choice: ");
                optionMain = Integer.parseInt(in.nextLine());

                if (!(optionMain == 1 || optionMain == 2 || optionMain == 3)) {
                    System.out.println("That is not an Option.\n");
                }

            } catch (NumberFormatException e) {
                System.out.println("That is not an Option.\n");
                continue;
            }
            catch (NoSuchElementException e) {
                System.out.println("Test.\n");
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
                            itemsMenu.displaySearch();
                            break;
                        case 5:
                            jump = true;
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
                            jump = true;
                            break;
                    }
                }
            }
            if (jump) {
                optionCategory = -1;
                optionItem = -1;
                continue;
            }
        } while (optionMain != 3);
        in.close();
        return;
    }

}
