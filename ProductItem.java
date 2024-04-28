/* ProductItem class that handle each individual product's name, price, quantity inventory
Writers: Brandon, Marlen, Nadim
*/
import java.util.ArrayList;


public class ProductItem{
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

    //Calculates totalCost
    public static double calculateTotalPrice(ArrayList<ProductItem> groceries){
        double totalCost= 0.0;
        for(ProductItem p:groceries){
            totalCost+= (p.price*p.quantity);
        }
        
        return totalCost;
    }
    //change can be positive or negative
    public void updateQuantity(int change){
        this.quantity= quantity + change;
    }
    
    public static int checkAvailability(ProductItem p){
        return p.inventory;
    }

    //allows addition of discount at checkout
    public void addDiscount(String code){
      String discountCode ="20OFF";
        if(code.equals(discountCode)){
                this.price= price*(1-.35);
        }
        else{
            System.out.println("INVALID CODE");
        }
    }
    
}
