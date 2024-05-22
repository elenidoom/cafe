package com.example.cafepda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText objEditTextName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        objEditTextName = findViewById(R.id.editTextName);

        if (savedInstanceState != null){
            //Retrieve data from the Bundle (other methods include getInt(), getBoolean() etc)
            CharSequence userText = savedInstanceState.getCharSequence("savedUserText");
            CharSequence displayText = savedInstanceState.getCharSequence("savedDisplayText");

            //Restore the dynamic state of the UI
            objEditTextName.setText(userText);
        }
        else{
            //Initialize the UI
            objEditTextName.setText("");
            objEditTextName.setHint("Code Name");
    }}

    public void TablesActivity(View view){
        Intent i = new Intent(this, TablesActivity.class);
        CharSequence userText = objEditTextName.getText();
        i.putExtra("savedUserText", userText);

        startActivity(i);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save data to the Bundle (other methods include putInt(), putBoolean() etc)
        CharSequence userText = objEditTextName.getText();
        outState.putCharSequence("savedUserText", userText);


}






}