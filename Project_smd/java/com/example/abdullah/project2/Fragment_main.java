package com.example.abdullah.project2;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.RemoteMessage;

public class Fragment_main extends AppCompatActivity {

    private ViewPager  viewPager;
    private sectionpageadapter sectionpageadapter;
    private static String TAG="Fragment_main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
        sectionpageadapter ad=new sectionpageadapter(getSupportFragmentManager());

        viewPager=findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        TabLayout tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);


    }


    private void setupViewPager(ViewPager viewPager)
    {
        sectionpageadapter  msec=new sectionpageadapter(getSupportFragmentManager());
        msec.addFragment(new Explorer(),"");
        msec.addFragment(new Profile(),"");
        viewPager.setAdapter(msec);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.CreatePost:
                startActivity(new Intent(this, CreatePost.class));
                return true;

            case R.id.LanguageChange:
                //startActivity(new Intent(this, l.class));
                return true;

            case R.id.logout:
                 startActivity(new Intent(getApplicationContext(),logout.class));

            default:
                return super.onOptionsItemSelected(item);

        }
        //respond to menu item selection

    }


}
