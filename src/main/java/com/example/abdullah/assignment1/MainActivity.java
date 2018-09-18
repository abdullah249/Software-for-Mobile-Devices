package com.example.abdullah.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v)
    {
        Intent i=new Intent(this,Relative_signout.class);
        startActivity(i);

    }
    public void onclick(View v)
    {
        Intent i=new Intent(this , Constraint.class);
        startActivity(i);
    }



}
