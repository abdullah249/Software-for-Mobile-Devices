package com.example.abdullah.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread td= new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                finally
                {
                    Intent it= new Intent(Splash.this , MainActivity.class);
                    startActivity(it);
                }
            }
        }; td.start();

    }

}

