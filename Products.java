import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.util.*;

// products class displays all available products, users can select and add them to their cart

public class Products extends JPanel{     
    private JTable table;
    private JButton addtoCart;

    public Products(){
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        setLayout(new BorderLayout());

        model.addColumn("Product Name");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Stock");

        table = new JTable(model);
        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        ArrayList<ProductItem> list = new ArrayList<ProductItem>(){
            {
                add(new ProductItem("Apple",3.5,0,20));
                add(new ProductItem("Milk",4.0,0,5));
                add(new ProductItem("Eggs",5.0,0,12));
                add(new ProductItem("Bread",6.5,0,3));
                add(new ProductItem("Banana", 2.0, 0, 15));
                add(new ProductItem("Cheese", 8.0, 0, 8));
                add(new ProductItem("Yogurt", 3.0, 0, 10));
                add(new ProductItem("Chicken", 10.0, 0, 6));
                add(new ProductItem("Rice", 4.5, 0, 18));
                add(new ProductItem("Pasta", 2.5, 0, 20));
                add(new ProductItem("Tomato", 1.0, 0, 25));
                add(new ProductItem("Potato", 1.5, 0, 30));
                add(new ProductItem("Carrot", 1.2, 0, 22));
                add(new ProductItem("Spinach", 1.8, 0, 15));
                add(new ProductItem("Onion", 1.0, 0, 28));
                add(new ProductItem("Oranges", 2.0, 0, 30));
                add(new ProductItem("Lettuce", 1.5, 0, 20));
                add(new ProductItem("Cucumber", 1.2, 0, 25));
                add(new ProductItem("Watermelon", 5.0, 0, 10));
                add(new ProductItem("Bacon", 7.0, 0, 15));
                
            }
        };

        for (ProductItem item : list) {
            addProduct(item);
        }

        addtoCart = new JButton("Add Item");
        add(addtoCart,BorderLayout.PAGE_END);

        addtoCart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                shoppingCart herb = HerbAndGroceryApp.var;
                String selectedItem = getSelected();
                herb.listModel.addElement(selectedItem);
                System.out.println("Product added to shopping cart: " + selectedItem);
            }
        });

    }

    public String getSelected(){
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String productName = table.getValueAt(selectedRow, 0).toString();
            double price = Double.parseDouble(table.getValueAt(selectedRow, 1).toString());
            int quantity = Integer.parseInt(table.getValueAt(selectedRow, 2).toString());
            int stock = Integer.parseInt(table.getValueAt(selectedRow, 3).toString());
            
            System.out.println("Selected Product: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Stock: " + stock);
            return productName;
        } else {
            System.out.println("No row selected.");
        }
        return null;
    }

    public void addProduct(ProductItem item) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{item.getName(), item.getPrice(), item.getQuantity(), item.getInventory()});
    }

}   
                                      
                                    
/*   public ArrayList<ProductItem> createList(){
        //Need to Add All Products
        ArrayList<ProductItem> list = new ArrayList<ProductItem>(){
            {
                add(new ProductItem("Apple",3.5,0,20));
                add(new ProductItem("Milk",4.0,0,5));
                add(new ProductItem("Eggs",5.0,0,12));
                add(new ProductItem("Bread",6.5,0,3));
            }
            
        };
            return list;
        }
    
    
        public void displayProducts(ArrayList<ProductItem> list){
            //Need help turning this into a GUI for the tab - been trying a long time
            ArrayList<String> pNames = new ArrayList<>();
            Double [] pPrices = new Double[10];
            int size = list.size();
            for(int i=0;i<size;i++){
                pNames.add(list.get(i).getName());
                pPrices[i]=list.get(i).getPrice();
            }
            for(int j=0;j<pNames.size();j++){
                System.out.print(pNames.get(j));
                System.out.print("\t");
                System.out.println(pPrices[j]);
                JLabel label = new JLabel(pNames.get(j));
                label.add(productsPanel);
            }
            
        } */