import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.awt.FlowLayout;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.SwingConstants;

import java.awt.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerService extends JPanel{
    private JTextField email;
    private JTextField ticketContents;
    private JFrame ticketBody;
    private JLabel emailID;
    private JButton submit;
    private String formatting = " says ";
    private String formatting2 = "\n----End Ticket----\n";
    
        public CustomerService() {
        ticketBody = new JFrame();
        ticketBody.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        ticketContents.setVisible(true);
        emailID.setVisible(true);
        email.setVisible(true);
        
        /*FileWriter filewriter = new FileWriter(ticketFile);
        email.write(filewriter);
        ticketContents.write(filewriter);
        filewriter.close();*/
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    saveToFile("tickets.txt",ticketContents);
                }
                catch (Exception ex) {
                    Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
        });
        
        }
        
        void saveToFile(String filename, JTextField textField) throws Exception{
            FileOutputStream out = new FileOutputStream(filename, true);
            out.write(email.getText().getBytes());
            out.write(formatting.getBytes());
            out.write(ticketContents.getText().getBytes());
            out.write(formatting2.getBytes());
        }
        
    
}
