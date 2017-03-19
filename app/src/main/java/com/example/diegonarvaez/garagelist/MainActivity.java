package com.example.diegonarvaez.garagelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;


public class MainActivity extends AppCompatActivity {


    private final int REQUEST_CODE_PLACEPICKER = 1;

    public static final String GARAGE_ID_EXTRA = "com.example.diegonarvaez.garagelist.Garage Identifier";
    public static final String GARAGE_ADDRESS_EXTRA = "com.example.diegonarvaez.garagelist.Garage Address";
    public static final String GARAGE_DESCRIPTION_EXTRA = "com.example.diegonarvaez.garagelist.Garage Description";
    //public static final String GARAGE_CATEGORY_EXTRA = "com.example.diegonarvaez.garagelist.Garage Category";
    public static final String GARAGE_CODE_EXTRA = "com.example.diegonarvaez.garagelist.Garage Code";

    public static final String GARAGE_LAT_EXTRA = "com.example.diegonarvaez.garagelist.Garage Latitude";
    public static final String GARAGE_LNG_EXTRA = "com.example.diegonarvaez.garagelist.Garage Longitude";


    public double positionLat;
    public double positionLng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            startPlacePickerActivity();

    }

    private void startPlacePickerActivity() {
        PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();

        try {
            Intent intent = intentBuilder.build(this);
            startActivityForResult(intent, REQUEST_CODE_PLACEPICKER);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PLACEPICKER && resultCode == RESULT_OK){
            displaySelectedPlaceFromPlacePicker(data);
        }
    }

    private void displaySelectedPlaceFromPlacePicker(Intent data) {
        Place placeSelected = PlacePicker.getPlace(this, data);

        String placeName = (String) placeSelected.getName();
        String placeAddress = placeSelected.getAddress().toString();
        double placeLat = placeSelected.getLatLng().latitude;
        double placeLng = placeSelected.getLatLng().longitude;


        TextView AddressName = (TextView)findViewById(R.id.tvAddress);
        AddressName.setText(placeAddress);
        //AddressName.setText( placeName + ", " + placeAddress);
        positionLat = placeLat;
        positionLng = placeLng;
        data.putExtra("positionLat", positionLat);
        data.putExtra("positionLng", positionLng);

        //Using the method i created to communicate with the MainActivityListFragment
        setPositionCoordinates(positionLat, positionLng);

    }

    // Override methods for the search icon on right top ------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                // User chose the "Search" item, show the Search (PlacePicker Activity) UI...
                startPlacePickerActivity();

                return true;

            //case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                //return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    //---------------------------------------------------------


    public void setPositionCoordinates (double positionLat, double positionLng){

        MainActivityListFragment mainActivityListFragment = (MainActivityListFragment) getFragmentManager().findFragmentById(R.id.frMain);
        mainActivityListFragment.updateInfo(positionLat,positionLng);
    }

}
