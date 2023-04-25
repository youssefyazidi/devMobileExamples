package com.example.activite7.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activite7.R;
import com.example.activite7.model.City;

public class InfosActivity extends AppCompatActivity {

    City currentCity;

    TextView infosTextView;
    Button btnSiteWeb, btnSortir;
    TextView countryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);

        infosTextView = findViewById(R.id.infosTextView);
        countryTextView = findViewById(R.id.countrytext);

        btnSiteWeb = findViewById(R.id.btnSiteWeb);
        btnSortir = findViewById(R.id.btnSortir);

        Intent intent = getIntent();
        currentCity = (City) intent.getSerializableExtra("ville");

        infosTextView.setText(currentCity.getFulldesc());

        btnSiteWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InfosActivity.this,
                        ""+getResources().getString(currentCity.getSite()),
                        Toast.LENGTH_SHORT).show();

                Uri uri= Uri.parse(getResources().getString(currentCity.getSite()));
                Intent intent =new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });

        btnSortir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}