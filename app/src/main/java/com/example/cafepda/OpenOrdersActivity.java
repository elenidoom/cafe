package com.example.cafepda;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Το συγκεκριμένο Activity  διαχειρίζεται τις ανοιχτές παραγγελίες που έχουμε
 * και τις προβάλλει μέσω ενός RecyclerView.
 */
public class OpenOrdersActivity extends AppCompatActivity implements OpenOrdersAdapter.OnPayButtonClickListener {
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

    /**
     * Μέθοδος που εκτελείται όταν
     * πατηθεί το Pay Button του παραγγελίας, και επιστρέφει μέσω intent
     * στο TablesActivity μαζί με τα δεδομένα.
     * @param order η παραγγελία που θέλουμε να κλείσει.
     */
    @Override
    public void onPayButtonClicked(Order order) {
        Intent intent = new Intent();
        intent.putExtra("orderToBeClosed",order);
        setResult(RESULT_OK,intent);
        finish();
    }
}