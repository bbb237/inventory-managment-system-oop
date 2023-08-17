package finalProject;

import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(in);
        mainMenu.displayOptions();
    }

}