package com.example.activite7.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.activite7.R;

public class MainActivity extends AppCompatActivity {


    Button btnStart;
    EditText nameedittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnStart = findViewById(R.id.btnStart);
        nameedittext = findViewById(R.id.nompaysEdittext);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameedittext.getText().toString();
                Toast.makeText(MainActivity.this,
                        "nom de pays "+ name, Toast.LENGTH_SHORT).show();

                startExploring(name);
            }
        });
    }

    private void startExploring(String name)
    {
        Intent intent =new Intent(this, CityActivity.class);
        intent.putExtra("country", name);
        startActivity(intent);
    }
}