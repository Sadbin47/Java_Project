package Entities;

public class Trip {
    private String tripId;
    private String destination;
    private String status;
    private int cost;

    // Existing constructor
    public Trip(String tripId, String destination, String status, int cost) {
        this.tripId = tripId;
        this.destination = destination;
        this.status = status;
        this.cost = cost;
    }

    // Add the constructor with the required parameters
    public Trip(String tripId, String destination, String status, String param4, String param5, String param6, int cost) {
        this.tripId = tripId;
        this.destination = destination;
        this.status = status;
        // Handle the additional parameters as needed
        this.cost = cost;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTripAsString() {
        return "Trip ID: " + tripId + "\nDestination: " + destination + "\nStatus: " + status + "\nCost: " + cost + "\n";
    }
}