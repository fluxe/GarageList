package com.example.diegonarvaez.garagelist;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private ArrayList<Garage> notFilteredGarages;

    private ArrayList<Garage> garages;
    private GarageAdapter garageAdapter;

    public int DEFAULT_DISTANCE = 9999;
    public double posLat, posLng;

    public double distance = 0;
    private double eLat,eLng;
    int i = 0;

    Garage element;

    Garage garage1,garage2 ,garage3,garage4,garage5,garage6,garage7,garage8,garage9,garage10;



    //se ejecuta cuando el activity se crea
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


        /*
        String[] valores = new String[]{"Linux","MacOS","Windows","Raspbian","Ubuntu","iOS"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, valores);
        setListAdapter(adaptador);
        */

        //instanciamos el ArrayList que el GarageAdapter pide como parametro
        garages = new ArrayList<Garage>();

        //instanciamos el ArrayList universal
        notFilteredGarages = new ArrayList<Garage>();

        //Creamos los garage objects (universo)
        garage1 = new Garage(1,"1 Av Camino Real 321","Esta ubicado en el centro comercial camino real", -12.180517,-77.0135807,DEFAULT_DISTANCE);
        garage2 = new Garage(2,"2 Av Conquistadores 245","Esta ubicado a unas cuadras de Idiomas", -12.180617,-77.0136807,DEFAULT_DISTANCE);
        garage3 = new Garage(3,"3 Ca. Esquilache 211","Esta ubicado en el centro comercial camino real",  -12.180717,-77.0137807,DEFAULT_DISTANCE);
        garage4 = new Garage(4,"4 Av Conquistadores 224","Esta ubicado a unas cuadras de Idiomas",  -12.180817,-77.0138807,DEFAULT_DISTANCE);
        garage5 = new Garage(5,"5 Av Camino Real 721","Esta ubicado en el centro comercial camino real", -12.180917,-77.0139807,DEFAULT_DISTANCE);
        garage6 = new Garage(6,"6 Av Conquistadores 345","Esta ubicado a unas cuadras de Idiomas",  -12.181017,-77.0140807,DEFAULT_DISTANCE);
        garage7 = new Garage(7,"7 Av Camino Real 390","Esta ubicado en el centro comercial camino real",  -12.181117,-77.0141807,DEFAULT_DISTANCE);
        garage8 = new Garage(8,"8 Av Conquistadores 245","Esta ubicado a unas cuadras de Idiomas",  -12.181217,-77.0142807,DEFAULT_DISTANCE);
        garage9 = new Garage(9,"9 Ca. Esquilache 211","Esta ubicado en el centro comercial camino real",  -12.181317,-77.0143807,DEFAULT_DISTANCE);
        garage10 = new Garage(10,"10 Av Conquistadores 224","Esta ubicado a unas cuadras de Idiomas",  -12.181417,-77.0144807,DEFAULT_DISTANCE);


        /* le añadimos items a nuestro ArrayList
        garages.add(garage1);
        garages.add(garage2);
        garages.add(garage3);
        garages.add(garage4);
        garages.add(garage5);
        garages.add(garage6);
        garages.add(garage7);
        */
        //Añadiendo el universo de garajes
        notFilteredGarages.add(garage1);
        notFilteredGarages.add(garage2);
        notFilteredGarages.add(garage3);
        notFilteredGarages.add(garage4);
        notFilteredGarages.add(garage5);
        notFilteredGarages.add(garage6);
        notFilteredGarages.add(garage7);




            for (i = 0 ; i < notFilteredGarages.size(); i++ ){
                distance = 0;
                element = notFilteredGarages.get(i);
                eLat = element.getLat();
                eLng = element.getLng();
                distance = getDistanceFromLatLonInKm(eLat, eLng, posLat, posLng, i);
                element.setDistance(distance);
                garages.add(element);
            }


        //filterNearbyGarages();

        //instanciamos el adapter con garajes seleccionados
        garageAdapter = new GarageAdapter(getActivity(),garages);
        setListAdapter(garageAdapter);


        /* Trying for statements
        for (i = 1 ; i < 11; i++ ){
            garages.add(garage1);
            garages.get(1);
        }
        for (Garage garage : garages){
            garages.add(garage);
        }
        */

        //getListView().setDivider(ContextCompat.getDrawable(getActivity(),android.R.color.black));
        //getListView().setDividerHeight(1);
    }

    /*private ArrayList filterNearbyGarages(ArrayList<Garage> notFilteredGarages) {

        int i;

        for(i = 0 ; i < notFilteredGarages.size(); i++){
            distance=0;
            Garage element = notFilteredGarages.get(i);
            eLat = element.getLat();
            eLng = element.getLng();
            distance = getDistanceFromLatLonInKm(eLat, eLng, posLat, posLng);
            if (distance <= 10000) {
                Log.i("INFO1", "No hay estacionamientos cerca" + i);
                garages.add(element);

            } else {
                Log.i("INFO1", "No hay estacionamientos cerca");
            }

        }
        return garages;*/

       /*for (Garage element : notFilteredGarages) {
            //double elementDistance;

            eLat = element.getLat();
            eLng = element.getLng();
            distance = getDistanceFromLatLonInKm(eLat, eLng, posLat, posLng);
            //element.setDistance(distance);
            //elementDistance = element.getDistance();

            if (distance <= 10000) {
                Log.i("INFO: ", "estacionamiento " + element.getCodigo());
                garages.add(element);

            } else {
                Log.i("INFO: ", "No hay estacionamientos cerca");
            }

        }
        return garages;

    }*/


    //se ejecuta cuando un item de la lista se presiona
    @Override
    public void onListItemClick(ListView l,View v, int position, long id){
        super.onListItemClick(l,v,position,id);

        launchGarageDetailActivity(position);
    }

    private void launchGarageDetailActivity(int position){
        //grab the garage information associated with whatever garage item we clicked on
        Garage garage = (Garage)getListAdapter().getItem(position);

        //create a new intent that launches our garageDetailActivity
        Intent intent = new Intent(getActivity(),GarageDetailActivity.class);

        //pass the info of the garage we clicked on to our garageDetailActivity
        intent.putExtra(MainActivity.GARAGE_ADDRESS_EXTRA,garage.getAddress());
        intent.putExtra(MainActivity.GARAGE_DESCRIPTION_EXTRA,garage.getDescription());
        intent.putExtra(MainActivity.GARAGE_CODE_EXTRA,garage.getCodigo());
        intent.putExtra(MainActivity.GARAGE_ID_EXTRA,garage.getId());
        //intent.putExtra(MainActivity.GARAGE_CATEGORY_EXTRA,garage.getCategory());

        //Extras i added later -- SOME NOT USED YET
        intent.putExtra(MainActivity.GARAGE_LAT_EXTRA,garage.getLat());
        intent.putExtra(MainActivity.GARAGE_LNG_EXTRA,garage.getLng());

        intent.putExtra("distance", garage.getDistance());
        intent.putExtra("posLat", posLat);
        intent.putExtra("posLng", posLng);
        intent.putExtra("eLat", eLat);
        intent.putExtra("eLng", eLng);


        startActivity(intent);

    }

    //Getting PlacePicker selected place position from MainActivity
    public void getPositionCoordinates(double positionLat, double positionLng) {
        //Setting our local variables (posLat and posLng)
        posLat = positionLat;
        posLng = positionLng;

    }
