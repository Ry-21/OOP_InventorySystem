package operation;

import products.*;
import java.util.Scanner;

public class Admin extends Operations{
    private Scanner sc2 = new Scanner(System.in);
    private int choice = 0;
    private Product tempProduct;
    
    public Admin() {
        tempProduct = new Product();
        System.out.println("Options:");
        System.out.println("1) ADD PRODUCT");
        System.out.println("2) SEARCH PRODUCT");
        System.out.println("3) EDIT PRODUCT");
        System.out.println("4) REMOVE PRODUCT");
        System.out.println("5) DISPLAY INVENTORY");
        System.out.println("6) Quit");
        System.out.println("Choose number: ");
        choice = sc2.nextInt();

        switch(choice){
            case 1: 
                setAProduct(tempProduct);
                add(tempProduct);
                notifyLowStock();
                totalProduct();
                break;
            case 2: 
                break;
            case 3: 
                if(searchAProduct() == 1){
                    System.out.println("Set new parameters:");
                    setAProduct(tempProduct);
                    edit(tempProduct.getModel(), tempProduct);
                }
                break;
            case 4: 
                break; // USE METHODS FROM OPERATIONS.JAVA
            case 5: 
                
                break;
            case 6: break;
            default:
        }
        System.out.println("");
        System.out.println("");
    }
    
    //input a product
    public void setAProduct(Product tempProduct){
        System.out.print("Brand: ");
        tempProduct.setBrand(sc2.nextLine());
        System.out.print("Model: ");
        tempProduct.setModel(sc2.nextLine());
        System.out.print("Price: ");
        tempProduct.setPrice(sc2.nextInt());
        System.out.print("Trace No.: ");
        tempProduct.setTraceNum(sc2.nextInt());
        System.out.print("Stock Qty: ");
        tempProduct.setCountStock(sc2.nextInt());
        setProductStatus(tempProduct);
    }
    
    public int searchAProduct(){
        while(true){
            System.out.println("Search model: ");
            if(search(sc2.nextLine()) == null){
                System.out.println("Product not found");
                continue;
            }
            else{
                return 1;
            }
        }
    }
    
    public void displayProducts() {
        System.out.println("Display which product: ");
    }
}