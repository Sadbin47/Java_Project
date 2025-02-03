package Frames;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HomeFrame extends JFrame implements ActionListener {

    private JButton travelerManageButton, employeeManageButton, tripManageButton, hotelBookingManageButton, registrationButton, backButton;
    private Font myFont, titleFont;

    public HomeFrame() {
        super("Manager Page");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLocation(80, 0);

        ImageIcon originalImage = new ImageIcon("./Frames/Image/1.jpg");
        Image scaledImage = originalImage.getImage().getScaledInstance(1400, 800, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(scaledImage);
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 1400, 800);
        this.setContentPane(background);
        this.setLayout(null);

        titleFont = new Font("Courier New", Font.BOLD, 50);
        myFont = new Font("Courier New", Font.BOLD, 30);

        JLabel title = new JLabel("Welcome!");
        title.setBounds(635, 100, 900, 100);
        title.setFont(titleFont);
        title.setForeground(new Color(0, 108, 119));
        this.add(title);

        travelerManageButton = new JButton("Manage Traveler");
        travelerManageButton.setBounds(575, 250, 350, 50);
        travelerManageButton.setFont(myFont);
        travelerManageButton.setBackground(new Color(0, 108, 119));
        travelerManageButton.setForeground(Color.WHITE);
        travelerManageButton.setFocusPainted(false);
        travelerManageButton.addActionListener(this);
        this.add(travelerManageButton);

        employeeManageButton = new JButton("Manage Employee");
        employeeManageButton.setBounds(575, 320, 350, 50);
        employeeManageButton.setFont(myFont);
        employeeManageButton.setBackground(new Color(0, 108, 119));
        employeeManageButton.setForeground(Color.WHITE);
        employeeManageButton.setFocusPainted(false);
        employeeManageButton.addActionListener(this);
        this.add(employeeManageButton);

        tripManageButton = new JButton("Manage Trip");
        tripManageButton.setBounds(575, 390, 350, 50);
        tripManageButton.setFont(myFont);
        tripManageButton.setBackground(new Color(0, 108, 119));
        tripManageButton.setForeground(Color.WHITE);
        tripManageButton.setFocusPainted(false);
        tripManageButton.addActionListener(this);
        this.add(tripManageButton);

        hotelBookingManageButton = new JButton("Manage Booking");
        hotelBookingManageButton.setBounds(575, 460, 350, 50);
        hotelBookingManageButton.setFont(myFont);
        hotelBookingManageButton.setBackground(new Color(0, 108, 119));
        hotelBookingManageButton.setForeground(Color.WHITE);
        hotelBookingManageButton.setFocusPainted(false);
        hotelBookingManageButton.addActionListener(this);
        this.add(hotelBookingManageButton);

        registrationButton = new JButton("Registration");
        registrationButton.setBounds(575, 530, 350, 50);
        registrationButton.setFont(myFont);
        registrationButton.setBackground(new Color(0, 108, 119));
        registrationButton.setForeground(Color.WHITE);
        registrationButton.setFocusPainted(false);
        registrationButton.addActionListener(this);
        this.add(registrationButton);

        backButton = new JButton("Back");
        backButton.setBounds(670, 600, 150, 30);
        backButton.setFont(new Font("Courier New", Font.BOLD, 20));
        backButton.setBackground(new Color(0, 0, 0));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(this);
        this.add(backButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (travelerManageButton == e.getSource()) {
            new ManageTravelerFrame("Traveler").setVisible(true);
            this.dispose();
        } else if (employeeManageButton == e.getSource()) {
            new ManageEmployeeFrame("Employee").setVisible(true);
            this.dispose();
        } else if (tripManageButton == e.getSource()) {
            new ManageTripFrame("Trip").setVisible(true);
            this.dispose();
        } else if (e.getSource() == hotelBookingManageButton) {
            new ManageBookingFrame("Booking").setVisible(true);
            this.dispose();
        } else if (registrationButton == e.getSource()) {
            new SignupFrame().setVisible(true);
            this.dispose();
        } else if (backButton == e.getSource()) {
            new LoginFrame().setVisible(true);
            this.dispose();
        } else {
            System.out.println("Error Occurred");
        }
    }
}