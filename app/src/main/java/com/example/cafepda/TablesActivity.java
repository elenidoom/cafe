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

import java.util.Objects;

public class TablesActivity extends AppCompatActivity {

    TextView objTextViewNameNewScreen;

    TextView table1Status;
    TextView table2Status;
    TextView table3Status;
    TextView table4Status;
    TextView table5Status;
    TextView table6Status;





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

        objTextViewNameNewScreen = (TextView) findViewById(R.id.textViewName);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            //Retrieve data passed in the Intent
            CharSequence userText = extras.getCharSequence("products");


            //For debugging: print in the Logact (Debug level)
            //Log.d("TablesActivity.java",userText.toString());

            objTextViewNameNewScreen.setText(userText);

        }

    }

    public void MenuActivity(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        int id = view.getId();
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5 && resultCode == RESULT_OK) {
            Order o = (Order) Objects.requireNonNull(data.getExtras()).get("order");
            int id = o.getTableID();
            if(id==1){
                table1Status.setText("occupied");
            } else if (id==2) {
                table2Status.setText("occupied");
            } else if (id==3) {
                table3Status.setText("occupied");
            } else if (id==4) {
                table4Status.setText("occupied");
            } else if (id==5) {
                table5Status.setText("occupied");
            } else if (id==6) {
                table6Status.setText("occupied");
            }
        }
    }

}