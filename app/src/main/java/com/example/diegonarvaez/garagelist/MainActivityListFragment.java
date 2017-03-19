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

    private ArrayList<Garage> garages;
    private GarageAdapter garageAdapter;

    //se ejecuta cuando el activity se crea
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);




        /*
        String[] valores = new String[]{"Linux","MacOS","Windows","Raspbian","Ubuntu","iOS"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, valores);
        setListAdapter(adaptador);
        */

        //


        //instanciamos el ArrayList que el GarageAdapter pide como parametro
        garages = new ArrayList<Garage>();
        //le añadimos items a nuestro ArrayList

        garages.add(new Garage(1,"Av Camino Real 321","Esta ubicado en el centro comercial camino real", -12.1166116,-77.009881));
        garages.add(new Garage(2,"Av Conquistadores 245","Esta ubicado a unas cuadras de Idiomas", -12.1611116,-77.019881));
        garages.add(new Garage(3,"Ca. Esquilache 211","Esta ubicado en el centro comercial camino real", -12.1311116,-77.000981));
        garages.add(new Garage(4,"Av Conquistadores 224","Esta ubicado a unas cuadras de Idiomas", -12.1311116,-77.009881));
        garages.add(new Garage(5,"Av Camino Real 721","Esta ubicado en el centro comercial camino real", -12.1311116,-77.009881));
        garages.add(new Garage(6,"Av Conquistadores 345","Esta ubicado a unas cuadras de Idiomas", -12.172042,-77.0233847));
        garages.add(new Garage(1,"Av Camino Real 390","Esta ubicado en el centro comercial camino real", -12.1311116,-77.009881));
        garages.add(new Garage(3,"Av Conquistadores 245","Esta ubicado a unas cuadras de Idiomas", -12.1311116,-77.009881));
        garages.add(new Garage(5,"Ca. Esquilache 211","Esta ubicado en el centro comercial camino real", -12.132116,-77.009661));
        garages.add(new Garage(6,"Av Conquistadores 224","Esta ubicado a unas cuadras de Idiomas", -12.1371116,-77.009881));
        garages.add(new Garage(4,"Av Camino Real 721","Esta ubicado en el centro comercial camino real", -12.1311116,-77.009881));
        garages.add(new Garage(2,"Av Conquistadores 345","Esta ubicado a unas cuadras de Idiomas", -12.1411116,-77.029881));
        garages.add(new Garage(3,"Av Juan de Arona 421", "Esta ubicado a la espalda del CC. Camino Real", -12.1344116,-77.001881));


        //instanciamos el adapter
        garageAdapter = new GarageAdapter(getActivity(),garages);
        setListAdapter(garageAdapter);

        //getListView().setDivider(ContextCompat.getDrawable(getActivity(),android.R.color.black));
        //getListView().setDividerHeight(1);
    }

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
        //intent.putExtra(MainActivity.GARAGE_CATEGORY_EXTRA,garage.getCategory());
        intent.putExtra(MainActivity.GARAGE_CODE_EXTRA,garage.getCodigo());
        intent.putExtra(MainActivity.GARAGE_ID_EXTRA,garage.getId());

        //Extras i added later -- NOT USED YET
        intent.putExtra(MainActivity.GARAGE_LAT_EXTRA,garage.getLat());
        intent.putExtra(MainActivity.GARAGE_LNG_EXTRA,garage.getLng());





        startActivity(intent);

    }

    public void updateInfo(double positionLat, double positionLng) {


    }
}
