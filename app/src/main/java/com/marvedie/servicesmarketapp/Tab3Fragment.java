package com.marvedie.servicesmarketapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Tab3Fragment extends Fragment {

    private static final String TAG = "Tab3Fragment";
    //Declare our buton
    private Button btnTEST;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab3_fragment,container,false);
        //Declare button on create
        btnTEST = view.findViewById(R.id.btnTest3);

        //create button on clicklistener
        btnTEST.setOnClickListener((View.OnClickListener) view); {

            Toast.makeText(getActivity(),"Testing button3", Toast.LENGTH_SHORT).show();

        }

        return view;
    }
}

