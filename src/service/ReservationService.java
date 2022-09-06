package service;

import model.customer.Customer;
import model.reservation.Reservation;
import model.room.IRoom;
import model.room.Room;

import java.util.*;

public class ReservationService {
    private static ReservationService instance = null;

    Map<String, Room> rooms = new HashMap<>();
    ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    private ReservationService() {}

    public void addRoom(IRoom room) throws Exception {
        if (roomNumberExists(room.getRoomNumber())) {
            throw new Exception("Room Number Already Exist");
        }
        Room newRoom = new Room(room.getRoomNumber(), room.getRoomPrice(), room.getRoomType());
        rooms.put(newRoom.getRoomNumber(), newRoom);
        System.out.println("New Room added");
    }

    public IRoom getARoom(String roomId) {
        return rooms.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(newReservation);
        return newReservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        ArrayList<IRoom> iRooms = new ArrayList<IRoom>();
        for (Reservation reservation: reservations) {
            if (reservation.getCheckInDate().compareTo(checkInDate) == 1
            && reservation.getCheckOutDate().compareTo(checkOutDate) == 1) {
                iRooms.add(reservation.getRoom());
            }
        }
        return iRooms;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        ArrayList<Reservation> customerReservation = new ArrayList<Reservation>();
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().equals(customer)) {
                customerReservation.add(reservation);
            }
        }
        return customerReservation;
    }

    public void printAllReservation() {
        for (Reservation reservation: reservations) {
            System.out.println(reservation);
        }
    }

    private boolean roomNumberExists( String roomId) {
        return rooms.containsKey(roomId);
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

}
