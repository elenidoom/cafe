package com.example.cafepda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Order implements Serializable {

    private double total;
    private HashMap<Product,Integer> products;
    private int tableID;



    public Order(int tableID, HashMap<Product,Integer> products,double total) {
        this.products = products;
        this.tableID = tableID;
        this.total = total;

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
}
