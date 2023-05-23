package com.example.activite7.model;

import com.example.activite7.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class ManageCities {

    private Hashtable<String, ArrayList<City>> cities= new Hashtable<>();

    //Les collections = Objet pour gerer d'autres objets (tableaux d'objets)
    //Les types de collections =
    // Les collections indexés,
    // Les collections map, Les collection Set, Les LinkedList,.....

    // indexée

    public ManageCities() {

        ArrayList<City> maroc=new ArrayList<>();

        maroc.add(new City(
                "Casablanca",
                "Maroc",
                4000000,
                R.drawable.casablanca,
                R.string.casasmalldesc,
                R.string.casafulldesc,
                R.string.sitecasa
        ));

        maroc.add(new City(
                "Rabat",
                "Maroc",
                1000000,
                R.drawable.rabat,
                R.string.rabatsmalldesc,
                R.string.rabatfulldesc,
                R.string.siterabat
        ));

        cities.put("Maroc", maroc);

        ArrayList<City> algerie=new ArrayList<>();

    }


    public City getCityByCountry(String country, int position)
    {
        if(position >= 0 && position <cities.get(country).size() )
           return cities.get(country).get(position);
        else
            return null;
    }

    public int countCitiesByCountry(String country)
    {
        //size() : compter le nombre des elements
        return cities.get(country).size();
    }
}
