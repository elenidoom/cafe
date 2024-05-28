package com.example.cafepda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements ProductAdapter.OnAddButtonClickListener{
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter<ProductAdapter.ViewHolder> adapter;
    ArrayList<Product> products;



    TextView finalOrder;
    Order order ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        products = new ArrayList<>();
        order = new Order();

        recyclerView = findViewById(R.id.recycler_view);
        finalOrder = findViewById(R.id.orderText);

        //Set the layout of the items in the RecyclerView
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ProductAdapter(products,this);
        recyclerView.setAdapter(adapter);

        finalOrder.setText(";)");


    }
    @Override
    public void onAddButtonClicked(Product product) {
        order.addProduct(product);
        Toast.makeText(this, product.getName() + " added to order", Toast.LENGTH_SHORT).show();


        finalOrder.setText(order.toString());

    }

    public void sendOrder(View view){
        Intent i = new Intent(this, OrderAccount.class);
        startActivity(i);

    }

    public void TablesActivity(View view){
        Intent i = new Intent(this, TablesActivity.class);
        i.putExtra("products",products);

        startActivity(i);
        Snackbar.make(view, "The order has been sent successfully", Snackbar.LENGTH_LONG)
                .show();

    }
}