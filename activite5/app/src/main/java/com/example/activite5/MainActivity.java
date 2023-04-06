package com.example.activite5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dessiner le layout de l'activite
        //inflate the xml into Java interface
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "appel de onCreate", Toast.LENGTH_SHORT).
                show();

        Log.i("MainActivity ","appel de onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "appel de onRestart", Toast.LENGTH_SHORT).
                show();

        Log.i("MainActivity ","appel de onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "appel de onResume", Toast.LENGTH_SHORT).
                show();

        Log.i("MainActivity ","appel de onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "appel de onPause", Toast.LENGTH_SHORT).
                show();
        Log.i("MainActivity ","appel de onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "appel de onStop", Toast.LENGTH_SHORT).
                show();
        Log.i("MainActivity ","appel de onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "appel de start", Toast.LENGTH_SHORT).
                show();
        Log.i("MainActivity ","appel de onStart");
    }
}