package com.example.abdullah.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Student_List extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__list);

        Button btn=findViewById(R.id.upd_button);
        txt=findViewById(R.id.info);
        List<Student> st=MainActivity.myDatabase.mydao().getStudents();

        for(Student s:st)
        {
            float gpa=s.getGpa();
            String name=s.getName();
            float rollno=s.getRollno();
            txt.setText("rollno:"+rollno+"\n"+"name:"+name+"\n"+"gpa"+gpa);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Update.class);
                startActivity(i);
            }
        });
    }
}
