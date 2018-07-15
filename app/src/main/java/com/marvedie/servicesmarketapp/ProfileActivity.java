package com.marvedie.servicesmarketapp;
/*
By
Marvin Eddie Mugendi
Email: marvedie254@gmail.com
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {


    private FirebaseAuth firebaseAuth;
    //views
    private TextView textViewUserEmail;
    private Button buttonLogout;
    private Button buttonHire;
    private Button buttonWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //instantiate firebase object
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();


        textViewUserEmail = findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Welcome"  +   user.getEmail());

        buttonLogout = findViewById(R.id.buttonLogout);
        buttonHire = findViewById(R.id.btnHire);
        buttonWork = findViewById(R.id.btnWork);

        buttonLogout.setOnClickListener(this);
        buttonWork.setOnClickListener(this);
        buttonHire.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //using switch
        switch (view.getId()) {
            case R.id.buttonLogout:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case  R.id.btnHire:
                finish();
                startActivity(new Intent(this, HireActivity.class));
                break;
            case R.id.btnWork:
                finish();
                startActivity(new Intent(this, WorkActivity.class));
        }
    }
}
