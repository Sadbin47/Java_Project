package Entities;

public class Traveler extends Person {
    private String contactNumber;
    private String gender;
    private String nationality;
    private String emergencyContact;

    public Traveler(String id, String name, String email, String contactNumber, String gender, String nationality, String emergencyContact) {
        super(id, name, email);
        setContactNumber(contactNumber);
        setGender(gender);
        setNationality(nationality);
        setEmergencyContact(emergencyContact);
    }

    public Traveler() {
    }

    public void setTravelerName(String name) {
        setName(name);
    }

    public void setEmailAddress(String email) {
        setEmail(email);
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getTravelerId() {
        return getId();
    }

    public String getTravelerName() {
        return getName();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void showTravelerInfo() {
        displayInfo();
    }

    @Override
    public void displayInfo() {
        System.out.println("Traveler ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Gender: " + gender);
        System.out.println("Nationality: " + nationality);
        System.out.println("Emergency Contact: " + emergencyContact);
    }

    public String getTravelerAsString() {
        return "Traveler ID: " + getId() + "\n" +
               "Traveler Name: " + getName() + "\n" +
               "Contact Number: " + contactNumber + "\n" +
               "Email Address: " + getEmail() + "\n" +
               "Gender: " + gender + "\n" +
               "Nationality: " + nationality + "\n" +
               "Emergency Contact: " + emergencyContact + "\n";
    }
    public String getTravelerAsFormattedString() {
        return getId() + ";" +
               getName() + ";" +
               getContactNumber() + ";" +
               getEmail() + ";" +
               getGender() + ";" +
               getNationality() + ";" +
               getEmergencyContact() + ";";
    }
}