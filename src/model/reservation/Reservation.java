package model.reservation;

import model.customer.Customer;
import model.room.IRoom;

import java.util.Date;

public class Reservation {
    Customer customer;
    IRoom room;
    Date checkInDate;
    Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public IRoom getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Reservation made by: " + customer.getFirstName() + " " + customer.getLastName()
                + "for Room Number: " + room.getRoomNumber() + " and type: " + room.getRoomType()
                + " CheckInDate: " + checkInDate + ". CheckoutDate: " + checkOutDate;
    }
}
