import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.util.*;
import java.util.List;

// shopping cart class handles all the displaying of items and creates an order

public class shoppingCart extends JPanel{
    private JLabel frame;
    private JButton orderButton;

    public static JList<String> productList;
    DefaultListModel<String> listModel;

    Random random = new Random();

    public shoppingCart(){
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();

        productList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(productList);
        add(scrollPane, BorderLayout.CENTER);

        productList.setCellRenderer(new CenteredCellRenderer());

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();

            if ("Add to Order".equals(clickedButton.getText())){

                int randomSixDigitNumber = random.nextInt(900000) + 100000;
                
                List<String> contents = retrieveJListContents(productList);
                if (!contents.isEmpty()){
                    listModel.clear();
                    
                    JButton newButton = new JButton("Order");
                    newButton.setText("Order# "+ randomSixDigitNumber);

                    HerbAndGroceryApp.var2.ordersFrame.add(newButton);

                    StringBuilder message = new StringBuilder();

                    JOptionPane.showMessageDialog(frame, "Order# "+randomSixDigitNumber+" Created!");

                    newButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            for (String item : contents) {
                                message.append(item).append("\n");
                                
                            }
                            JOptionPane.showMessageDialog(null, message.toString(), "Ordered Items", JOptionPane.INFORMATION_MESSAGE);

                            message.setLength(0);
                        }
                    });
                }


                    
                }
            }
        };

        orderButton = new JButton("Add to Order");
        add(orderButton,BorderLayout.PAGE_END);
        orderButton.addActionListener(listener);
    }
    // retreive contents from JList
    private static List<String> retrieveJListContents(JList<String> jList) {
        DefaultListModel<String> model = (DefaultListModel<String>) jList.getModel();
        List<String> contents = new java.util.ArrayList<>();
        for (int i = 0; i < model.size(); i++) {
            contents.add(model.getElementAt(i));
        }
        return contents;
    }
    // add product to the shopping cart frame
    public void addProduct(String product) {
        JLabel label = new JLabel(product);
        this.frame.add(label);
        this.frame.revalidate();
        this.frame.repaint();
        System.out.println("Product added to shopping cart: " + product);
    }

    // this helps keep the list centered on the frame
    private static class CenteredCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            return label;
        }
    }


}

