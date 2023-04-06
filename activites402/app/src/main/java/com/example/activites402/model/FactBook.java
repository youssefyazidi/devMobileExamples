package com.example.activites402.model;

import android.graphics.Color;

import java.util.Random;

public class FactBook {


    public String[] mFacts={
            "Fourmis entndent quand ils se reveillent le matin",
            "text2",
            "text3",
            "text4",
            "text5"
    };

    //Obtenir une couleur aleatoire
    public String getFact()
    {
        Random random=new Random();
        int randomNumber=random.nextInt(mFacts.length);
        return mFacts[randomNumber];
    }
}
