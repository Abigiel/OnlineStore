package com.pluralsight;

public class Product {

    private String sku;
    private String name;
    private String department;
    private double price;
    public Product(){
        System.out.println("This is the default constructor!");
    }

    public Product(String sku, String name, double price, String department){ //constractor
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }
    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
       return "SKU: " + getSku()  +" | Name: " + getName() + " | Price: " + getPrice() + " | Department: "+ getDepartment();
    }
}
