package com.example.diegonarvaez.garagelist;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String GARAGE_ID_EXTRA = "com.example.diegonarvaez.garagelist.Garage Indentifier";
    public static final String GARAGE_ADDRESS_EXTRA = "com.example.diegonarvaez.garagelist.Garage Address";
    public static final String GARAGE_DESCRIPTION_EXTRA = "com.example.diegonarvaez.garagelist.Garage Description";
    public static final String GARAGE_CATEGORY_EXTRA = "com.example.diegonarvaez.garagelist.Garage Category";
    public static final String GARAGE_CODE_EXTRA = "com.example.diegonarvaez.garagelist.Garage Code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
