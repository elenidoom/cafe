package com.example.cafepda;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

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
        return Math.round(total * 100.0) / 100.0;
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
        sb.append("Table ").append(tableID).append("\n");
        for (Product p : products.keySet()) {
            sb.append(products.get(p)).append(" x ").append(p.getName()).append("\n");
        }
        sb.append("Total: ").append(total).append("€");
        return String.valueOf(sb);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(total, order.total) == 0 && tableID == order.tableID && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, products, tableID);
    }
}
