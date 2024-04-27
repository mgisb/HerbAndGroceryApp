import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.util.*;

public class shoppingCart extends JPanel{
    private ArrayList<String> products;

    public shoppingCart(){
        products = new ArrayList<>();
        setLayout(new GridLayout(2,2));
        setVisible(true);



    }

    public void addProduct(String product) {
        products.add(product);
        JLabel label = new JLabel(product);
        this.add(label);
        this.revalidate();
        this.repaint();
        System.out.println("Product added to shopping cart: " + product);
    }


}