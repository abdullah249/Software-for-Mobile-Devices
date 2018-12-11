package com.example.abdullah.project2;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Thread.sleep;


public class Registration extends AppCompatActivity {
    Button btn;
    EditText name, password, email;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private static final String TAG = "MyActivity";
    TextView reg_email,reg_name,reg_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        btn=findViewById(R.id.btn_reg);

        email = (EditText) findViewById(R.id.editText3);
        name = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText5);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        reg_email=findViewById(R.id.textView3);
        reg_name=findViewById(R.id.textView5);
        reg_password=findViewById(R.id.textView6);

        reg_email.setText(getString(R.string.email));
        reg_name.setText(getString(R.string.name));
        reg_password.setText(getString(R.string.password));


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

               if (!(email.getText().toString().isEmpty() && name.getText().toString().isEmpty() && password.getText().toString().isEmpty())) {
                   mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                           .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {

                                   if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        Users userd = new Users(name.getText().toString(),email.getText().toString());

                                       FirebaseUser userId = FirebaseAuth.getInstance().getCurrentUser();
                                       if(userId!=null) {
                                           String uid = userId.getUid();
                                           mDatabase.child("users").child(uid).setValue(userd).addOnSuccessListener(new OnSuccessListener<Void>() {
                                               @Override
                                               public void onSuccess(Void aVoid) {

                                                   Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();
                                               }
                                           })
                                                   .addOnFailureListener(new OnFailureListener() {
                                                       @Override
                                                       public void onFailure(@NonNull Exception e) {

                                                           Toast.makeText(getApplicationContext(),"Failed setting value to databasse",Toast.LENGTH_LONG).show();
                                                       }
                                                   });
                                           ;
                                       }
                                       Intent i=new Intent(getApplicationContext(),Fragment_main.class);
                                       startActivity(i);
                                   } else
                                       Toast.makeText(getApplicationContext(), "Authentication failed."+email.getText().toString()+password.getText().toString(), Toast.LENGTH_SHORT).show();

                               }
                           });

               }
               else
                   Toast.makeText(getApplicationContext(), "Enter again",Toast.LENGTH_LONG).show();
            }
        });


        }


    }

