package Frames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Entities.Employee;
import EntityList.EmployeeList;
import Repositories.FileIO;

public class ManageEmployeeFrame extends JFrame implements ActionListener {

    private JLabel titleLabel, searchLabel;
    private JTextField searchTF, idTextField, nameTextField, salaryTextField, workingTimeTextField, overTimeTextField;
    private JButton searchBtn, backBtn, logoutBtn, exitBtn, addButton, updateButton, deleteButton, showAllButton, clearButton;
    private JTextArea textArea;
    private EmployeeList employeeList;

    public ManageEmployeeFrame(String username) {
        super("Employee Management Page");
        employeeList = new EmployeeList();
        this.setSize(750, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon originalImage = new ImageIcon("./Frames/Image/3.png");
        Image scaledImage = originalImage.getImage().getScaledInstance(750, 800, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(scaledImage);
        JLabel background = new JLabel(backgroundImage);
        background.setLayout(null);
        this.setContentPane(background);

        titleLabel = new JLabel("Welcome, " + username + "!");
        titleLabel.setBounds(70, 20, 800, 50);
        titleLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        background.add(titleLabel);

        searchLabel = new JLabel("Search by Employee ID:");
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

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(100, top + 2 * gap, 150, 30);
        salaryLabel.setForeground(Color.WHITE);
        background.add(salaryLabel);
        salaryTextField = new JTextField(20);
        salaryTextField.setBounds(280, top + 2 * gap, 200, 30);
        background.add(salaryTextField);

        JLabel workingTimeLabel = new JLabel("Working Time:");
        workingTimeLabel.setBounds(100, top + 3 * gap, 150, 30);
        workingTimeLabel.setForeground(Color.WHITE);
        background.add(workingTimeLabel);
        workingTimeTextField = new JTextField(20);
        workingTimeTextField.setBounds(280, top + 3 * gap, 200, 30);
        background.add(workingTimeTextField);

        JLabel overTimeLabel = new JLabel("Over Time:");
        overTimeLabel.setBounds(100, top + 4 * gap, 150, 30);
        overTimeLabel.setForeground(Color.WHITE);
        background.add(overTimeLabel);
        overTimeTextField = new JTextField(20);
        overTimeTextField.setBounds(280, top + 4 * gap, 200, 30);
        background.add(overTimeTextField);

        addButton = new JButton("Add Employee");
        addButton.setBounds(500, top, 200, 30);
        addButton.setFont(new Font("Courier New", Font.BOLD, 15));
        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.WHITE);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        addButton.addActionListener(this);
        background.add(addButton);

        updateButton = new JButton("Update Employee");
        updateButton.setBounds(500, top + gap, 200, 30);
        updateButton.setFont(new Font("Courier New", Font.BOLD, 15));
        updateButton.setBackground(buttonColor);
        updateButton.setForeground(Color.WHITE);
        updateButton.setBorderPainted(false);
        updateButton.setFocusPainted(false);
        updateButton.addActionListener(this);
        background.add(updateButton);

        deleteButton = new JButton("Delete Employee");
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

        // Text area for displaying employee info
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane textScrollPane = new JScrollPane(textArea);
        textScrollPane.setBounds(100, top + 8 * gap, 550, 200);
        background.add(textScrollPane);

        // Load all employees initially
        FileIO.loadEmployeesFromFile(employeeList);

        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Search")) {
            String employeeId = searchTF.getText();
            if (employeeId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter an Employee ID", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                searchEmployeeById(employeeId);
            }
        } else if (e.getSource() == addButton) {
            try {
                String id = idTextField.getText();
                String name = nameTextField.getText();
                double salary = Double.parseDouble(salaryTextField.getText());
                int workingTime = Integer.parseInt(workingTimeTextField.getText());
                int overTime = Integer.parseInt(overTimeTextField.getText());

                Employee e1 = new Employee(name, id, salary, workingTime, overTime);
                employeeList.insert(e1);
                FileIO.saveEmployeesToFile(employeeList);
                textArea.setText("Employee added successfully.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for Salary, Working Time, and Over Time", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == updateButton) {
            try {
                String id = idTextField.getText();
                Employee e1 = employeeList.getById(id);
                if (e1 != null) {
                    e1.setEmployeeName(nameTextField.getText());
                    e1.setSalary(Double.parseDouble(salaryTextField.getText()));
                    e1.setWorkingTime(Integer.parseInt(workingTimeTextField.getText()));
                    e1.setOverTime(Integer.parseInt(overTimeTextField.getText()));
                    FileIO.saveEmployeesToFile(employeeList);
                    textArea.setText("Employee updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "No Employee Found With this ID");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for Salary, Working Time, and Over Time", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == searchBtn) {
            String id = searchTF.getText();
            Employee e1 = employeeList.getById(id);
            if (e1 != null) {
                textArea.setText(e1.getEmployeeAsString());
            } else {
                JOptionPane.showMessageDialog(this, "No Employee Found With this ID");
            }
        } else if (e.getSource() == deleteButton) {
            String id = idTextField.getText();
            employeeList.removeById(id);
            FileIO.saveEmployeesToFile(employeeList);
            textArea.setText("Employee deleted successfully.");
        } else if (e.getSource() == showAllButton) {
            textArea.setText(employeeList.getAllAsString());
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

    private void searchEmployeeById(String employeeId) {
        Employee e = employeeList.getById(employeeId);
        if (e != null) {
            textArea.setText(e.getEmployeeAsString());
        } else {
            JOptionPane.showMessageDialog(this, "No Employee Found With this ID");
        }
    }

    public static void main(String[] args) {
        new ManageEmployeeFrame("Admin").setVisible(true);
    }
}