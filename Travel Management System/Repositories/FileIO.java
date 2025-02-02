package Repositories;

import java.io.*;
import java.util.Scanner;
import Entities.Traveler;
import EntityList.TravelerList;
import Entities.Trip;
import EntityList.TripList;
import Entities.Booking;
import Entities.Employee;
import EntityList.BookingList;
import EntityList.EmployeeList;

public class FileIO {

    public static boolean checkUser(String username, String password) {
        boolean flag = false;
        try {
            File file = new File("Repositories/Text File/SignUp.txt");
            Scanner fileSc = new Scanner(file);
            while (fileSc.hasNextLine()) {
                String line = fileSc.nextLine();
                String[] user = line.split(",");
                if (username.equals(user[0]) && password.equals(user[1])) {
                    flag = true;
                    break;
                }
            }
            fileSc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Read File");
        }
        return flag;
    }

    public static boolean addUser(String username, String password) {
        boolean flag = false;
        try {
            File file = new File("Repositories/Text File/SignUp.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(username + "," + password + "\n");
            writer.flush();
            writer.close();
            flag = true;
        } catch (Exception e) {
            System.out.println("Cannot Write to File");
        }
        return flag;
    }

    //----------------------------------------------------------------------------------------------------

    public static void loadTravelersFromFile(TravelerList travelerList) {
        try {
            File file = new File("Repositories/Text File/travelers.txt");
            Scanner fileSc = new Scanner(file);
    
            while (fileSc.hasNextLine()) {
                String line = fileSc.nextLine();
                String[] data = line.split(";");
    
                // Check if the data array has the expected length
                if (data.length == 7) {
                    Traveler t = new Traveler(
                        data[0], data[1], data[3], data[2], data[4], data[5], data[6]
                    );
                    travelerList.insert(t);
                } else {
                    System.out.println("Invalid data format: " + line);
                }
            }
    
            fileSc.close();
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for detailed error information
            System.out.println("Cannot Read File");
        }
    }

    public static void saveTravelerToFile(Traveler traveler) {
        try {
            File file = new File("Repositories/Text File/travelers.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(traveler.getTravelerAsFormattedString() + "\n");
            writer.flush();
            writer.close();
            System.out.println("Traveler saved successfully.");
        } catch (Exception e) {
            System.err.println("Cannot Write to File: " + e.getMessage());
        }
    }
    
    public static void saveTravelersToFile(TravelerList travelerList) {
        try {
            File file = new File("Repositories/Text File/travelers.txt");
            FileWriter writer = new FileWriter(file);
            for (Traveler t : travelerList.getAllTravelers()) {
                if (t != null) {
                    writer.write(t.getTravelerAsFormattedString() + "\n");
                }
            }
            writer.flush();
            writer.close();
            System.out.println("All travelers saved successfully.");
        } catch (Exception e) {
            System.err.println("Cannot Write to File: " + e.getMessage());
        }
    }

//----------------------------------------------------------------------------------------------------

    public static void loadEmployeesFromFile(EmployeeList employeeList) {
        try {
            File file = new File("Repositories/Text File/employees.txt");
            Scanner fileSc = new Scanner(file);

            while (fileSc.hasNextLine()) {
                String line = fileSc.nextLine();
                String[] data = line.split(";");

                Employee e = new Employee(
                    data[0],
                    data[1],
                    Double.parseDouble(data[2]),
                    Integer.parseInt(data[3]), 
                    Integer.parseInt(data[4]) 
                );

                employeeList.insert(e);
            }

            fileSc.close();
        } catch (Exception e) {
            System.out.println("Cannot Read Employee File");
        }
    }

    public static void saveEmployeesToFile(EmployeeList employeeList) {
        try {
            FileWriter writer = new FileWriter("Repositories/Text File/employees.txt");
            for (Employee e : employeeList.getAllEmployees()) {
                if (e != null) {
                    writer.write(e.getEmployeeId() + ";" + e.getEmployeeName() + ";" + e.getSalary() + ";" + e.getWorkingTime() + ";" + e.getOverTime() + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Cannot Write Employee File");
        }
    }

    //----------------------------------------------------------------------------------------------------

    public static void loadTripsFromFile(TripList tripList) {
        try {
            File file = new File("Repositories/Text File/trips.txt");
            if (!file.exists()) {
                System.out.println("File not found: " + file.getAbsolutePath());
                return;
            }
            Scanner fileSc = new Scanner(file);

            while (fileSc.hasNextLine()) {
                String line = fileSc.nextLine();
                String[] data = line.split(";");
                if (data.length != 4) {
                    System.out.println("Invalid data format: " + line);
                    continue;
                }

                Trip t = new Trip(
                    data[0],
                    data[1],
                    data[2],
                    Integer.parseInt(data[3])
                );

                tripList.insert(t);
            }

            fileSc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Read Trip File: File not found");
        } catch (Exception e) {
            System.out.println("Cannot Read Trip File: " + e.getMessage());
        }
    }

    public static void saveTripToFile(Trip trip) {
        try {
            File file = new File("Repositories/Text File/trips.txt");
            FileWriter writer = new FileWriter(file, true); // Append mode
            writer.write(trip.getTripAsString() + "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Cannot Write In File");
        }
    }

    public static void saveTripsToFile(TripList tripList) {
        try {
            File file = new File("Repositories/Text File/trips.txt");
            FileWriter writer = new FileWriter(file);
            for (Trip t : tripList.getAllTrips()) {
                if (t != null) {
                    writer.write(t.getTripAsString() + "\n");
                }
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Cannot Write In File");
        }
    }
    //----------------------------------------------------------------------------------------------------

    public static void loadBookingsFromFile(BookingList bookingList) {
        try {
            File file = new File("Repositories/Text File/bookings.txt");
            Scanner fileSc = new Scanner(file);

            while (fileSc.hasNextLine()) {
                String line = fileSc.nextLine();
                String[] data = line.split(";");

                Booking b = new Booking(
                    data[0], 
                    data[1],
                    data[2],
                    data[3],
                    data[4],
                    data[5],
                    Double.parseDouble(data[6]),
                    data[7]
                );

                bookingList.insert(b);
            }

            fileSc.close();
        } catch (Exception e) {
            System.out.println("Cannot Read Booking File");
        }
    }
    public static void saveBookingToFile(Booking booking) {
        try {
            File file = new File("Repositories/Text File/bookings.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(booking.getBookingAsString() + "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Cannot Write to File");
        }
    }

    public static void saveBookingsToFile(BookingList bookingList) {
        try {
            File file = new File("Repositories/Text File/bookings.txt");
            FileWriter writer = new FileWriter(file);
            for (Booking b : bookingList.getAllBookings()) {
                if (b != null) {
                    writer.write(b.getBookingAsString() + "\n");
                }
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Cannot Write to File");
        }
    }
}