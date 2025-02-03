package Frames;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import Entities.Traveler;
import EntityList.TravelerList;
import Repositories.FileIO;

public class ManageTravelerFrame extends JFrame implements ActionListener {

    private JLabel titleLabel, searchLabel;
    private JTextField searchTF, idTextField, nameTextField, contactTextField, emailTextField, nationalityTextField, emergencyContactTextField;
    private JButton searchBtn, backBtn, logoutBtn, exitBtn, addButton, updateButton, deleteButton, showAllButton, clearButton;
    private JComboBox<String> genderComboBox;
    private JTextArea textArea;
    private TravelerList travelerList;

    public ManageTravelerFrame(String username) {
        super("Traveler Management Page");
        travelerList = new TravelerList(500);
        this.setSize(750, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon originalImage = new ImageIcon("./Frames/Image/4.jpg");
        Image scaledImage = originalImage.getImage().getScaledInstance(750, 800, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(scaledImage);
        JLabel background = new JLabel(backgroundImage);
        background.setLayout(null);
        this.setContentPane(background);

        titleLabel = new JLabel("Welcome To Traveler Management!");
        titleLabel.setBounds(70, 20, 800, 50);
        titleLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        background.add(titleLabel);

        searchLabel = new JLabel("Search by ID:");
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

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(100, top, 150, 30);
        idLabel.setForeground(Color.WHITE);
        background.add(idLabel);
        idTextField = new JTextField(20);
        idTextField.setBounds(280, top, 200, 30);
        background.add(idTextField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, top + gap, 150, 30);
        nameLabel.setForeground(Color.WHITE);
        background.add(nameLabel);
        nameTextField = new JTextField(20);
        nameTextField.setBounds(280, top + gap, 200, 30);
        background.add(nameTextField);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(100, top + 2 * gap, 150, 30);
        contactLabel.setForeground(Color.WHITE);
        background.add(contactLabel);
        contactTextField = new JTextField(20);
        contactTextField.setBounds(280, top + 2 * gap, 200, 30);
        background.add(contactTextField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, top + 3 * gap, 150, 30);
        emailLabel.setForeground(Color.WHITE);
        background.add(emailLabel);
        emailTextField = new JTextField(20);
        emailTextField.setBounds(280, top + 3 * gap, 200, 30);
        background.add(emailTextField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(100, top + 4 * gap, 150, 30);
        genderLabel.setForeground(Color.WHITE);
        background.add(genderLabel);

        genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        genderComboBox.setBounds(280, top + 4 * gap, 200, 30);
        genderComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        background.add(genderComboBox);

        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityLabel.setBounds(100, top + 5 * gap, 150, 30);
        nationalityLabel.setForeground(Color.WHITE);
        background.add(nationalityLabel);
        nationalityTextField = new JTextField(20);
        nationalityTextField.setBounds(280, top + 5 * gap, 200, 30);
        background.add(nationalityTextField);

        JLabel emergencyContactLabel = new JLabel("Emergency Contact:");
        emergencyContactLabel.setBounds(100, top + 6 * gap, 150, 30);
        emergencyContactLabel.setForeground(Color.WHITE);
        background.add(emergencyContactLabel);
        emergencyContactTextField = new JTextField(20);
        emergencyContactTextField.setBounds(280, top + 6 * gap, 200, 30);
        background.add(emergencyContactTextField);

        addButton = new JButton("Add Traveler");
        addButton.setBounds(500, top, 200, 30);
        addButton.setFont(new Font("Courier New", Font.BOLD, 15));
        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.WHITE);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        addButton.addActionListener(this);
        background.add(addButton);

        updateButton = new JButton("Update Traveler");
        updateButton.setBounds(500, top + gap, 200, 30);
        updateButton.setFont(new Font("Courier New", Font.BOLD, 15));
        updateButton.setBackground(buttonColor);
        updateButton.setForeground(Color.WHITE);
        updateButton.setBorderPainted(false);
        updateButton.setFocusPainted(false);
        updateButton.addActionListener(this);
        background.add(updateButton);

        deleteButton = new JButton("Delete Traveler");
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

        // Text area for displaying traveler info
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane textScrollPane = new JScrollPane(textArea);
        textScrollPane.setBounds(100, top + 8 * gap, 550, 200);
        background.add(textScrollPane);

        // Load all travelers initially
        FileIO.loadTravelersFromFile(travelerList);
        textArea.setText(travelerList.getAllAsString());

        super.setVisible(true);
    }

    @Override
	public void actionPerformed(ActionEvent e) {
    if (addButton == e.getSource()) {
        String id = idTextField.getText();
        String name = nameTextField.getText();
        String contact = contactTextField.getText();
        String email = emailTextField.getText();
        String gender = genderComboBox.getSelectedItem().toString();
        String nationality = nationalityTextField.getText();
        String emergencyContact = emergencyContactTextField.getText();

        if (id.isEmpty() || name.isEmpty() || contact.isEmpty() || email.isEmpty() || gender.isEmpty() || nationality.isEmpty() || emergencyContact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input data in all fields");
            return;
        }

        if (contact.length() != 11) {
            JOptionPane.showMessageDialog(this, "Contact number must 11 characters long");
            return;
        }
        if (emergencyContact.length() != 11) {
            JOptionPane.showMessageDialog(this, "EmergencyContact number must 11 characters long");
            return;
        }
        if (contact.equals(emergencyContact)) {
            JOptionPane.showMessageDialog(this, "Emergency contact cannot be the same as contact number");
            return;
        }

        Traveler t = travelerList.getById(id);
        if (t == null) {
            Traveler newTraveler = new Traveler(id, name, email, contact, gender, nationality, emergencyContact);
            travelerList.insert(newTraveler);
            FileIO.saveTravelerToFile(newTraveler);
            textArea.setText(travelerList.getAllAsString());
        } else {
            JOptionPane.showMessageDialog(this, "ID Already Used");
        }
    } else if (updateButton == e.getSource()) {
        String id = idTextField.getText();
        Traveler t = travelerList.getById(id);
        if (t != null) {
            String name = nameTextField.getText();
            String contact = contactTextField.getText();
            String email = emailTextField.getText();
            String gender = genderComboBox.getSelectedItem().toString();
            String nationality = nationalityTextField.getText();
            String emergencyContact = emergencyContactTextField.getText();
    
            if (name.isEmpty() || contact.isEmpty() || email.isEmpty() || gender.isEmpty() || nationality.isEmpty() || emergencyContact.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please input data in all fields");
                return;
            }
    
            t.setTravelerName(name);
            t.setContactNumber(contact);
            t.setEmailAddress(email);
            t.setGender(gender);
            t.setNationality(nationality);
            t.setEmergencyContact(emergencyContact);
    
            FileIO.saveTravelersToFile(travelerList);
            textArea.setText(travelerList.getAllAsString());
        } else {
            JOptionPane.showMessageDialog(this, "No Traveler Found With this ID");
        }
    } else if (searchBtn == e.getSource()) {
        String id = searchTF.getText();
        Traveler t = travelerList.getById(id);
        if (t != null) {
            textArea.setText(t.displayInfo());
        } else {
            JOptionPane.showMessageDialog(this, "No Traveler Found With this ID");
        }
    } else if (deleteButton == e.getSource()) {
        String id = idTextField.getText();
        travelerList.removeById(id);

        //if i want to delete from file also (its not required)
        //FileIO.saveTravelersToFile(travelerList);

        textArea.setText("Traveler deleted successfully.");
    } else if (showAllButton == e.getSource()) {
        StringBuilder allTravelersFormatted = new StringBuilder();
        for (Traveler traveler : travelerList.getAllTravelers()) {
            if (traveler != null) {
                allTravelersFormatted.append(traveler.displayInfo()).append("\n");
            }
        }
        textArea.setText(allTravelersFormatted.toString());
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

    //public static void main(String[] args) {
    //    new ManageTravelerFrame("Admin").setVisible(true);
    //}
}