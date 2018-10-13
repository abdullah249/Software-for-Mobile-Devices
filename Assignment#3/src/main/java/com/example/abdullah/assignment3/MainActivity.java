package com.example.abdullah.assignment3;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Srollno;
    EditText Sname;
    EditText Sgpa;
    Button btn;
    public static myAppDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Srollno=(EditText) findViewById(R.id.rn);
        Sname=(EditText) findViewById(R.id.sn);
        Sgpa=(EditText) findViewById(R.id.sg);
        btn=(Button)findViewById(R.id.button);
        myDatabase= Room.databaseBuilder(getApplicationContext(), myAppDatabase.class,"userdb").allowMainThreadQueries().build();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Student_List.class);
                int rollno=Integer.parseInt(Srollno.getText().toString());
                String name=Sname.getText().toString();
                float gpa=Float.parseFloat(Sgpa.getText().toString());
                Student s=new Student();
                s.setName(name);
                s.setGpa(gpa);
                s.setRollno(rollno);
                MainActivity.myDatabase.mydao().adduser(s);
                startActivity(i);
            }
        });
    }



}
