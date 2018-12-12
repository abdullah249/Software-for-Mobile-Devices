package com.example.abdullah.assignment7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements IloginView{
EditText email,password;

    IloginPresenter iloginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        iloginPresenter=new loginPresenter(this);
        email= (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText5);
        String userEmail ,userPassword;

        userEmail = String.valueOf(email.getText());
        userPassword = String.valueOf(password.getText());

        iloginPresenter.onLogin(userEmail,userPassword);


    }


    @Override
    public void mloginResult(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}
