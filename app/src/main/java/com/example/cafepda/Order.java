package com.example.cafepda;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Order implements Serializable {

    private double total;
    private HashMap<Product,Integer> products;
    private int tableID;

    public Order(){
        products = new HashMap<>();
        total = 0;
    }
    public Order(int tableID, HashMap<Product,Integer> products,double total) {
        this.products = products;
        this.tableID = tableID;
        this.total = total;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }
    public void addProduct(Product product,int quantity){
        if(products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);

        }
        else{
            products.put(product,quantity);
        }
        total += product.getPrice() * quantity;
    }

    public double getTotal() {
        return total;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product p : products.keySet()) {
            sb.append(products.get(p)).append(" x ").append(p.getName()).append("\n");
        }
        sb.append("Total: ").append(total).append("€");
        return sb.toString();
    }
}
