package com.marvedie.servicesmarketapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSave extends AppCompatActivity {

    //Define Objects
    EditText editTextName;
    Button buttonAdd;
    Spinner spinnerGenres;

    //Constants to put Freelancer id and nam ein new Intent
    public static final String FREELANCER_NAME = "freelancername";
    public static final String FREELANCER_ID = "freelancerid";
    //Create a database reference Object
    DatabaseReference databaseFreelancers;

    ListView listViewFreelancers;

    //define list to store all our Freelancers
    List<Freelancer> freelancerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_save);

        //Instantiate Objects
        editTextName = findViewById(R.id.editTextName);
        buttonAdd = findViewById(R.id.buttonAddFreelancer);
        spinnerGenres = findViewById(R.id.spinnerGenres);
        listViewFreelancers = findViewById(R.id.listViewFreelancers);

        freelancerList = new ArrayList<>();

        //Get the Database Reference
        //NB. Failure to pass parameter under get reference gives reference of root node of your Json tree
        //We need Freelancer node hence we pass parameter Freelancer
        databaseFreelancers = FirebaseDatabase.getInstance().getReference("freelancer");

        //Attach Onclick Listener to the Button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the Add Freelancer Method
                addFreelancer();
            }
        });
        //Event Listener to get selected Artist when user clicks on an artist
        listViewFreelancers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Get selected Artist from the List
                Freelancer freelancer = freelancerList.get(i);

                Intent intent = new Intent(getApplicationContext(),AddServiceActivity.class);

                //Put Freelancer Id and Artist Name in the Intent...Define two Constants
                intent.putExtra(FREELANCER_ID, freelancer.getFreelancerid());
                intent.putExtra(FREELANCER_NAME,freelancer.getFreelancerName());

                startActivity(intent);

            }
        });
    }


    //Override onStart Method
    @Override
    protected void onStart() {
        super.onStart();

        //Attach our value Event listener to our database reference Object

        databaseFreelancers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //this method will be executed everytime we change a value in the database
                //can read value of our database

                // clear Freelancer list if it contains any previous Freelancer.

                freelancerList.clear();

                for(DataSnapshot freelancerSnapshot : dataSnapshot.getChildren()){
                    //use our model class Freelancer
                    Freelancer freelancer = freelancerSnapshot.getValue(Freelancer.class);

                    //Add the Freelancer to FreelancerList
                    freelancerList.add(freelancer);
                }

                //Create an Arrayadapter
                FreelancerList adapter = new FreelancerList(DatabaseSave.this,freelancerList);

                //Attach the adapter to out freelancer ListVew
                listViewFreelancers.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //will be executed if there is an error

            }
        });
    }

    //Define New Method to get Freelancer Name and Other Details
    private void addFreelancer() {

        //Fetch and convert User values to String
        String name = editTextName.getText().toString().trim();
        String genre = spinnerGenres.getSelectedItem().toString();

        //Check if name is filled
        if (!TextUtils.isEmpty(name)) {

            //Cretae a unique Id for freelancers nad store it in a String

            String id = databaseFreelancers.push().getKey();

            //Create a New Freelancer

            Freelancer freelancer = new Freelancer(id,name,genre);

            //Use SetValue Method To store New Value into Firebase Database

            databaseFreelancers.child(id).setValue(freelancer); /*Everytime a freelancer is created
             it will generate a unique id in which it will store the freelancer*/

            Toast.makeText(this, "You have been added to our freelancers Database. Confirm Your details Below", Toast.LENGTH_SHORT).show();

        }else{

            editTextName.setError("Please Enter Name");
            editTextName.requestFocus();
        }



    }
/*Ensure the database Rules have been changed to "True" since default values only allow
  authenticated users to make changes If no authentication has been done on your app*/


}

