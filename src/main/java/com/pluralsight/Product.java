package com.pluralsight;

public class Product {

    private String sku;
    private String name;
    private double price;
    private String department;
    public Product(String sku, String name, double price, String department){
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }

    public String getSku() {
        return this.sku;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
    public String getDepartment() {
        return this.department;
    }

    @Override
    public String toString() {
       return "SKU: " + sku +" Name: " + name + " Price: " + price + " Department: "+ department;
    }
}
