package com.example.abdullah.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class logout extends AppCompatActivity {
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
        setContentView(R.layout.activity_logout);
        try {
            mAuth.signOut();
            updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   void updateUI()
   {
       Intent i=new Intent(getApplicationContext(),MainActivity.class);
       startActivity(i);
   }

}



