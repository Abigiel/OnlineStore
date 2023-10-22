package com.pluralsight;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class OnlineStore {
     static HashMap<String, Product> inventory = new HashMap<String, Product>(); // store all products in hashmap
     static ArrayList <Product> cart = new ArrayList<>(); // store cart products in arraylist

    public static void main(String[] args) {
        homeScreenDisplay();                   // display home screen
    }

        public static void homeScreenDisplay() { // method for home screen

            int choice;
            char repeat;
            do {
                Scanner newScanner = new Scanner(System.in);
                System.out.println("Welcome! \nPlease select one of the options below: \n 1. Show All Products. \n 2. Open My Cart \n 3. Exit"); // display options
                choice = newScanner.nextInt();   // accept input for users choice

                switch (choice) {
                    case 1:
                        displayProducts();
                        break;
                    case 2:
                        cartScreen();
                        break;
                    case 3:
                        System.exit(0);                 // exit application
                    default:
                        System.out.println("Incorrect option. Please select 1-3.");
                }

                System.out.println("\n \n");
                System.out.println("Do you want to continue? Y or N");
                Scanner repeatScanner = new Scanner(System.in);
                repeat = repeatScanner.nextLine().charAt(0);

            } while (repeat == 'Y' || repeat == 'y');
        }




    public static void displayProducts() {

        StringBuilder result = null;
        String sku, name, department;
        double price;
        BufferedReader buffReader = null;

        try {
             buffReader = new BufferedReader(new FileReader("src/main/resources/products.csv")); // insert reader to read file
             String input;

            while ((input = buffReader.readLine()) != null) {

                String[] details = input.split("\\|"); // split using delimiter to create array

                sku = details[0];
                name = details[1];
                price = Double.parseDouble(details[2]);
                department = details[3];

                Product p = new Product(sku, name, price, department);

                if ( p.getName() != null) {     // use loop to add all values to HashMap

                    inventory.put(p.getName(), p);  // add products to inventory with names as keys

                    }
                 else {
                    continue;
                }

            }

            } catch (IOException e) {
                 e.printStackTrace();
             }

        System.out.println("List of all available products:");

        inventory.forEach((key, value) -> {

            System.out.println("________________________________________________________________________________");
            System.out.println(value.toString());

        });

        System.out.println("What would you like to do? \n 1. Search a product \n 2. Add a product to cart \n 3. Go Back to Home"); // prompt user for an option
        Scanner newScanner = new Scanner(System.in);
        int answer = newScanner.nextInt();;
        switch (answer){                                     // switch statement for the implementation of the different options
            case 1:
                System.out.print("Please enter the name of the product:");
                Scanner scan = new Scanner(System.in);
                String search = scan.nextLine().trim();
                Product found = inventory.get(search);
                if (found == null){                                    // if statement to check product availability
                    System.out.println("That product is not available.");
                } else{
                    System.out.println(found.getName() + " is available. The price is $" + found.getPrice() + ".");
                }
                break;

            case 2:
                System.out.println("Which product do you want to add to cart?");
                Scanner scan2 = new Scanner(System.in);
                String reply= scan2.nextLine();
                Product added = inventory.get(reply);

                cart.add(added);                  // adding product to arraylist cart
                System.out.println("You have added " + added.getName() + " to cart.");
                break;

            case 3:
                homeScreenDisplay();                            // option to go back
                break;
            default:
                System.out.println("Incorrect option. Please select 1-3.");

        }

    }


    public static void cartScreen(){                                           // method for displaying cart
        if (cart.isEmpty()){                                                  // if statement to check whether it is empty
            System.out.println("This cart is empty.");
        } else {
            for(Product p: cart){
                System.out.println("Your cart items: \n");
                System.out.println("Name: "+ p.getName() + " | Price: "+ p.getPrice());
            }
        }

        System.out.println("\nSelect an option: \n 1. Go to Checkout \n 2. Remove a product from Cart \n 3. Go Back to Home");  // options of where to go from the cart
        Scanner myScanner = new Scanner(System.in);
        int option = myScanner.nextInt();
        switch(option) {
            case 1:
                double total = 0;
                for (Product p : cart) {
                    total = total + p.getPrice();
                }
                System.out.println("The total price is: " + total);
                homeScreenDisplay();
                break;

            case 2:
                System.out.println("What product would you like to remove from cart? ");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                Product unwanted = inventory.get(answer);

                if (!cart.contains(unwanted)) {
                    System.out.println("That item is not found in cart");
                } else {
                    cart.remove(unwanted);
                    System.out.println("You have removed " + unwanted.getName()  + " from cart.");           // // removing product from arraylist cart
                }
                break;

            case 3:
                homeScreenDisplay();   // option to go back to home screen
                break;

            default:
                System.out.println("Incorrect option. Please select 1-3.");
        }

    }

}



