package com.example.cafepda;

import java.util.ArrayList;

public class Order {

    private double total;
    private ArrayList<Product> products;



    public Order() {

        total = 0.0;
        products = new ArrayList<>();
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
}
