package com.example.cafepda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class MenuActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter<ProductAdapter.ViewHolder> adapter;
    Order order = new Order();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        recyclerView = findViewById(R.id.recycler_view);

        //Set the layout of the items in the RecyclerView
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ProductAdapter();
        recyclerView.setAdapter(adapter);

    }
    public void sendOrder(View view){
        Intent i = new Intent(this, OrderAccount.class);
        startActivity(i);

    }

    public void TablesActivity(View view){
        Intent i = new Intent(this, TablesActivity.class);

        startActivity(i);
        Snackbar.make(view, "The order has been sent successfully", Snackbar.LENGTH_LONG)
                .show();

    }
}