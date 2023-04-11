package com.example.activite6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] planets= new String[]{
                "Mercury",
            "Venus",
            "Earth",
            "Mars",
            "Jupiter",
            "Saturn",
            "Uranus",
            "Neptune"
    };

    //Referencer la liste
    ListView liste1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste1 =  findViewById(R.id.liste1);

        //Adapter predefini pour les listes simples
        ArrayAdapter adapter=new
                ArrayAdapter(this, R.layout.liste_element,planets);
        liste1.setAdapter(adapter);

    }
}