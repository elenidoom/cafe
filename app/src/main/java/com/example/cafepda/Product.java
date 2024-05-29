package com.example.cafepda;

import androidx.annotation.NonNull;

public class Product {
    private String name;

    private double price;


    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return (float) price;
    }



    @NonNull
    @Override
    public String toString() {
        return "x"+name;
    }
}
