package com.example.cafepda;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OpenOrdersActivity extends AppCompatActivity implements OpenOrdersAdapter.OnAddButtonClickListener {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter<OpenOrdersAdapter.ViewHolder> adapter;
    ArrayList<Order> orders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_open_orders);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            orders = (ArrayList<Order>) getIntent().getSerializableExtra("openOrders");
        }


        recyclerView = findViewById(R.id.openOrdersRecycleView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new OpenOrdersAdapter(orders,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAddButtonClicked(Order order) {
        Intent intent = new Intent();
        intent.putExtra("orderToBeClosed",order);
        setResult(RESULT_OK,intent);
        finish();
    }
}