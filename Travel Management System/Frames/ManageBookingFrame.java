package Frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Entities.Booking;
import EntityList.BookingList;
import Repositories.FileIO;

public class ManageBookingFrame extends JFrame implements ActionListener {
    
    private JLabel titleLabel, searchLabel;
    private JTextField searchTF, bookingIdTF, travelerIdTF, destinationTF, bookingDateTF, travelDateTF, returnDateTF, totalCostTF, bookingStatusTF;
    private JButton searchBtn, backBtn, logoutBtn, exitBtn, addButton, updateButton, deleteButton, showAllButton, clearButton;
    private JTextArea textArea;
    private BookingList bookingList;
    
    public ManageBookingFrame(String username) {
        super("Booking Management Page");
        
        bookingList = new BookingList(500);
        FileIO.loadBookingsFromFile(bookingList);
        this.setSize(750, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        ImageIcon originalImage = new ImageIcon("./Frames/Image/3.png");
        Image scaledImage = originalImage.getImage().getScaledInstance(750, 800, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(scaledImage);
        JLabel background = new JLabel(backgroundImage);
        background.setLayout(null);
        this.setContentPane(background);
        
        titleLabel = new JLabel("Welcome To Booking Management!");
        titleLabel.setBounds(70, 20, 800, 50);
        titleLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        background.add(titleLabel);
        
        searchLabel = new JLabel("Search by Booking ID:");
        searchLabel.setBounds(100, 90, 200, 30);
        searchLabel.setForeground(Color.WHITE);
        background.add(searchLabel);
        
        searchTF = new JTextField();
        searchTF.setBounds(280, 90, 200, 30);
        background.add(searchTF);
        
        Color buttonColor = new Color(0, 108, 119);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(500, 90, 200, 30);
        searchBtn.setFont(new Font("Courier New", Font.BOLD, 15));
        searchBtn.setBackground(buttonColor);
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setBorderPainted(false);
        searchBtn.setFocusPainted(false);
        searchBtn.addActionListener(this);
        background.add(searchBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(100, 700, 120, 30);
        backBtn.setFont(new Font("Courier New", Font.BOLD, 15));
        backBtn.setBackground(buttonColor);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBorderPainted(false);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(this);
        background.add(backBtn);

        logoutBtn = new JButton("Log Out");
        logoutBtn.setBounds(230, 700, 120, 30);
        logoutBtn.setFont(new Font("Courier New", Font.BOLD, 15));
        logoutBtn.setBackground(buttonColor);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);
        logoutBtn.addActionListener(this);
        background.add(logoutBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(360, 700, 120, 30);
        exitBtn.setFont(new Font("Courier New", Font.BOLD, 15));
        exitBtn.setBackground(buttonColor);
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setBorderPainted(false);
        exitBtn.setFocusPainted(false);
        exitBtn.addActionListener(this);
        background.add(exitBtn);
        
        int top = 150;
        int gap = 40;
        
        JLabel bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setBounds(100, top, 150, 30);
        bookingIdLabel.setForeground(Color.WHITE);
        background.add(bookingIdLabel);
        bookingIdTF = new JTextField(20);
        bookingIdTF.setBounds(280, top, 200, 30);
        background.add(bookingIdTF);

        JLabel travelerIdLabel = new JLabel("Traveler ID:");
        travelerIdLabel.setBounds(100, top + gap, 150, 30);
        travelerIdLabel.setForeground(Color.WHITE);
        background.add(travelerIdLabel);
        travelerIdTF = new JTextField(20);
        travelerIdTF.setBounds(280, top + gap, 200, 30);
        background.add(travelerIdTF);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(100, top + 2 * gap, 150, 30);
        destinationLabel.setForeground(Color.WHITE);
        background.add(destinationLabel);
        destinationTF = new JTextField(20);
        destinationTF.setBounds(280, top + 2 * gap, 200, 30);
        background.add(destinationTF);

        JLabel bookingDateLabel = new JLabel("Booking Date:");
        bookingDateLabel.setBounds(100, top + 3 * gap, 150, 30);
        bookingDateLabel.setForeground(Color.WHITE);
        background.add(bookingDateLabel);
        bookingDateTF = new JTextField(20);
        bookingDateTF.setBounds(280, top + 3 * gap, 200, 30);
        background.add(bookingDateTF);

        JLabel travelDateLabel = new JLabel("Travel Date:");
        travelDateLabel.setBounds(100, top + 4 * gap, 150, 30);
        travelDateLabel.setForeground(Color.WHITE);
        background.add(travelDateLabel);
        travelDateTF = new JTextField(20);
        travelDateTF.setBounds(280, top + 4 * gap, 200, 30);
        background.add(travelDateTF);

        JLabel returnDateLabel = new JLabel("Return Date:");
        returnDateLabel.setBounds(100, top + 5 * gap, 150, 30);
        returnDateLabel.setForeground(Color.WHITE);
        background.add(returnDateLabel);
        returnDateTF = new JTextField(20);
        returnDateTF.setBounds(280, top + 5 * gap, 200, 30);
        background.add(returnDateTF);

        JLabel totalCostLabel = new JLabel("Total Cost:");
        totalCostLabel.setBounds(100, top + 6 * gap, 150, 30);
        totalCostLabel.setForeground(Color.WHITE);
        background.add(totalCostLabel);
        totalCostTF = new JTextField(20);
        totalCostTF.setBounds(280, top + 6 * gap, 200, 30);
        background.add(totalCostTF);

        JLabel bookingStatusLabel = new JLabel("Booking Status:");
        bookingStatusLabel.setBounds(100, top + 7 * gap, 150, 30);
        bookingStatusLabel.setForeground(Color.WHITE);
        background.add(bookingStatusLabel);
        bookingStatusTF = new JTextField(20);
        bookingStatusTF.setBounds(280, top + 7 * gap, 200, 30);
        background.add(bookingStatusTF);

        addButton = new JButton("Add Booking");
        addButton.setBounds(500, top, 200, 30);
        addButton.setFont(new Font("Courier New", Font.BOLD, 15));
        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.WHITE);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        addButton.addActionListener(this);
        background.add(addButton);

        updateButton = new JButton("Update Booking");
        updateButton.setBounds(500, top + gap, 200, 30);
        updateButton.setFont(new Font("Courier New", Font.BOLD, 15));
        updateButton.setBackground(buttonColor);
        updateButton.setForeground(Color.WHITE);
        updateButton.setBorderPainted(false);
        updateButton.setFocusPainted(false);
        updateButton.addActionListener(this);
        background.add(updateButton);

        deleteButton = new JButton("Delete Booking");
        deleteButton.setBounds(500, top + 2 * gap, 200, 30);
        deleteButton.setFont(new Font("Courier New", Font.BOLD, 15));
        deleteButton.setBackground(buttonColor);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBorderPainted(false);
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(this);
        background.add(deleteButton);

        showAllButton = new JButton("Show All");
        showAllButton.setBounds(500, top + 3 * gap, 200, 30);
        showAllButton.setFont(new Font("Courier New", Font.BOLD, 15));
        showAllButton.setBackground(buttonColor);
        showAllButton.setForeground(Color.WHITE);
        showAllButton.setBorderPainted(false);
        showAllButton.setFocusPainted(false);
        showAllButton.addActionListener(this);
        background.add(showAllButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(500, top + 4 * gap, 200, 30);
        clearButton.setFont(new Font("Courier New", Font.BOLD, 15));
        clearButton.setBackground(buttonColor);
        clearButton.setForeground(Color.WHITE);
        clearButton.setBorderPainted(false);
        clearButton.setFocusPainted(false);
        clearButton.addActionListener(this);
        background.add(clearButton);
        
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane textScrollPane = new JScrollPane(textArea);
        textScrollPane.setBounds(100, top + 8 * gap, 550, 200);
        background.add(textScrollPane);
        
        FileIO.loadBookingsFromFile(bookingList);
        
        super.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            Booking booking = new Booking(bookingIdTF.getText(), travelerIdTF.getText(), destinationTF.getText(), bookingDateTF.getText(), travelDateTF.getText(), returnDateTF.getText(), Double.parseDouble(totalCostTF.getText()), bookingStatusTF.getText());
            bookingList.insert(booking);
            FileIO.saveBookingToFile(booking);
            textArea.setText(bookingList.getAllAsString());
        } else if (e.getSource() == updateButton) {
            Booking booking = bookingList.getById(bookingIdTF.getText());
            if (booking != null) {
                booking.setTravelerId(travelerIdTF.getText());
                booking.setDestination(destinationTF.getText());
                booking.setBookingDate(bookingDateTF.getText());
                booking.setTravelDate(travelDateTF.getText());
                booking.setReturnDate(returnDateTF.getText());
                booking.setTotalCost(Double.parseDouble(totalCostTF.getText()));
                booking.setBookingStatus(bookingStatusTF.getText());
                FileIO.saveBookingsToFile(bookingList);
                textArea.setText(bookingList.getAllAsString());
            } else {
                JOptionPane.showMessageDialog(this, "No Booking Found With this ID");
            }
        } else if (e.getSource() == searchBtn) {
            Booking booking = bookingList.getById(searchTF.getText());
            textArea.setText(booking != null ? booking.getBookingAsString() : "No Booking Found");
        } else if (e.getSource() == deleteButton) {
            bookingList.removeById(bookingIdTF.getText());
            textArea.setText("Booking deleted successfully.");
        } else if (e.getSource() == showAllButton) {
            textArea.setText(bookingList.getAllAsString());
        } else if (e.getSource() == clearButton) {
            textArea.setText("");
        } else if (e.getSource() == backBtn) {
            new HomeFrame().setVisible(true);
            this.dispose();
        } else if (e.getSource() == logoutBtn) {
            new LoginFrame().setVisible(true);
            this.dispose();
        } else if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new ManageBookingFrame("Admin").setVisible(true);
    }
}