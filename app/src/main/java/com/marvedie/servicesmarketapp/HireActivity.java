package com.marvedie.servicesmarketapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class HireActivity extends AppCompatActivity {
    //Variables
    ListView mListView;
    List<String> mList = new ArrayList<>();
    ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire);

        //Initialise the Variables defined above
        mListView = findViewById(R.id.lvCategories);


        mList.add("Banana");
        mList.add("Cow");mList.add("S.E.O writing");
        mList.add("Goat");mList.add("Graphic Design");
        mList.add("Bicycle");mList.add("What");
        mList.add("Bat");mList.add("When");
        mList.add("Lion");mList.add("How");
        mList.add("IT");mList.add("Now");
        mList.add("Writing");mList.add("Bat");

        //Initialise the Array Adapter
        mAdapter = new ArrayAdapter<>(HireActivity.this, android.R.layout.simple_list_item_1,mList);
        mListView.setAdapter(mAdapter);
    }

}

