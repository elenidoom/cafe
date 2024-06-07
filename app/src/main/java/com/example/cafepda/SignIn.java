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

import com.google.android.material.snackbar.Snackbar;

/**
 * Activity για τη δημιουργία νέου σερβιτόρου και προσθήκη των στοιχείων του στη βάση.
 */
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
        objNameSignIn=findViewById(R.id.name_sign_in);
    }

    /**
     * Μέθοδος που εκτελείται όταν πατηθεί το κουμπί για δημιουργία νέου σερβιτόρου.
     * Δημιουργείται και προστίθεται στη βάση δεδομένων μας.
     */
    public void newWaiter(View view){
        db = new DbHandler(this,null,null,1);
        String name=objNameSignIn.getText().toString();
        String pass=objPasswordSignIn.getText().toString();
        if(db.userNameExists(name)){
            Snackbar.make(view,  "Username exists, please choose another.", Snackbar.LENGTH_LONG).show();
        }
        else {
            db.addWaiter(name,Integer.parseInt(pass));
            objPasswordSignIn.setText("");
            objNameSignIn.setText("");
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

    }
}