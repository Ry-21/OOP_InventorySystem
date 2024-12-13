package main;

import operation.*;
import products.*;
import java.util.Scanner;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int choice = 0; // welcome screen
        while(true){
            System.out.println("1) Admin\n2) Cashier");
            System.out.println("\nChoose number (0 = Exit): ");
            choice = sc.nextInt();
            if(choice == 0) break;
            else if(choice == 1) //admin
                break;
            else if(choice == 2){ //cashier
                Cashier cashier = new Cashier();
                operation.Cashier();
                continue;
            }
            else System.out.println("Invalid choice");
        }
    }
}