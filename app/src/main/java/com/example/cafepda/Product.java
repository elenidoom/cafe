package com.example.cafepda;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Αυτή η κλάση αναπαριστά ενα προϊόν που αποτελείται από το όνομα του
 *  και τη τιμή του.
 */
public class Product implements Serializable  {
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
