package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineStore {

static HashMap<String, Product> inventory = new HashMap<String, Product>();

public static void main(String[] args) {
//    Scanner newScanner = new Scanner(System.in);
//    System.out.println("Welcome! \nPlease select one of the options below:");
//    System.out.println("()");

//    try {
//
//        BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/products.csv")); // insert reader to read file
//
//        String input = buffReader.readLine();
//        while ((input = buffReader.readLine()) != null) {
//            String[] details = input.split("\\|"); // split using delimiter to create array
//            String sku = details[0];
//            String name = details[1];
//            double price = Double.parseDouble(details[2]);
//            String department = details[3];
//            Product p = new Product(sku, name, price, department); // use declared values to create object
//            //SKU|Product Name|Price|Department
//
//
//            if (name != null){     // use loop to add all values to HashMap
//                inventory.put("name", p);
//                for (Map.Entry<String, Product> value : inventory.entrySet()) {
//                    System.out.println(value.getValue());
//                    // System.out.println(value.getKey());
//                    //System.out.println(inventory.get("Desktop PC Computer Intel Core i5"));
//                    //System.out.println("id:"+value.get() );
//                    break;
//            }
//            } else {
//                System.out.println("Invalid input.");
//            }
//        }
//
//        buffReader.close();              // close BufferedReader
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }


//
//    while(true) {                                        // loop to search as many times as needed
//
//                Scanner myScanner = new Scanner(System.in);
//                System.out.println("What item # are you interested in?");       //prompt user for input
//
//                String name = myScanner.nextLine();
//                Product matchedProduct = inventory.get(name);                     //assign key used for search to variable
//                if (matchedProduct == null) {                                   //condition for nonexistent key
//                    System.out.println("We don't carry that product");
//                    return;
//                }
//                System.out.printf("We carry a %s and the price is $%.2f", matchedProduct.getName(), matchedProduct.getPrice());
//
//
//                Scanner scan = new Scanner(System.in);
//                System.out.println("\nDo you want to search again?");              //prompt user to check if search should run again
//                String answer = scan.nextLine();
//                if (answer.equalsIgnoreCase("yes")) {
//                    continue;
//                } else if (answer.equalsIgnoreCase("no")) {
//                    System.exit(0);
//                } else {
//                    System.out.println("Invalid response. Answer yes or no.");
//                }
//
//            }

        }

    public String displayProducts(){
        try {

            BufferedReader buffReader = new BufferedReader(new FileReader("src/main/resources/products.csv")); // insert reader to read file

            String input = buffReader.readLine();
            while ((input = buffReader.readLine()) != null) {
                String[] details = input.split("\\|"); // split using delimiter to create array
                String sku = details[0];
                String name = details[1];
                double price = Double.parseDouble(details[2]);
                String department = details[3];
                Product p = new Product(sku, name, price, department); // use declared values to create object
                //SKU|Product Name|Price|Department


                if (name != null){     // use loop to add all values to HashMap
                    inventory.put("name", p);
                    for (Map.Entry<String, Product> value : inventory.entrySet()) {
                        System.out.println(value.getValue());
                        // System.out.println(value.getKey());
                        //System.out.println(inventory.get("Desktop PC Computer Intel Core i5"));
                        //System.out.println("id:"+value.get() );
                        break;
                    }
                } else {
                    System.out.println("Invalid input.");
                }
            }

            buffReader.close();              // close BufferedReader

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }



