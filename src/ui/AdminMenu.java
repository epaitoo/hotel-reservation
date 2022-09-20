package ui;


import api.adminResource.AdminResource;
import model.customer.Customer;
import model.room.IRoom;
import model.room.Room;
import model.room.RoomType;

import java.util.*;

public class AdminMenu {

    MainMenu mainMenu;
    AdminResource adminResource;


    public AdminMenu(MainMenu mainMenu) {

        this.mainMenu = mainMenu;
        this.adminResource = AdminResource.getInstance();
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

    private RoomType setRoomType(Scanner input) {
        RoomType roomType;

        System.out.println("Enter room type: 1 for Single Room, 2 for Double Room");
        int roomTypeOption = input.nextInt();

        switch (roomTypeOption) {
            case 1:
                return RoomType.SINGLE;
            case 2:
                return RoomType.DOUBLE;
            default:
                System.out.println("Enter Number 1 or 2");
                roomType = setRoomType(input);
        }
        return roomType;
    }

    private String reAddARoom(Scanner input) {
        System.out.println("Would you like to add another room: y(YES) / n(No)");
        String userInput = input.next().toLowerCase();

        if (userInput.equals("y")) {
            addARoom();
        } else if (userInput.equals("n")) {
            return userInput;
        } else {
            userInput = reAddARoom(input);
        }

        return userInput;
    }


    private void addARoom() {
        List<IRoom> rooms = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Enter room number");
                String roomNumber = input.next();

                System.out.println("Enter price per night");
                double roomPrice = input.nextDouble();

                RoomType roomType = setRoomType(input);

                IRoom room = new Room(roomNumber, roomPrice, roomType);
                rooms.add(room);
                adminResource.addRoom(rooms);

                String userInput = reAddARoom(input);
                if (userInput.equals("n")) {
                    displayAdminMenuItems();
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
                input.nextLine();
            }

        }
    }

    private void seeAllCustomers() {
        Collection<Customer> customers = this.adminResource.getAllCustomers();
        for (Customer customer: customers) {
            System.out.println(customer);
        }

        displayAdminMenuItems();
    }

    private void seeAllRooms() {
        Collection<IRoom> rooms = this.adminResource.getAllRooms();
        for (IRoom room: rooms) {
            System.out.println(room);
        }

        displayAdminMenuItems();
    }

    private void seeAllReservations() {
        this.adminResource.displayAllReservations();
    }

    public void toggleAdminMenu(Scanner input) throws InputMismatchException {
        displayAdminMenuItems();
        boolean condition = true;

        while (condition) {
            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> seeAllCustomers();
                    case 2 -> seeAllRooms();
                    case 3 -> seeAllReservations();
                    case 4 -> addARoom();
                    case 5 -> {
                        condition = false;
                        this.mainMenu.displayMenuItems();
                    }
                    default -> throw new InputMismatchException("Admin Menu: Invalid Input, enter numbers from 1 to 5");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getLocalizedMessage());
                input.nextLine();
            }
        }
    }


}
