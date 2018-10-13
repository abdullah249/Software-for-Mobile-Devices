package com.example.abdullah.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
        EditText upd_name;
        EditText upd_rollno;
        EditText upd_gpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        upd_name=findViewById(R.id.upd_name);
        upd_gpa=findViewById(R.id.upd_gpa);
        upd_rollno=findViewById(R.id.upd_rollno);

        Button btn= findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Student_List.class);

                String name =upd_name.getText().toString();
                float gpa=Float.parseFloat(upd_gpa.getText().toString());

                int rollno=Integer.parseInt(upd_rollno.getText().toString());
                Student user=new Student();
                user.setRollno(rollno);
                user.setGpa(gpa);
                user.setName(name);

                MainActivity.myDatabase.mydao().update(user);

                Toast.makeText(getApplicationContext(),"update....",Toast.LENGTH_SHORT).show();
                
                startActivity(i);

            }
        });

    }
}
