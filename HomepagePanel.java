import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class HomepagePanel extends JPanel {
    private CardLayout cardLayout;

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
                System.out.println("Button clicked: " + clickedButton.getText());
                if (clickedButton.getText() == "Back"){
                    cardLayout.show(HomepagePanel.this, "buttonpanel");
                } else if (clickedButton.getText() == "Profile"){
                    cardLayout.show(HomepagePanel.this, "profile");
                } else if (clickedButton.getText() == "Orders"){
                    cardLayout.show(HomepagePanel.this, "orders");
                }
            }
        };

        //creating homepage layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,1));
        JButton profileButton = new JButton("Profile");
        JButton ordersButton = new JButton("Orders");
        JButton button3 = new JButton("Your List");
        JButton button4 = new JButton("Customer Service");
        Font buttonFont = new Font("Times", Font.BOLD, 25);
        profileButton.addActionListener(listener);
        ordersButton.addActionListener(listener);
        profileButton.setFont(buttonFont);
        ordersButton.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);
        buttonPanel.add(profileButton);
        buttonPanel.add(ordersButton);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        this.add(buttonPanel, "buttonpanel");
        cardLayout.show(this, "buttonpanel");


        // creating profile frame
        JPanel profile = new JPanel();
        profile.setLayout(new GridLayout(4,1));
        Font labelFont = new Font("Times", Font.BOLD, 15);
        JLabel username = new JLabel("Username: "+user.getUsername());
        JLabel email = new JLabel("Email: "+user.getEmail());
        JLabel address = new JLabel("Address: "+user.getUserAddress());
        JButton back = new JButton("Back");
        back.addActionListener(listener);
        username.setFont(labelFont);
        email.setFont(labelFont);
        address.setFont(labelFont);
        back.setFont(labelFont);
        profile.add(username);
        profile.add(email);
        profile.add(address);
        profile.add(back);
        this.add(profile, "profile");

        // creating orders frame
        JPanel ordersFrame = new JPanel();
        ordersFrame.setLayout(new GridLayout(0,1));
        for (String item : user.getUserOrder()) {
            JButton button = new JButton(item);
            ordersFrame.add(button);
        }
        JScrollPane scrollPane = new JScrollPane(ordersFrame);
        JButton ordersBack = new JButton("Back");
        ordersBack.setFont(labelFont);
        ordersBack.addActionListener(listener);
        ordersFrame.add(ordersBack);
        this.add(scrollPane, "orders");
    }

    
}