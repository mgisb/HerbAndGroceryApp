///This is just a preliminary version
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Cart extends JFrame {
    private JList leftSide;
    private JList rightSide;
    
    private JButton addItem;
    private JButton getTotal;
    private JLabel totalPrice;
    
    public Cart(){
        super("Cart");
        setLayout(new FlowLayout());
        ArrayList<String> productList = new ArrayList<String>();
        productList.add("Apples");
        productList.add("Bananas");
        productList.add("Milk");
        productList.add("Bread");
        productList.add("Cheese");
        productList.add("Eggs");
        productList.add("Tomatoes");
        productList.add("Potatoes");
        productList.add("Onions");
        
        leftSide = new JList(productList.toArray());
        leftSide.setVisibleRowCount(5);
        leftSide.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(leftSide));
        
        addItem = new JButton("Add Item");
        addItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int size = rightSide.getModel().getSize();
                Set objects = new LinkedHashSet();
                
                for(int i =0;i<size;i++){
                    objects.add(rightSide.getModel().getElementAt(i));
                }
                objects.addAll(Arrays.asList(leftSide.getSelectedValues()));
                rightSide.setListData(objects.toArray());
            }
        });
        add(addItem);
        
        rightSide = new JList();
        rightSide.setVisibleRowCount(3);
        rightSide.setFixedCellHeight(22);
        rightSide.setFixedCellWidth(50);
        add(new JScrollPane(rightSide));
        
        getTotal = new JButton("Calculate Total");
        getTotal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                int size = rightSide.getModel().getSize();
                double totalCost = 0.0;
                for(int i=0;i<size;i++){
                    Object obj =leftSide.getModel().getElementAt(i);
                    ProductItem p = (ProductItem) obj;
                    totalCost += p.getPrice();
                }
                getTotal.setText("Order Total: " + "$" + totalCost);
            }
        }
        );
        add(getTotal);
        totalPrice = new JLabel("Order Total : " );
        add(totalPrice);
          
    }
    public static void main(String[] args){
            //test Cart
           Cart c1 = new Cart();
           c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           c1.setSize(300,300);
           c1.setVisible(true);
        }
}

