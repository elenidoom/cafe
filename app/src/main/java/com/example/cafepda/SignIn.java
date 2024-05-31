package com.example.cafepda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignIn extends AppCompatActivity {
    EditText objPasswordSignIn;
    EditText objNameSignIn;

    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        objPasswordSignIn = findViewById(R.id.editTextNumberPassword);
        //db = new DbHandler(this,null,null,1);
        objNameSignIn=findViewById(R.id.name_sign_in);


    }

    public void newWaiter(View view){
        db = new DbHandler(this,null,null,1);
        String name=objNameSignIn.getText().toString();
        String pass=objPasswordSignIn.getText().toString();
        db.addWaiter(name,Integer.parseInt(pass));
        objPasswordSignIn.setText("");
        objNameSignIn.setText("");
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }



}