import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LogIn extends JFrame implements ActionListener {
    // Define components
    Container container = getContentPane();
    JLabel titleLabel = new JLabel("Welcome to the Lovelace Library System");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JCheckBox chkStudent = new JCheckBox("Student");
    JCheckBox chkTeacher = new JCheckBox("Teacher");
    ButtonGroup roleGroup = new ButtonGroup(); // Group to ensure single selection
    
    // Constructor to set up the frame
    LogIn() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    // Method to set the layout manager
    public void setLayoutManager() {
        container.setLayout(null);
    }

    // Method to set the location and size of components
    public void setLocationAndSize() {
        titleLabel.setBounds(50, 10, 300, 30);
        userLabel.setBounds(50, 50, 100, 30);
        passwordLabel.setBounds(50, 120, 100, 30);
        userTextField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 120, 150, 30);
        showPassword.setBounds(150, 150, 150, 30);
        chkStudent.setBounds(150, 180, 150, 30);
        chkTeacher.setBounds(150, 210, 150, 30);
        loginButton.setBounds(50, 260, 100, 30);
        resetButton.setBounds(200, 260, 100, 30);
    }

    // Method to add components to the container
    public void addComponentsToContainer() {
        container.add(titleLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(chkStudent);
        container.add(chkTeacher);
        container.add(loginButton);
        container.add(resetButton);

        // Add checkboxes to the ButtonGroup to ensure only one can be selected
        roleGroup.add(chkStudent);
        roleGroup.add(chkTeacher);
    }

    // Method to add action listeners to components
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    // Method to handle actions performed on components
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle login button action
        if (e.getSource() == loginButton) {
            String userText = userTextField.getText();
            String pwdText = new String(passwordField.getPassword()); // Use getPassword() for security
            
            if (isValidUser(userText, pwdText)) { 
                JOptionPane.showMessageDialog(this, "Login Successful");
                openUserInterface(userText); // Open user interface
                dispose(); // Close the login frame
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }

        // Handle reset button action
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
            roleGroup.clearSelection(); // Clear the role selection
        }

        // Handle show password checkbox action
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0); // Show password
            } else {
                passwordField.setEchoChar('*'); // Hide password
            }
        }
    }

    // Method to check if the user is valid
    private boolean isValidUser(String username, String password) {
        // Implement your authentication logic here
        return username.equalsIgnoreCase("x") && password.equals("1");
    }

    // Method to open the user interface
    private void openUserInterface(String username) {
        new UserInterface(username);
    }

    // Main class to run the login frame
    public static void main(String[] a) {
        LogIn frame = new LogIn();
        frame.setSize(500,500);
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
