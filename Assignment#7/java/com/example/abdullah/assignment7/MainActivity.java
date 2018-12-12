package com.example.abdullah.assignment7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements IloginView {

    Button btn;
    TextView reg;
    EditText name, password;
    IloginPresenter iloginPresenter;
    static  String cName = "Iqbal@gmail.com";

    static String cPassword = "Kazim";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn_login);

        iloginPresenter=new loginPresenter(MainActivity.this);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                name = (EditText) findViewById(R.id.userName);
                password = (EditText) findViewById(R.id.userPassword);
                String userEmail ,userPassword;
                userEmail = String.valueOf(name.getText());
                userPassword = String.valueOf(password.getText());

                    iloginPresenter.onLogin(userEmail,userPassword);



                            }
        });


        reg=(TextView) findViewById(R.id.text_reg);

        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent i=new Intent(getApplicationContext(),Registration.class);
            startActivity(i);
            }
        });

    }
    public void mloginResult(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }
}
