package com.example.cafepda;

import java.util.ArrayList;

public class Order {
    private String tableID;
    private float total;
    private ArrayList<Product> products;

    public Order(){}

    public Order(String tableID, float total) {
        this.tableID = tableID;
        this.total = total;
        products = new ArrayList<>();
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
