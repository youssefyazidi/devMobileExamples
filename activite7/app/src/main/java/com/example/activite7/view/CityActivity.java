package com.example.activite7.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.activite7.R;
import com.example.activite7.model.City;
import com.example.activite7.model.ManageCities;

public class CityActivity extends AppCompatActivity {

    //data
    ManageCities managecities=new ManageCities();

    String countryName ="";//Le nom de pays en cours
    int currentPosition = 0;
    City currentCity;//ville en cours

    //References vers les composants
    Button btnMore, btnNext, btnBack;
    ImageView imageview;
    TextView cityNameTextView, smalldescTextView, hbTextView;
    TextView textviewnompays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        //Lier les composants
        textviewnompays = findViewById(R.id.countrytext);
        cityNameTextView = findViewById(R.id.citynametextview);
        smalldescTextView = findViewById(R.id.brefdesccitytextview);
        hbTextView = findViewById(R.id.hbtextview);

        imageview = findViewById(R.id.cityimageView);
        btnMore = findViewById(R.id.btnInfos);
        btnNext = findViewById(R.id.btnnext);
        btnBack = findViewById(R.id.btnback);

        Intent intent = getIntent();
        countryName = intent.getStringExtra("country");
        afficherVille();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPosition < managecities.countCitiesByCountry(countryName)-1)
                 currentPosition ++ ;
                afficherVille();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPosition >0)
                    currentPosition -- ;
                afficherVille();
            }
        });

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent intent=new Intent(getBaseContext(), InfosActivity.class);
                   intent.putExtra("ville", currentCity);
                   startActivity(intent);
            }
        });

    }


    private void afficherVille()
    {
        currentCity= managecities.getCityByCountry(countryName, currentPosition);
        imageview.setImageResource(currentCity.getImageId());
        cityNameTextView.setText(currentCity.getName());
        smalldescTextView.setText(currentCity.getSmalldesc());
        hbTextView.setText("Habitants : "+ currentCity.getHabitant());
        textviewnompays.setText(countryName);
    }
}