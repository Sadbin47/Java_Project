package Frames;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Repositories.FileIO;

public class LoginFrame extends JFrame implements ActionListener {

    private JTextField nameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton , exitButton;
    private Font myFont, titleFont;

    public LoginFrame() {
        super("Login Page");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(1400, 800);
        super.setLocation(80, 0);

        ImageIcon originalImage = new ImageIcon("./Frames/Image/1.jpg");
        Image scaledImage = originalImage.getImage().getScaledInstance(1400, 800, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(scaledImage);
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 1400, 800);
        this.setContentPane(background);
        this.setLayout(null);

        titleFont = new Font("Courier New", Font.BOLD, 50);
        myFont = new Font("Courier New", Font.BOLD, 30);

        JLabel title = new JLabel("Travel Management System");
        title.setBounds(320, 30, 900, 100);
        title.setFont(titleFont);
        title.setForeground(new Color(0, 108, 119));
        this.add(title);

        JLabel subTitle = new JLabel("User Login");
        subTitle.setBounds(550, 250, 320, 50);
        subTitle.setFont(myFont);
        subTitle.setForeground(new Color(0, 108, 119));
        this.add(subTitle);

        JLabel nameLabel = new JLabel("Username:");
        nameLabel.setBounds(450, 350, 200, 30);
        nameLabel.setFont(myFont);
        nameLabel.setForeground(new Color(0, 108, 119));
        this.add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(655, 350, 200, 30);
        this.add(nameTextField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(450, 400, 200, 30);
        passwordLabel.setFont(myFont);
        passwordLabel.setForeground(new Color(0, 108, 119));
        this.add(passwordLabel);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(655, 400, 200, 30);
        this.add(passwordTextField);

        loginButton = new JButton("LOG IN");
        loginButton.setBounds(575, 450, 200, 30);
        loginButton.setFont(myFont);
        loginButton.setBackground(new Color(0, 108, 119));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(this);
        this.add(loginButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(630, 500, 100, 30);
        exitButton.setFont(new Font("Courier New", Font.BOLD, 20));
        exitButton.setForeground(new Color(0, 108, 119));
        exitButton.setBackground(new Color(0, 0, 0));
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(this);
        this.add(exitButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (loginButton == e.getSource()) {
            String username = nameTextField.getText();
            String password = new String(passwordTextField.getPassword());

            if (FileIO.checkUser(username, password)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                new HomeFrame().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid User");
            }          
        } else if (exitButton == e.getSource()) {
            System.exit(0);
        }
    }
}