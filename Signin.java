import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Signin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton registerButton;

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

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                if ("Sign In".equals(clickedButton.getText())){
                    if (usernameField.getText().equals(user.getUsername()) && String.valueOf(passwordField.getPassword()).equals(user.getUserPass())){
                        dispose();
                        new HerbAndGroceryApp();
                    }
                } else if ("Register".equals(clickedButton.getText())){
                    System.out.println("Register");
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



}
