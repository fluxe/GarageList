package com.example.diegonarvaez.garagelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by diegonarvaez on 24/09/16.
 */


public class GarageAdapter extends ArrayAdapter<Garage>{

    public static class ViewHolder{
        TextView garageAddress;
        TextView garageDescription;
        ImageView garageIcon;
    }
    public GarageAdapter(Context context, ArrayList<Garage> garages){
        super(context, 0, garages);
    }


    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        // Get the data item for this position
        Garage garage = getItem(position);

        //create a new viewholder
        ViewHolder viewHolder;
        //check if an existing view is being reused, otherwise inflate a new view from custom row layout
        if(convertView == null){

            //if there is no view already then create a new viewholder (with our view references)
            viewHolder= new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.air_list_row,parent,false);

            //Setting up the view holder-referencing to layout elements
            viewHolder.garageAddress = (TextView)convertView.findViewById(R.id.garageAddress2);
            viewHolder.garageDescription = (TextView)convertView.findViewById(R.id.garageDescription2);
            viewHolder.garageIcon = (ImageView)convertView.findViewById(R.id.garageIcon2);

            //use tag to remember our viewholder
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        /*
        //Grab references of views so we can populate them with specific note row data
        TextView garageAddress = (TextView)convertView.findViewById(R.id.garageAddress);
        TextView garageDescription = (TextView)convertView.findViewById(R.id.garageDescription);
        ImageView garageIcon = (ImageView)convertView.findViewById(R.id.garageIcon);
        */

        //Fill each new referenced view with data associated with garage it's referencing
        viewHolder.garageAddress.setText(garage.getAddress());
        viewHolder.garageDescription.setText(garage.getDescription());
        viewHolder.garageIcon.setImageResource(garage.getAssociatedDrawable());

        //return the view modified with the data taken
        return convertView;
    }


}