/*
    public double getDistanceFromLatLonInKm(double lat1, double lng1, double lat2, double lng2) {
        double p, a;

        p = 0.017453292519943295;    // Math.PI / 180
        a = 0.5 - Math.cos((lat2 - lat1) * p)/2 +
                Math.cos(lat1 * p) * Math.cos(lat2 * p) *
                        (1 - Math.cos((lng2 - lng1) * p))/2;

        return 12742 * Math.asin(Math.sqrt(a)); // 2 * R; R = 6371 km
    }

    *//*
    private double getDistanceFromLatLonInKm(double lat1, double lng1, double lat2, double lng2) {
        double d, dLat, dLng, a, c;

        int R = 6371; // Radius of the earth in km
        dLat = deg2rad(lat2-lat1);  // deg2rad below
        dLng = deg2rad(lng2-lng1);
        a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(dLng/2) * Math.sin(dLng/2);
        c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        d = R * c; // Distance in km
        return d;
    }
    private double deg2rad (double deg){
        return deg * (Math.PI/180);
    }
    */
    private double getDistanceFromLatLonInKm(double lat1, double lng1, double lat2, double lng2, int position) {
        double p,e,a,b,c,d,compound;
        p = 0.017453292519943295;    // Math.PI / 180

        a=lat1*p;
        b=lng1*p;
        c=lat2*p;
        d=lng2*p;

        compound = Math.pow(a-c,2)+Math.pow(b-d,2);
        e = Math.sqrt(compound);


        return e;
    }
}
