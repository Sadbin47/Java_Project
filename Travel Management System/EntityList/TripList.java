package EntityList;

import Entities.Trip;

public class TripList {
    private Trip[] trips;

    public TripList() {
        trips = new Trip[10];
    }

    public TripList(int size) {
        trips = new Trip[size];
    }

    public void insert(Trip trip) {
        for (int i = 0; i < trips.length; i++) {
            if (trips[i] == null) {
                trips[i] = trip;
                System.out.println("Trip added successfully.");
                return;
            }
        }
        System.out.println("Insertion failed. Trip list is full.");
    }

    public Trip getById(String tripId) {
        for (Trip trip : trips) {
            if (trip != null && trip.getTripId().equals(tripId)) {
                return trip;
            }
        }
        System.out.println("No trip found with ID: " + tripId);
        return null;
    }

    public void removeById(String tripId) {
        for (int i = 0; i < trips.length; i++) {
            if (trips[i] != null && trips[i].getTripId().equals(tripId)) {
                trips[i] = null;
                System.out.println("Trip removed successfully.");
                return;
            }
        }
        System.out.println("Removal failed. Trip not found.");
    }

    public String getAllAsString() {
        StringBuilder allTrips = new StringBuilder();
        for (Trip trip : trips) {
            if (trip != null) {
                allTrips.append(trip.getTripAsString());
            }
        }
        return allTrips.toString();
    }

    public Trip[] getAllTrips() {
        return trips;
    }
}