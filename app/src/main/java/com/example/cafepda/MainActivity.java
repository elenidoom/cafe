package com.example.cafepda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText objEditTextPassword;
    DbHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        objEditTextPassword = findViewById(R.id.passwordLabel);
        db = new DbHandler(this,null,null,1);

        if (savedInstanceState != null){
            //Retrieve data from the Bundle (other methods include getInt(), getBoolean() etc)
            CharSequence userText = savedInstanceState.getCharSequence("savedUserText");
            CharSequence displayText = savedInstanceState.getCharSequence("savedDisplayText");

            //Restore the dynamic state of the UI
            objEditTextPassword.setText(userText);
        }
        else{
            //Initialize the UI
            objEditTextPassword.setText("");
            objEditTextPassword.setHint("PIN");
    }}

    public void SignIn(View view){
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);

    }

    public void TablesActivity(View view){
        Intent i = new Intent(this, TablesActivity.class);
        String userText = String.valueOf(objEditTextPassword.getText());


        if (userText.isEmpty())
        {
            Snackbar.make(view, "Please enter you Code name before starting your shift.", Snackbar.LENGTH_LONG)
                    .show();
        }
        else{
            String username = db.findWaiter(Integer.parseInt(userText));
            if (Objects.equals(username, "not found")) {
                Snackbar.make(view, "Waiter not found.", Snackbar.LENGTH_LONG)
                        .show();
            } else{
                i.putExtra("savedUserText", username);
                startActivity(i);
            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save data to the Bundle (other methods include putInt(), putBoolean() etc)
        CharSequence userText = objEditTextPassword.getText();
        outState.putCharSequence("savedUserText", userText);


    }
}