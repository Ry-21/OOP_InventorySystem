package operation;

import products.Product;
import java.util.Scanner;

public class Cashier extends Operations{
    private Scanner sc1 = new Scanner(System.in);
    private String in = "";
    private String modelKey = "";
    private int qty = 0;
    private Product temp;
    private double countPrice = 0.0;
    public Cashier(){
        while(true){
            System.out.println("Model<space>Qty(F = finish): ");
            in = sc1.nextLine();
            if(in.compareToIgnoreCase("F") == 0)
                break;

            modelKey = in.substring(0, indexOf(' ')-1); //before space
            qty = Integer.parseInt(substring(indexOf(' ')-1, length(in)));//after space
            temp = search(modelKey);
            if(temp == null ){
                System.out.println("Product not found");
            }
            else{
                temp.countStock -= qty;
                setProductStatus(temp);
                countPrice += (temp.price * qty);
                totalSales();
            }
        }
        clear();
        System.out.println("Total Price: "+countPrice);
        System.out.println();
    }
}