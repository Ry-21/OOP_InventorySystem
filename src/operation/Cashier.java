package operation;

import products.Product;
import java.util.Scanner;

public class Cashier extends Operations{
    private Scanner sc1 = new Scanner(System.in);
    private String in = "";
    private String modelKey = "";
    private int qty = 0;
    private Product tempProduct;
    private double countPrice = 0.0;
    
    public Cashier(){
        while(true){
            System.out.println("Model<space>Qty(F = finish): ");
            in = sc1.nextLine();
            if(in.compareToIgnoreCase("F") == 0)
                break;

            modelKey = in.substring(0, in.indexOf(' ')-1); //before space
            qty = Integer.parseInt(in.substring(in.indexOf(' ')-1, in.length()));//after space
            tempProduct = search(modelKey);
            if(tempProduct == null ){
                System.out.println("Product not found");
            }
            else{
                tempProduct.setCountStock(tempProduct.getCountStock() - qty);
                setProductStatus(tempProduct);
                countPrice += (tempProduct.getPrice() * qty);
                totalSales();
            }
        }
        clear();
        System.out.println("Total Price: "+countPrice);
        System.out.println();
    }
}