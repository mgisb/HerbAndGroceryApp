import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class ProductItem extends Products{
    private String name;
    private double price;
    private int quantity;
    private int inventory;
    
    //Constructor
    public ProductItem(String name, double price, int quantity,int inventory){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.inventory=inventory;
        
    }
    
    //Getters and Setters
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getInventory(){
        return inventory;
    }
    
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setQuantity(int count){
        this.quantity=count;
    }
    public void setInventory(int inventory){
        this.inventory=inventory;
    }
    
    public static double calculateTotalPrice(ArrayList<ProductItem> groceries){
        double totalCost= 0.0;
        for(ProductItem p:groceries){
            totalCost+= (p.price*p.quantity);
        }
        
        return totalCost;
    }
    public void updateQuantity(int change){
        this.quantity= quantity + change;
    }
    public static int checkAvailability(ProductItem p){
        return p.quantity;
    }
    public void addDiscount(String code){
      String discountCode ="20OFF";
        if(code.equals(discountCode)){
                this.price= price*(1-discount);
        }
        else{
            System.out.println("INVALID CODE");
        }
    }
    
}
