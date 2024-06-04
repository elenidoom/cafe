package com.example.cafepda;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Objects;

public class TablesActivity extends AppCompatActivity {

    TextView objTextViewNameNewScreen;
    TextView table1Status;
    TextView table2Status;
    TextView table3Status;
    TextView table4Status;
    TextView table5Status;
    TextView table6Status;
    TextView totalIncome;

    ArrayList<Order> openOrders = new ArrayList<>();
    double total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tables);
        table1Status = (TextView) findViewById(R.id.textseated1);
        table2Status = (TextView) findViewById(R.id.textseated2);
        table3Status = (TextView) findViewById(R.id.textseated3);
        table4Status = (TextView) findViewById(R.id.textseated4);
        table5Status = (TextView) findViewById(R.id.textseated5);
        table6Status = (TextView) findViewById(R.id.textseated6);
        totalIncome = (TextView) findViewById(R.id.totalTextView);

        objTextViewNameNewScreen = (TextView) findViewById(R.id.textViewName);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            //Retrieve data passed in the Intent
            CharSequence userText = extras.getCharSequence("savedUserText");
            objTextViewNameNewScreen.setText(userText);
        }

    }

    public void MenuActivity(View view){

        int id = view.getId();
        if (    (id == R.id.btable1 && table1Status.getText().equals("occupied")) ||
                (id == R.id.btable2 && table2Status.getText().equals("occupied")) ||
                (id == R.id.btable3 && table3Status.getText().equals("occupied")) ||
                (id == R.id.btable4 && table4Status.getText().equals("occupied")) ||
                (id == R.id.btable5 && table5Status.getText().equals("occupied")) ||
                (id == R.id.btable6 && table6Status.getText().equals("occupied"))  ){
            Snackbar.make(view, "Table is occupied", Snackbar.LENGTH_LONG).show();

        }
        else{
            Intent intent = new Intent(this, MenuActivity.class);
            if (id == R.id.btable1) {
                intent.putExtra("tableID", 1);
            }
            else if (id == R.id.btable2) {
                intent.putExtra("tableID", 2);
            } else if (id == R.id.btable3) {
                intent.putExtra("tableID", 3);
            } else if (id == R.id.btable4) {
                intent.putExtra("tableID", 4);
            } else if (id == R.id.btable5) {
                intent.putExtra("tableID", 5);
            } else if (id == R.id.btable6) {
                intent.putExtra("tableID", 6);
            }
            startActivityForResult(intent,5);
        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 5) {
                Order o = (Order) Objects.requireNonNull(data.getExtras()).get("order");
                openOrders.add(o);
                int id = o.getTableID();
                if (id == 1) {
                    table1Status.setText("occupied");
                } else if (id == 2) {
                    table2Status.setText("occupied");
                } else if (id == 3) {
                    table3Status.setText("occupied");
                } else if (id == 4) {
                    table4Status.setText("occupied");
                } else if (id == 5) {
                    table5Status.setText("occupied");
                } else if (id == 6) {
                    table6Status.setText("occupied");
                }

            } else if (requestCode == 6) {
                Order orderToBeClosed = (Order) Objects.requireNonNull(data.getExtras()).get("orderToBeClosed");
                assert orderToBeClosed != null;
                total += orderToBeClosed.getTotal();
                totalIncome.setText(total+" €");
                for (int i = 0; i < openOrders.size(); i++) {
                    if (openOrders.get(i).getTableID() == orderToBeClosed.getTableID()) {
                        openOrders.remove(i);
                        break;
                    }
                }
                int id = orderToBeClosed.getTableID();
                if (id == 1) {
                    table1Status.setText("empty");
                } else if (id == 2) {
                    table2Status.setText("empty");
                } else if (id == 3) {
                    table3Status.setText("empty");
                } else if (id == 4) {
                    table4Status.setText("empty");
                } else if (id == 5) {
                    table5Status.setText("empty");
                } else if (id == 6) {
                    table6Status.setText("empty");
                }
            }
        }
    }



    public void openOrdersActivity(View view){
        if (openOrders.isEmpty()){
            Snackbar.make(view,  "no open orders yet.", Snackbar.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(this, OpenOrdersActivity.class);
            intent.putExtra("openOrders", openOrders);
            startActivityForResult(intent,6);
        }

    }

}