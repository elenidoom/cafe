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
import java.util.HashMap;

public class MenuActivity extends AppCompatActivity implements ProductAdapter.OnAddButtonClickListener{
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter<ProductAdapter.ViewHolder> adapter;
    HashMap<Product,Integer> products;
    TextView finalOrder;
    TextView tableOrder;
    Order order ;
    double total = 0.0;
    int tableNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        tableOrder = findViewById(R.id.tableNameTextView);
        products = new HashMap<>();

        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            tableNumber = (int) extras.get("tableID");
            tableOrder.setText("Table " + tableNumber);
        }

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
    public void onAddButtonClicked(Product product, int quantity) {

        products.put(product,quantity);
        Toast.makeText(this, product.getName() + " added to order", Toast.LENGTH_SHORT).show();

        StringBuilder orderList = new StringBuilder();

        for (Product p : products.keySet()) {
            int q = products.get(p);
            if (q!=0){
                orderList.append(products.get(p)).append(" x ").append(p.getName()).append("\n");
                total+=p.getPrice()*q;
            }
        }
        orderList.append("\n").append("Total: ").append(total).append(" €");
        finalOrder.setText(orderList);
    }

    public void TablesActivity(View view){
        Intent returnData = new Intent();
        order = new Order(tableNumber,products,total);
        returnData.putExtra("order",order);
        setResult(RESULT_OK,returnData);

        finish();

    }
}