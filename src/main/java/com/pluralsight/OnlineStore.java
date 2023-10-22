package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineStore {
     static HashMap<String, String> inventory = new HashMap<String, String>();

    public static void main(String[] args) {

        int choice;
        char repeat;
        do {
            Scanner newScanner = new Scanner(System.in);
            System.out.println("Welcome! \nPlease select one of the options below: \n 1. Display Products.");
            choice = newScanner.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                default:
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Do you want to continue? Y or N");
            Scanner repeatScanner = new Scanner(System.in);
            repeat = repeatScanner.nextLine().charAt(0);
        }while(repeat=='Y' || repeat=='y');
    }


    public static void displayProducts() {

        StringBuilder result = null;
        String sku, name, department;
        double price;
        BufferedReader buffReader = null;

        try {
             buffReader = new BufferedReader(new FileReader("src/main/resources/products.csv")); // insert reader to read file
             String input;// = buffReader.readLine();

            while ((input = buffReader.readLine()) != null) {

                String[] details = input.split("\\|"); // split using delimiter to create array

                sku = details[0];
                name = details[1];
                price = Double.parseDouble(details[2]);
                department = details[3];

                Product p = new Product(sku, name, price, department);
                //SKU|Product Name|Price|Department

                if ( p.getName() != null) {     // use loop to add all values to HashMap
                    inventory.put(p.getName(), p.toString());// name, sku name price departmn
                    /*for (Map.Entry<String, Product> value : inventory.entrySet()) {
//                        result = new StringBuilder();
//                        result.append("SKU: ").append(value.getValue().getSku());
//                        result.append(" Name: ").append(value.getValue().getName());
//                        result.append(" Price: ").append(value.getValue().getPrice());
//                        result.append(" Department: ").append(value.getValue().getDepartment());
//                        result.append("\n");
*/
                  //  System.out.println(value.getValue());
                    }
                 else {
                    continue;
                    //System.out.println("Invalid input.");
                }

            }

            } catch (IOException e) {
                 e.printStackTrace();
             }


        inventory.forEach((key, value) -> { //lamda expresion at what java version was LE introduced ?
            System.out.println("________________________________________________________________________________");
            System.out.println(value);
            System.out.println("________________________________________________________________________________");
        });
        //return inventory;

    }

}



