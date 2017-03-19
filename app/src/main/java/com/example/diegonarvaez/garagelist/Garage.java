package com.example.diegonarvaez.garagelist;

/**
 * Created by diegonarvaez on 20/09/16.
 */
public class Garage {
    private String address, description;
    private long garageId, dateCreatedMilli;
    private int codigo;
    private double lat;
    private double lng;
    private Category category;


    public enum Category {EXTERIOR, INTERIOR}

    public Garage (int codigo,String address, String description,Category category){
        this.address = address;
        this.description= description;
        this.category= category;
        this.garageId=0;
        this.dateCreatedMilli= 0;
        this.codigo= codigo;
    }
    public Garage (int codigo, String address, String description, double lat, double lng){
        this.address = address;
        this.description= description;
        this.garageId=0;
        this.dateCreatedMilli= 0;
        this.codigo= codigo;
        this.lat = lat;
        this.lng = lng;
    }
    //una clase Garage con 2 parametros más
    public Garage (int codigo, String address, String description, Category category, long garageId, long dateCreatedMilli){
        this.address = address;
        this.description= description;
        this.category= category;
        this.garageId= garageId;
        this.dateCreatedMilli= dateCreatedMilli;
        this.codigo = codigo;
    }

    public long getId(){
        return garageId;
    }
    public int getCodigo(){
        return codigo;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public String toString(){
        return "ID: "+ garageId + "Dirección: "+ address + "IconID: " + category.name() + "Date:" ;
    }

    //Added this later
    public double getLat(){ return lat;}
    public double getLng(){ return lng;}



    public int getAssociatedDrawable(){
        return codigoToDrawable(codigo);
    }

    public static int codigoToDrawable(int codigo){
        switch(codigo){
            case 1:
                return R.drawable.c001;
            case 2:
                return R.drawable.c002;
            case 3:
                return R.drawable.c003;
            case 4:
                return R.drawable.c004;
            case 5:
                return R.drawable.c005;
            case 6:
                return R.drawable.c006;
        }
        return R.drawable.c007;
    }
    /*
    public static int categoryToDrawable(Category noteCategory){
        switch(noteCategory){
            case EXTERIOR:
                return R.drawable.c001;
            case INTERIOR:
                return R.drawable.c002;
        }
        return R.drawable.c003;
    }
    */
}
