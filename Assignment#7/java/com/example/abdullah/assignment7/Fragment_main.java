package com.example.abdullah.assignment7;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class Fragment_main extends AppCompatActivity {

    private ViewPager  viewPager;
    private sectionpageadapter sectionpageadapter;

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
        msec.addFragment(new Explorer(),"Explorer");
        msec.addFragment(new Profile(),"Profile");
        viewPager.setAdapter(msec);
    }

}
