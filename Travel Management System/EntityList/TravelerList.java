package EntityList;

import Entities.Traveler;

public class TravelerList {
    private Traveler[] travelers;

    public TravelerList() {
        travelers = new Traveler[10];
    }

    public TravelerList(int size) {
        travelers = new Traveler[size];
    }

    public void insert(Traveler t) {
        for (int i = 0; i < travelers.length; i++) {
            if (travelers[i] == null) {
                travelers[i] = t;
                System.out.println("Traveler inserted successfully.");
                return;
            }
        }
        System.out.println("Traveler list is full.");
    }
    
    public Traveler getById(String id) {
        for (Traveler t : travelers) {
            if (t != null && t.getTravelerId().equals(id)) {
                return t;
            }
        }
        System.out.println("No traveler found with ID: " + id);
        return null;
    }
    
    public void removeById(String id) {
        for (int i = 0; i < travelers.length; i++) {
            if (travelers[i] != null && travelers[i].getTravelerId().equals(id)) {
                travelers[i] = null;
                System.out.println("Traveler removed successfully.");
                return;
            }
        }
        System.out.println("Removal failed. Traveler not found.");
    }
    
    public String getAllAsString() {
        StringBuilder allTravelers = new StringBuilder();
        for (Traveler t : travelers) {
            if (t != null) {
                allTravelers.append(t.getTravelerAsString()).append("\n");
            }
        }
        return allTravelers.toString();
    }
    
    public Traveler[] getAllTravelers() {
        return travelers;
    }
}