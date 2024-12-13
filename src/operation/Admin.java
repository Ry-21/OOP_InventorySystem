package operation;

import products.*;
import java.util.Scanner;

public class Admin extends Operations{
    private Scanner sc2 = new Scanner(System.in);
    private int choice = 0;
    private Product temp;
    Admin(){

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
            case 1: setAProduct(temp);
                    add(temp);
                    notifyLowStock();
                    totalPrice();
                    break;
            case 2: 
                    break;
            case 3: if(searchAProduct() == 1){
                        setProduct(temp);
                        edit(temp.model, temp);
                    }
                    
                    break;
            case 4: break; // USE METHODS FROM OPERATIONS.JAVA
            case 5: break;
            case 6: break;
            default:
        }
        System.out.println("");
        System.out.println("");
    }
        //input a product
    public void setAProduct(Product temp){
        System.out.println("Brand: ");
        temp.brand = sc2.nextLine();
        System.out.println("Model: ");
        temp.model = sc2.nextLine();
        System.out.println("Price: ");
        temp.price = sc2.nextDouble();
        System.out.println("Trace No.: ");
        temp.traceNum = sc2.nextInt();
        System.out.println("Stock Qty: ");
        temp.countStock = sc2.nextInt();
        setProductStatus(temp);
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

}