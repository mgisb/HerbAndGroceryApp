import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// homepage panel is where the user can view their profile, orders, and contact customer service

public class HomepagePanel extends JPanel {
    private CardLayout cardLayout;
    public JPanel ordersFrame;

    private JLabel username;
    private JLabel email;
    private JLabel address;

    public HomepagePanel() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        System.out.println("hey!");

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
                if ("Back".equals(clickedButton.getText())){
                    cardLayout.show(HomepagePanel.this, "buttonpanel");
                } else if ("Profile".equals(clickedButton.getText())){
                    cardLayout.show(HomepagePanel.this, "profile");
                } else if ("Orders".equals(clickedButton.getText())){
                    cardLayout.show(HomepagePanel.this, "orders");
                }
            }
        };

        //creating homepage layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,1));
        JButton profileButton = new JButton("Profile");
        JButton ordersButton = new JButton("Orders");
        JButton button4 = new JButton("Customer Service");
        Font buttonFont = new Font("Times", Font.BOLD, 25);
        profileButton.addActionListener(listener);
        ordersButton.addActionListener(listener);
        profileButton.setFont(buttonFont);
        ordersButton.setFont(buttonFont);
        button4.setFont(buttonFont);
        buttonPanel.add(profileButton);
        buttonPanel.add(ordersButton);
        buttonPanel.add(button4);
        this.add(buttonPanel, "buttonpanel");
        cardLayout.show(this, "buttonpanel");


        // creating profile frame
        JPanel profile = new JPanel();
        profile.setLayout(new GridLayout(0,1));
        Font labelFont = new Font("Times", Font.BOLD, 15);
        username = new JLabel("Username: "+user.getUsername());
        email = new JLabel("Email: "+user.getEmail());
        address = new JLabel("Address: "+user.getUserAddress());
        JButton back = new JButton("Back");
        back.addActionListener(listener);
        username.setFont(labelFont);
        email.setFont(labelFont);
        address.setFont(labelFont);
        //back.setFont(labelFont);
        back.setBorderPainted(false);
        profile.add(username);
        profile.add(email);
        profile.add(address);
        profile.add(back,BorderLayout.PAGE_END);
        this.add(profile, "profile");

        // creating orders frame
        ordersFrame = new JPanel();
        ordersFrame.setLayout(new GridLayout(0,1));
        JScrollPane scrollPane = new JScrollPane(ordersFrame);
        JButton ordersBack = new JButton("Back");
        ordersBack.setFont(labelFont);
        ordersBack.setBorderPainted(false);
        ordersBack.addActionListener(listener);
        ordersFrame.add(ordersBack,BorderLayout.PAGE_END);
        ordersBack.setPreferredSize(new Dimension(300, 25));
        this.add(scrollPane, "orders");

        //creating customer service frame
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                JPanel service = new CustomerService();
            }
        });

        // retreive user information from the database and display them on the app
        String sql = "SELECT username, email, addy FROM users WHERE id = ?";

        try (

            Connection connection = DriverManager.getConnection("jdbc:mysql://35.238.103.130:3306/groceryAppDB?useSSL=false", "root", "K@ren43571");
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, 1);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String usernamedb = resultSet.getString("username");
                String emaildb = resultSet.getString("email");
                String addy = resultSet.getString("addy");

                username.setText("Username: "+usernamedb);
                email.setText("Email: "+emaildb);
                address.setText("Address: "+addy);
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        



    }

    
}
