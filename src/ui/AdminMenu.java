package ui;


import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenu {

    private MainMenu mainMenu;

    public AdminMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void displayAdminMenuItems() {
        System.out.println("Admin Menu");
        System.out.println("===================================================");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
        System.out.println("Please select a number for the menu option");
    }

    private void toggleMainMenu() {
        mainMenu.displayMenuItems();
    }

    public void toggleAdminMenu(Scanner input) throws InputMismatchException {
        displayAdminMenuItems();
        boolean condition = true;
        while (condition) {
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> System.out.println("Admin Menu - showing all customers");
                    case 2 -> System.out.println("Admin Menu - 2. See all Rooms");
                    case 3 -> System.out.println("Admin Menu - 3. See all Reservations");
                    case 4 -> System.out.println("Admin Menu - Add a Room");
                    case 5 -> {
                        condition = false;
                        toggleMainMenu();
                    }
                    default -> {
                        throw new InputMismatchException("Admin Menu: Invalid Input, enter numbers from 1 to 5");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getLocalizedMessage());
                input.nextLine();
            }
        }
    }


}
