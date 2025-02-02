package Frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Entities.Trip;
import EntityList.TripList;
import Repositories.FileIO;

public class ManageTripFrame extends JFrame implements ActionListener {

    private JLabel titleLabel, searchLabel;
    private JTextField searchTF, tripIdTextField, destinationTextField, statusTextField, costTextField;
    private JButton searchBtn, backBtn, logoutBtn, exitBtn, addButton, updateButton, deleteButton, showAllButton, clearButton;
    private JTextArea textArea;
    private TripList tripList;

    public ManageTripFrame(String username) {
        super("Trip Management Page");
        tripList = new TripList(500);
        this.setSize(750, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon originalImage = new ImageIcon("./Frames/Image/4.jpg");
        Image scaledImage = originalImage.getImage().getScaledInstance(750, 800, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(scaledImage);
        JLabel background = new JLabel(backgroundImage);
        background.setLayout(null);
        this.setContentPane(background);

        titleLabel = new JLabel("Welcome To Trip Management!");
        titleLabel.setBounds(70, 20, 800, 50);
        titleLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        background.add(titleLabel);

        searchLabel = new JLabel("Search by Trip ID:");
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
        this.add(backBtn);

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

        JLabel tripIdLabel = new JLabel("Trip ID:");
        tripIdLabel.setBounds(100, top, 150, 30);
        tripIdLabel.setForeground(Color.WHITE);
        background.add(tripIdLabel);
        tripIdTextField = new JTextField(20);
        tripIdTextField.setBounds(280, top, 200, 30);
        background.add(tripIdTextField);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(100, top + gap, 150, 30);
        destinationLabel.setForeground(Color.WHITE);
        background.add(destinationLabel);
        destinationTextField = new JTextField(20);
        destinationTextField.setBounds(280, top + gap, 200, 30);
        background.add(destinationTextField);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(100, top + 2 * gap, 150, 30);
        statusLabel.setForeground(Color.WHITE);
        background.add(statusLabel);
        statusTextField = new JTextField(20);
        statusTextField.setBounds(280, top + 2 * gap, 200, 30);
        background.add(statusTextField);

        JLabel costLabel = new JLabel("Cost:");
        costLabel.setBounds(100, top + 3 * gap, 150, 30);
        costLabel.setForeground(Color.WHITE);
        background.add(costLabel);
        costTextField = new JTextField(20);
        costTextField.setBounds(280, top + 3 * gap, 200, 30);
        background.add(costTextField);

        addButton = new JButton("Add Trip");
        addButton.setBounds(500, top, 200, 30);
        addButton.setFont(new Font("Courier New", Font.BOLD, 15));
        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.WHITE);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        addButton.addActionListener(this);
        background.add(addButton);

        updateButton = new JButton("Update Trip");
        updateButton.setBounds(500, top + gap, 200, 30);
        updateButton.setFont(new Font("Courier New", Font.BOLD, 15));
        updateButton.setBackground(buttonColor);
        updateButton.setForeground(Color.WHITE);
        updateButton.setBorderPainted(false);
        updateButton.setFocusPainted(false);
        updateButton.addActionListener(this);
        background.add(updateButton);

        deleteButton = new JButton("Delete Trip");
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

        // Text area for displaying trip info
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane textScrollPane = new JScrollPane(textArea);
        textScrollPane.setBounds(100, top + 8 * gap, 550, 200);
        background.add(textScrollPane);

        // Load all trips initially
        FileIO.loadTripsFromFile(tripList);
        textArea.setText(tripList.getAllAsString());

        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (addButton == e.getSource()) {
            String tripId = tripIdTextField.getText();
            String destination = destinationTextField.getText();
            String status = statusTextField.getText();
            int cost = Integer.parseInt(costTextField.getText());
            Trip t = tripList.getById(tripId);

            if (tripId.isEmpty() || destination.isEmpty() || status.isEmpty() || costTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields");
                return;
            }

            if (t == null) {
                Trip newTrip = new Trip(tripId, destination, status, cost);
                tripList.insert(newTrip);
                FileIO.saveTripsToFile(tripList);
                textArea.setText(tripList.getAllAsString());
            } else {
                JOptionPane.showMessageDialog(this, "Trip ID Already Used");
            }
        } else if (updateButton == e.getSource()) {
            String tripId = tripIdTextField.getText();
            Trip t = tripList.getById(tripId);
            if (t != null) {
                t.setDestination(destinationTextField.getText());
                t.setStatus(statusTextField.getText());
                t.setCost(Integer.parseInt(costTextField.getText()));
                FileIO.saveTripsToFile(tripList);
                textArea.setText(tripList.getAllAsString());
            } else {
                JOptionPane.showMessageDialog(this, "No Trip Found With this ID");
            }
        } else if (searchBtn == e.getSource()) {
            String tripId = searchTF.getText();
            Trip t = tripList.getById(tripId);
            if (t != null) {
                textArea.setText(t.getTripAsString());
            } else {
                JOptionPane.showMessageDialog(this, "No Trip Found With this ID");
            }
        } else if (deleteButton == e.getSource()) {
            String tripId = tripIdTextField.getText();
            tripList.removeById(tripId);
            textArea.setText("Trip deleted successfully.");
        } else if (showAllButton == e.getSource()) {
            textArea.setText(tripList.getAllAsString());
        } else if (clearButton == e.getSource()) {
            textArea.setText("");
        } else if (backBtn == e.getSource()) {
            new HomeFrame().setVisible(true);
            this.dispose();
        } else if (logoutBtn == e.getSource()) {
            new LoginFrame().setVisible(true);
            this.dispose();
        } else if (exitBtn == e.getSource()) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ManageTripFrame("Admin").setVisible(true);
    }
}