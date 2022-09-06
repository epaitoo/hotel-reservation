package api.adminResource;

import model.customer.Customer;
import model.room.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static AdminResource instance = null;
    private CustomerService customerService;
    private ReservationService reservationService;

    private AdminResource() {
        this.customerService = CustomerService.getInstance();
        this.reservationService = ReservationService.getInstance();
    }

    private static AdminResource getInstance() {
        if (instance == null) {
            instance = new AdminResource();
        }
        return instance;
    }

    public Customer getCustomer(String email) {
        return this.customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms) {
        for (IRoom room: rooms) {
            this.reservationService.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return this.reservationService.getRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    public void displayAllReservations() {
        this.reservationService.printAllReservation();
    }
}
