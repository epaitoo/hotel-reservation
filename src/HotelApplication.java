import ui.AdminMenu;
import ui.MainMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelApplication {

    static MainMenu mainMenu = new MainMenu();
    static AdminMenu adminMenu = new AdminMenu(mainMenu);


    public static void main(String[] args) {

        mainMenu.displayMenuItems();
        Scanner input = new Scanner(System.in);

        try {
            toggleMainMenu(input);
        } catch (InputMismatchException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void toggleMainMenu(Scanner input) throws InputMismatchException {
        boolean condition = true;
        while (condition) {
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> System.out.println("On Main Menu - Find and reserve a room");
                    case 2 -> System.out.println("On Main Menu - See my reservations");
                    case 3 -> System.out.println("On Main Menu - Create an account");
                    case 4 -> {
                        // switch to AdminMenu
                        adminMenu.toggleAdminMenu(input);
                    }
                    case 5 -> condition = false;
                    default ->  throw new InputMismatchException("Please type a number from 1 to 5");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getLocalizedMessage());
                input.nextLine();
            }
        }
    }

}
