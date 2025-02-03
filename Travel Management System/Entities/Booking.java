package Entities;

public class Booking {
    private String bookingId;
    private String travelerId;
    private String destination;
    private String bookingDate;
    private String travelDate;
    private String returnDate;
    private double totalCost;
    private String bookingStatus;

    public Booking(String bookingId, String travelerId, String destination, String bookingDate, String travelDate, String returnDate, double totalCost, String bookingStatus) {
        this.bookingId = bookingId;
        this.travelerId = travelerId;
        this.destination = destination;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
        this.bookingStatus = bookingStatus;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setTravelerId(String travelerId) {
        this.travelerId = travelerId;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getTravelerId() {
        return travelerId;
    }

    public String getDestination() {
        return destination;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void showBookingInfo() {
        System.out.println("Booking ID: " + bookingId + ", Traveler ID: " + travelerId + ", Destination: " + destination + ", Booking Date: " + bookingDate + ", Travel Date: " + travelDate + ", Return Date: " + returnDate + ", Total Cost: " + totalCost + ", Status: " + bookingStatus);
    }

    public String getBookingAsString() {
        return bookingId + ";" + travelerId + ";" + destination + ";" + bookingDate + ";" + travelDate + ";" + returnDate + ";" + totalCost + ";" + bookingStatus + "\n";
    }
}