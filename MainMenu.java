package finalProject;

import java.util.*;

public class MainMenu {
    private Scanner in;
    private Inventory inventory = Inventory.getInstance();

    public MainMenu() {
        in = new Scanner(System.in);
    }

    public void displayOptions() {
        String option = "";
        do {
            System.out.print("\nMain Window:\n===========\n"
                + "Choose one of the following options:\n"
                + "(1) ITEMS\n"
                + "(2) CATEGORIES\n"
                + "(3) EXIT\n"
                + "Enter Your Choice: ");
            option = in.nextLine();

        } while (!(option.equals("1") 
                || option.equals("2") 
                || option.equals("3")));
                
    }

    public void exit() {
        in.close();
    }

}
