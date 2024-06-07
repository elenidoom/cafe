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

import java.util.HashMap;

/**
 * Στο συγκεκριμένο Activity ο αντίστοιχος σεβιτόρος διαλέγει μέσω του recyclerView ποιά προϊόντα και σε τί
 * ποσότητα θέλει να προσθέσει στην εκάστοτε παραγγελία, και στέλνει τα στοιχεία της στην παραγγελία .
 */
public class MenuActivity extends AppCompatActivity implements ProductAdapter.OnAddButtonClickListener{
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter<ProductAdapter.ViewHolder> adapter;
    HashMap<Product,Integer> products;// το Hashmap αποθηκεύει το κάθε προϊόν της παραγγελίας ως key με την ποσότητα που έχει επιλεχθεί   ως value.
    TextView finalOrder;
    TextView tableOrder;
    Order order= new Order();
    int tableNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        tableOrder = findViewById(R.id.tableNameTextView);
        products = new HashMap<>();

        //παίρνουμε το νούμερο του τραπεζιού απο το Intent
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            tableNumber = (int) extras.get("tableID");
            tableOrder.setText("Table " + tableNumber);
            order.setTableID(tableNumber);
        }

        recyclerView = findViewById(R.id.recycler_view);
        finalOrder = findViewById(R.id.orderText);

        //Set the layout of the items in the RecyclerView
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ProductAdapter(products,this);
        recyclerView.setAdapter(adapter);

        finalOrder.setText("");
    }

    /**
     * Μέθοδος που εκτελείται όταν πατηθεί το  κουμπί add στη κάθε κάρτα του recyclerView
     * και ενημερώνει τα στοιχεία της παραγγελίας.
     */
    @Override
    public void onAddButtonClicked(Product product, int quantity) {
        order.addProduct(product,quantity);

        Toast.makeText(this, quantity+" x "+product.getName() + " added to order", Toast.LENGTH_SHORT).show();

        //φτιάχνουμε ενα StringBuilder που θα περιέχει τα προϊόντα της παραγγελίας, τη ποσότητα τους και το σύνολο της παραγγελίας.
        StringBuilder orderList = new StringBuilder();

        for (Product p : order.getProducts().keySet()) {
            int q = order.getProducts().get(p);
            if (q!=0){
                orderList.append(q).append(" x ").append(p.getName()).append("\n");
            }
        }
        orderList.append("\n").append("Total: ").append(order.getTotal()).append(" €");
        finalOrder.setText(orderList);
    }

    /**
     * Μέθοδος που εκτελείται όταν θέλουμε να στείλουμε τη παραγγελία
     * και ανοίγει Intent που  μεταφέρει στο TablesActivity τα στοιχεία της παραγγελίας.
     */
    public void TablesActivity(View view){
        if (order.getProducts().size()==0){
            Toast.makeText(this, "Please add items to order", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent returnData = new Intent();
        returnData.putExtra("order",order);
        setResult(RESULT_OK,returnData);
        finish();
    }


}