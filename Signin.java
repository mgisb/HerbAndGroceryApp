import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Signin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton registerButton;

    private Connection connection;

    public Signin() {
        setTitle("Sign In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));
        setVisible(true);

        ArrayList<String> groceries = new ArrayList<>();
        groceries.add("Apples");
        groceries.add("Bananas");
        groceries.add("Milk");
        groceries.add("Bread");
        groceries.add("Eggs");
        groceries.add("Cheese");
        groceries.add("Tomatoes");
        groceries.add("Potatoes");
        groceries.add("Onions");
        UserClass user = new UserClass(243, "johndoetest", "john123", "605 Halifax Street Blackwood, NJ 08012","johndoe@gmail.com",groceries);

        try {
            connection = DriverManager.getConnection("jdbc:mysql://35.238.103.130:3306/groceryAppDB?useSSL=false", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                if ("Sign In".equals(clickedButton.getText())){
                    if (authenticate(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
                        dispose();
                        new HerbAndGroceryApp();
                    }else{
                        JOptionPane.showMessageDialog(Signin.this,"Invalid Username or Password ");
                    }
                } else if ("Register".equals(clickedButton.getText())){
                    dispose();
                    new Register();
                }
            }
        };

        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(250, 25));
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(250, 25));
        signInButton = new JButton("Sign In");
        signInButton.addActionListener(listener);
        registerButton = new JButton("Register");
        registerButton.addActionListener(listener);

        // Add components to the frame
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(usernameLabel);
        panel1.add(usernameField);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(passwordLabel);
        panel2.add(passwordField);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));
        panel3.add(signInButton);
        panel3.add(Box.createRigidArea(new Dimension(0, 10)));
        panel3.add(registerButton);
        signInButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        add(panel1);
        add(panel2);
        add(panel3);
    }

    public boolean authenticate(String username, String password) {
        String query = "SELECT pass FROM users WHERE username = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("pass");
                
                if (password.equals(dbPassword)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}
