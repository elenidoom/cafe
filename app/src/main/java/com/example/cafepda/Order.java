package com.example.cafepda;

import java.util.ArrayList;

public class Order {

    private double total;
    private ArrayList<Product> products;
    private String tableID;



    public Order() {

        total = 0.0;
        products = new ArrayList<>();
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public double getTotal() {
        for(Product product : products){
            total += product.getPrice();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return "Order{" +
                "total=" + getTotal() +
                ", products=" + products +
                '}';
    }
}
