package com.marvedie.servicesmarketapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.design.widget.TabLayout;


public class HireActivity extends AppCompatActivity {

    //create Tag
    private static final String TAG = "HireActivity";
    //declare SectionsPageAdapter
    private SectionsPageAdapter mSectionsPageAdapter;

    //declare ViewPager
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire);
        Log.d(TAG, "onCreate: starting,");

        //declare sections adapter
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        //Set up the ViewPager with the sections adapter
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        //declare TabLayout Object
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    //method to create sections page adapter and add fragments to it and give titles
    private void setupViewPager (ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "TAB1");
        adapter.addFragment(new Tab2Fragment(), "TAB2");
        adapter.addFragment(new Tab3Fragment(), "TAB3");

        //Parse adapter to the viewPager
        viewPager.setAdapter(adapter);
    }

}

