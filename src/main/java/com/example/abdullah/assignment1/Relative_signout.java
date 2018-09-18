package com.example.abdullah.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Relative_signout extends AppCompatActivity {
    RadioButton radioButton;
    Button btnDisplay;

    EditText email;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_signout);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        btnDisplay = (Button) findViewById(R.id.button2);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                radioButton = (RadioButton) findViewById(R.id.radioButton4);
                if(null!=radioButton) {
                    Toast.makeText(Relative_signout.this, "email"+email.getText()+"password"+password.getText(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Relative_signout.this, "User shall continue if checks terms and condition", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
