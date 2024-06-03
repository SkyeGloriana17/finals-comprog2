import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {
    private JLabel usernameLabel;
    private JButton viewBookListButton;
    private JButton returnBooksButton;
    private JButton exitButton;

    public UserInterface(String username) {
        setTitle("Lovelace Library System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        usernameLabel = new JLabel("Welcome, " + username + "!");
        usernameLabel.setBounds(50, 20, 300, 30);
        panel.add(usernameLabel);
        
        //view Book List
        viewBookListButton = new JButton("View Book List");
        viewBookListButton.setBounds(50, 60, 150, 30);
        panel.add(viewBookListButton);
        
        //return Books
        returnBooksButton = new JButton("Return Books");
        returnBooksButton.setBounds(50, 100, 150, 30);
        panel.add(returnBooksButton);
        
        //Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(50, 140, 150, 30);
        panel.add(exitButton);
        // Add action listener to the exit button
        exitButton.addActionListener(e -> {
            // Close the program
            System.exit(0);
        });

        add(panel);
        setVisible(true);
    }

    public JButton getViewBookListButton() {
        return viewBookListButton;
    }

    public JButton getReturnBooksButton() {
        return returnBooksButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
