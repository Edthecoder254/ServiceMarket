package com.marvedie.servicesmarketapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FreelancerList extends ArrayAdapter<Freelancer> {

        private Activity context;
        private List<Freelancer> freelancerList;

        //constructor to initialise all the values
    public FreelancerList(Activity context, List<Freelancer>freelancerList){
        //call super and pass the context and layout file and freelancer list
        super(context,R.layout.list_layout, freelancerList);
        //Initialise the Variables
        this.context = context;
        this.freelancerList = freelancerList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //create layout inflater object
        LayoutInflater inflater = context.getLayoutInflater();

        //Inflate Our ;ist_View.xml file
        View listViewItem = inflater.inflate(R.layout.list_layout,null, true);

        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewCategory = listViewItem. findViewById(R.id.textViewCategory);

        //Freelancer Particular Position

        Freelancer freelancer = freelancerList.get(position);

        //set values to the textviews
        textViewName.setText(freelancer.getFreelancerName());
        textViewCategory.setText(freelancer.getFreelancerGenre());

        return listViewItem;


    }
}
