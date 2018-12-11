package com.example.abdullah.project2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView reg,signin_email,signin_password,signup;
    EditText name, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn_login);
        mAuth = FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    name = (EditText) findViewById(R.id.userName);
                    password = (EditText) findViewById(R.id.userPassword);
                    String userName ,userPassword;
                    userName = String.valueOf(name.getText());
                    userPassword = String.valueOf(password.getText());
                    mAuth.signInWithEmailAndPassword(userName, userPassword)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        // Log.d(TAG, "signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        //Log.w(TAG, "signInWithEmail:failure", task.getException());
                                        Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }


                                }
                            });




                }
            });


            reg=(TextView) findViewById(R.id.text_reg);

            reg.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i=new Intent(getApplicationContext(),Registration.class);
                    startActivity(i);
                }
            });

            signin_email=findViewById(R.id.textView);
            signin_password=findViewById(R.id.textView2);
            signin_password.setText(getString(R.string.password));
            signin_email.setText(getString(R.string.email));
            signup=findViewById(R.id.text_reg);
            signup.setText(getString(R.string.signup));


        }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

    }

    public void updateUI(FirebaseUser user)
    {
        if(user!=null)
        {
            Intent i=new Intent(getApplicationContext(),Fragment_main.class);
            startActivity(i);
        }
    }
}

