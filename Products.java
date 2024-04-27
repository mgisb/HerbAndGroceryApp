import javax.swing.*;
import java.util.*;



public class Products{     
   
    
    public Products(){
        
        
    }
    public ArrayList<ProductItem> createList(){
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
        }
        
    }
    
    public static void main(String[] args){
      Products p1 = new Products();
      ArrayList<ProductItem> plist =  p1.createList();
      p1.displayProducts(plist);
    }
}    
    
    
                                      
                                    
