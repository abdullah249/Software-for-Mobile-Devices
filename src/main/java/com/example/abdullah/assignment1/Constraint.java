package com.example.abdullah.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Constraint extends AppCompatActivity {
        EditText email;
        EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);
        addListenerOnButton();
    }
    Button btnDisplay;
    RadioButton radioButton;

    public void addListenerOnButton() {

        btnDisplay = (Button) findViewById(R.id.button);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                radioButton = (RadioButton) findViewById(R.id.radioButton3);
                if(null!=radioButton) {
                    Toast.makeText(Constraint.this, "asd", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Constraint.this, "User shall continue if checks terms and condition", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
