import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.FlowLayout;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.SwingConstants;

import java.awt.*;
import java.util.*;

public class CustomerService extends JPanel{
    private JTextField email;
    private JTextField ticketContents;
    private JFrame ticketBody;
    private JLabel emailID;
    private JButton submit;
    private String file = "C: \ticket.txt";
    
        public CustomerService() throws IOException{
        ticketBody = new JFrame();
        ticketBody.setTitle("Submit a Customer Service Ticket");
        ticketBody.setLayout(new FlowLayout());
        emailID = new JLabel("Email:", SwingConstants.LEFT);
        email = new JTextField();
        ticketContents = new JTextField();
        ticketContents.setLayout(new FlowLayout());
        email.setText("Example:person@email.com");
       
        
        ticketBody.setSize(300, 500);
        ticketContents.setPreferredSize(new Dimension(175,275));
        
        String ticketFile = "C: \ticket.txt"; //File name can be altered to appropriate place
        
        
        
        submit = new JButton("Submit Ticket");
        add(submit,BorderLayout.PAGE_END);
        
        
        
        ticketBody.add(emailID);
        ticketBody.add(email);
        ticketBody.add(ticketContents);
        ticketBody.add(submit,BorderLayout.PAGE_END);
        ticketBody.setVisible(true);
        ticketBody.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticketContents.setVisible(true);
        emailID.setVisible(true);
        email.setVisible(true);
        
        /*FileWriter filewriter = new FileWriter(ticketFile);
        email.write(filewriter);
        ticketContents.write(filewriter);
        filewriter.close();*/
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                
            }
            
        });
        
        }
       /* public static void main(String[] args) throws IOException {
                CustomerService c1 = new CustomerService();
            }*/
    
}
