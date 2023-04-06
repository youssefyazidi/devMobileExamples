package com.example.activites402;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.activites402.model.ColorWheel;
import com.example.activites402.model.FactBook;

public class MainActivity extends AppCompatActivity {

    ColorWheel colorWhel =new ColorWheel();
    FactBook facts=new FactBook();

    //Referencer les composants

    TextView factTextView;
    Button showFactButtoon;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        factTextView = findViewById(R.id.dactTextView);
        showFactButtoon = findViewById(R.id.showFactButton);
        relativeLayout = findViewById(R.id.relativelayout);

        showFactButtoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fact = facts.getFact();
                int couleur= colorWhel.getColor();

                    factTextView.setText(fact);
                    relativeLayout.setBackgroundColor(couleur);
            }
        });
    }
}