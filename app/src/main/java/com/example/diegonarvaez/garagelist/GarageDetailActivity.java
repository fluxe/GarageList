package com.example.diegonarvaez.garagelist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GarageDetailActivity extends AppCompatActivity {


    private ImageView ivDetailGaragePhoto;
    private TextView tvDetailAddress;
    private Button butGoWithWaze;


    private String mAddress;
    private int mCodigo;
    private String mDescription;

    private double mLat;
    private double mLng;

    //private Garage.Category mCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_detail);

        //Instancing
        ivDetailGaragePhoto = (ImageView)findViewById(R.id.ivDetailGaragePhoto);
        tvDetailAddress = (TextView)findViewById(R.id.tvDetailAddress);
        butGoWithWaze = (Button)findViewById(R.id.butGoWithWaze);


        //Getting the data from intents
        mAddress = getIntent().getStringExtra(MainActivity.GARAGE_ADDRESS_EXTRA);
        mCodigo = getIntent().getIntExtra(MainActivity.GARAGE_CODE_EXTRA,1);
        mDescription = getIntent().getStringExtra(MainActivity.GARAGE_DESCRIPTION_EXTRA);

        mLat = getIntent().getDoubleExtra(MainActivity.GARAGE_LAT_EXTRA,1);
        mLng = getIntent().getDoubleExtra(MainActivity.GARAGE_LNG_EXTRA,1);

        //prueba de position LatLng
        getIntent().getDoubleExtra("positionLat",1);
        getIntent().getDoubleExtra("positionLng",1);

        //mCategory = Garage.Category.EXTERIOR;



        //Creating the garage object that will represent the displayed garage and passing the intent data to it
        Garage displayedGarage;
        displayedGarage = new Garage(mCodigo, mAddress, mDescription, mLat,mLng);


        //Setting the selected garage values
        tvDetailAddress.setText(displayedGarage.getAddress());
        ivDetailGaragePhoto.setImageResource(displayedGarage.getAssociatedDrawable());


        //Waze button functionality
        butGoWithWaze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRouteOnWaze(mLat, mLng);
            }
        });



    }

    private void showRouteOnWaze(double mLat, double mLng) {
        String uri =  "waze://?ll=" + mLat + "," + mLng + "&navigate=yes";
        startActivity(new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(uri)));
    }
}
