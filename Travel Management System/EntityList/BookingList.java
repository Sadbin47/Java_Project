package EntityList;
import Entities.Booking;

public class BookingList {
    private Booking[] bookings;

    public BookingList() {
        bookings = new Booking[10];
    }

    public BookingList(int size) {
        bookings = new Booking[size];
    }

    public void insert(Booking b) {
        boolean flag = false;
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] == null) {
                bookings[i] = b;
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("Booking successfully added.");
        } else {
            System.out.println("Insertion failed. List is full.");
        }
    }

    public Booking getById(String id) {
        boolean flag = false;
        Booking b = null;

        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] != null) {
                if (bookings[i].getBookingId().equals(id)) {
                    b = bookings[i];
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("Booking found.");
        } else {
            System.out.println("No booking found with this ID.");
        }

        return b;
    }

    public void removeById(String id) {
        boolean flag = false;
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] != null) {
                if (bookings[i].getBookingId().equals(id)) {
                    bookings[i] = null;
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println("Booking removed successfully.");
        } else {
            System.out.println("Remove failed. Booking not found.");
        }
    }

    public void showAll() {
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] != null) {
                bookings[i].showBookingInfo();
            }
        }
    }
    
    public String getAllAsString() {
        String allBookings = "";
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] != null) {
                allBookings += bookings[i].getBookingAsString();
            }
        }
        return allBookings;
    }

    public Booking[] getAllBookings() {
        return bookings;
    }
}

