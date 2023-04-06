package com.example.activites402.model;

import android.graphics.Color;

import java.util.Random;

public class ColorWheel {

    //Tableau en Java

    public String[] mColors={
            "#39add1",
            "#3079ab",
            "#c25975",
            "#e15258",
            "#f9845b"
    };
    //Obtenir une couleur aleatoire
    public int getColor()
    {
        Random random=new Random();
        int randomNumber=random.nextInt(mColors.length);
        return Color.parseColor(mColors[randomNumber]);
    }

}
