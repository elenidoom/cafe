package com.example.cafepda;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TablesActivity extends AppCompatActivity {

    TextView objTextViewNameNewScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tables);

        objTextViewNameNewScreen = (TextView) findViewById(R.id.textViewName);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            //Retrieve data passed in the Intent
            CharSequence userText = extras.getCharSequence("savedUserText");

            //For debugging: print in the Logact (Debug level)
            Log.d("TablesActivity.java",userText.toString());

            objTextViewNameNewScreen.setText("Hello " + userText + ", your shift just started! Place your orders!");

        }

    }

    public void MenuActivity(View view){
        Intent i = new Intent(this, MenuActivity.class);

        startActivity(i);

    }

}