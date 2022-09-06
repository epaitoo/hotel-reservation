package model.room;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, Double price, RoomType roomType) {
        super(roomNumber, 0.0, roomType);
    }

    @Override
    public String toString() {
        return "Free Room Number: " + getRoomNumber() + " Price: $0. RoomType: " + getRoomType();
    }
}
