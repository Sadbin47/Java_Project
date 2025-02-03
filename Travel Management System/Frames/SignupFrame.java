package Frames;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Repositories.FileIO;

public class SignupFrame extends JFrame implements ActionListener {

    private JTextField usernameTextField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton, backButton;
    private Font myFont, titleFont;
    private JPanel panel;

    public SignupFrame() {
        super("Signup Page");
        this.setSize(1400, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.setLocation(80, 0);

        ImageIcon originalImage = new ImageIcon("./Frames/Image/2.jpg");
        Image scaledImage = originalImage.getImage().getScaledInstance(1400, 800, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(scaledImage);
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 1400, 800);
        panel.add(background);

        titleFont = new Font("Courier New", Font.BOLD, 50);
        JLabel title = new JLabel("Create a New Account");
        title.setBounds(400, 30, 700, 100);
        title.setFont(titleFont);
        title.setForeground(new Color(0, 108, 119));
        background.add(title);

        myFont = new Font("Courier New", Font.BOLD, 20);
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(450, 250, 200, 30);
        usernameLabel.setFont(myFont);
        usernameLabel.setForeground(new Color(0, 108, 119));
        background.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(655, 250, 200, 30);
        background.add(usernameTextField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(450, 300, 200, 30);
        passwordLabel.setFont(myFont);
        passwordLabel.setForeground(new Color(0, 108, 119));
        background.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(655, 300, 200, 30);
        background.add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(450, 350, 250, 30);
        confirmPasswordLabel.setFont(myFont);
        confirmPasswordLabel.setForeground(new Color(0, 108, 119));
        background.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(655, 350, 200, 30);
        background.add(confirmPasswordField);

        registerButton = new JButton("Register");
        registerButton.setBounds(500, 450, 150, 30);
        registerButton.setFont(new Font("Courier New", Font.BOLD, 20));
        registerButton.setBackground(new Color(0, 108, 119));
        registerButton.setForeground(Color.WHITE);
        registerButton.addActionListener(this);
        background.add(registerButton);

        backButton = new JButton("Back");
        backButton.setBounds(700, 450, 150, 30);
        backButton.setFont(new Font("Courier New", Font.BOLD, 20));
        backButton.setBackground(new Color(0, 108, 119));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        background.add(backButton);
        this.setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (registerButton == e.getSource()) {
            String username = usernameTextField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fields cannot be empty");
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match");
            } else {
                if (FileIO.addUser(username, password)) {
                    JOptionPane.showMessageDialog(this, "Account Created Successfully");
                    new LoginFrame().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Error creating account");
                }
            }
        }
        else if (e.getSource() == backButton) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
    }
}