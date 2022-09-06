package api.hotelResource;

import model.customer.Customer;
import model.reservation.Reservation;
import model.room.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private static HotelResource instance = null;
    private CustomerService customerService;
    private ReservationService reservationService;

    private HotelResource() {
        this.customerService = CustomerService.getInstance();
        this.reservationService = ReservationService.getInstance();
    }

    public static HotelResource getInstance() {
        if (instance == null) {
            instance = new HotelResource();
        }
        return instance;
    }

    public Customer getCustomer(String email) {
        return this.customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        this.customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return this.reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = this.getCustomer(customerEmail);
        return this.reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        Customer customer = this.getCustomer(customerEmail);
        return this.reservationService.getCustomersReservation(customer);
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return this.reservationService.findRooms(checkIn, checkOut);
    }


}
