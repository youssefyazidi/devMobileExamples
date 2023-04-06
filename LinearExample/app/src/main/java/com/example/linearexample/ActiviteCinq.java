package com.example.linearexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ActiviteCinq extends AppCompatActivity {

    ImageView image;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_cinq);

        image= findViewById(R.id.frameImage);

        text= findViewById(R.id.frameText);


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getVisibility() == FrameLayout.VISIBLE)
                {
                    text.setVisibility(FrameLayout.GONE);
                }
                else
                {
                    text.setVisibility(FrameLayout.VISIBLE);
                }
            }
        });
    }
}