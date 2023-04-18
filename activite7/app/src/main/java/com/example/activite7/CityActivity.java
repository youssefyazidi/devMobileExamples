package com.example.activite7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CityActivity extends AppCompatActivity {

    TextView textviewnompays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        textviewnompays = findViewById(R.id.nompaysEdittext);

        Intent intent = getIntent();
        String nompays= intent.getStringExtra("country");

        textviewnompays.setText(nompays);
    }
}